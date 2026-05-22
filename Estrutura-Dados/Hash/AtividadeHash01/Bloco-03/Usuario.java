public class Usuario {

    private long id;
    private String perfil;

    public Usuario(long id, String perfil) {
        this.id = id;
        this.perfil = perfil;
    }

    public long getId() {
        return id;
    }

    public String getPerfil() {
        return perfil;
    }
}