public class GerenciadorSessao {

    private final TabelaHashEncadeada<String, Usuario> sessoes;

    public GerenciadorSessao() {

        /*
         Capacidade inicial escolhida:
         32 buckets.

         Justificativa:
         - reduz colisões iniciais;
         - suporta crescimento moderado;
         - mantém fator de carga baixo.
        */

        this.sessoes = new TabelaHashEncadeada<>(32);
    }

    // Registra nova sessão.
    // Lança IllegalArgumentException se token for nulo ou vazio.
    public void registrar(String token, Usuario usuario) {

        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException(
                    "Token não pode ser nulo ou vazio"
            );
        }

        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Usuário não pode ser null"
            );
        }

        sessoes.put(token, usuario);
    }

    // Retorna o Usuario ou null se a sessão não existir.
    public Usuario buscar(String token) {

        if (token == null || token.isBlank()) {
            return null;
        }

        return sessoes.get(token);
    }

    // Remove a sessão.
    // Retorna true se existia, false se já estava expirada/inválida.
    public boolean invalidar(String token) {

        if (token == null || token.isBlank()) {
            return false;
        }

        return sessoes.remove(token);
    }

    // Retorna true se o token ainda é válido.
    public boolean eValido(String token) {

        if (token == null || token.isBlank()) {
            return false;
        }

        return buscar(token) != null;
    }
}