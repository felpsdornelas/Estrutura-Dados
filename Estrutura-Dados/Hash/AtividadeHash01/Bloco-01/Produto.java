import java.util.Objects;

public class Produto {
    private String sku;
    private String nome;

    public Produto(String sku, String nome) {
        this.sku = sku;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;

        Produto p = (Produto) o;
        return Objects.equals(sku, p.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}