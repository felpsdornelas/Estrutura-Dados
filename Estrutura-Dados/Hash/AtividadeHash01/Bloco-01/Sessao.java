import java.util.Objects;

public class Sessao {
    private final String token;

    public Sessao(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sessao)) return false;

        Sessao s = (Sessao) o;
        return Objects.equals(token, s.token);
    }
}