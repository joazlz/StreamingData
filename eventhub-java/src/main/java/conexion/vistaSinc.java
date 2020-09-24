package conexion;

public class vistaSinc {
    private int filas;
    private String nombre;

    public vistaSinc( String nombre,int filas) {
        this.filas = filas;
        this.nombre = nombre;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
