package co.edu.uniquindio.subasta.model;

public class Anuncio {
    private  String nombre;
    private  String codigo;

    public Anuncio() {}

    public Anuncio(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anuncio anuncio)) return false;

        if (!nombre.equals(anuncio.nombre)) return false;
        return codigo.equals(anuncio.codigo);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + codigo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
