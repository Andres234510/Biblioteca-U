package co.edu.uniquindio.poo;

public class Libro {
    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private int unidadesDisponibles;

    // Constructor
    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, int unidadesDisponibles) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public boolean consultarDisponibilidad() {
        return unidadesDisponibles > 0;
    }

    public void reemplazarLibro(Libro nuevoLibro) {
        this.codigo = nuevoLibro.codigo;
        this.isbn = nuevoLibro.isbn;
        this.autor = nuevoLibro.autor;
        this.titulo = nuevoLibro.titulo;
        this.editorial = nuevoLibro.editorial;
        this.unidadesDisponibles = nuevoLibro.unidadesDisponibles;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }
}
