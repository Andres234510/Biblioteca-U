package co.edu.uniquindio.poo;

public class DetallePrestamo {
    private int cantidad;
    private Libro libro;

    // Constructor
    public DetallePrestamo(int cantidad, Libro libro) {
        this.cantidad = cantidad;
        this.libro = libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
