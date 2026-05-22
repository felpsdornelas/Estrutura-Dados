import java.util.Objects;

public class Coordenada {
    public double lat;
    public double lon;

    public Coordenada(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordenada)) return false;

        Coordenada c = (Coordenada) o;

        return Double.compare(lat, c.lat) == 0 &&
               Double.compare(lon, c.lon) == 0;
    }
}