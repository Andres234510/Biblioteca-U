package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Bibliotecario> bibliotecarios;
    private List<Estudiante> estudiantes;
    private List<Libro> libros;
    private List<Prestamo> prestamos;
    private double totalDineroRecaudado;

    // Constructor
    public Biblioteca() {
        this.bibliotecarios = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.totalDineroRecaudado = 0;
    }

    public void agregarBibliotecario(Bibliotecario biblio) {
        bibliotecarios.add(biblio);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void registrarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
        totalDineroRecaudado += prestamo.calcularCosto();
    }

    public double calcularTotalDineroRecaudado() {
        return totalDineroRecaudado;
    }

    public Estudiante generarReporteEstudianteConMasPrestamos() {
        Estudiante topEstudiante = null;
        int maxPrestamos = 0;
        for (Estudiante est : estudiantes) {
            if (est.consultarPrestamos().size() > maxPrestamos) {
                maxPrestamos = est.consultarPrestamos().size();
                topEstudiante = est;
            }
        }
        return topEstudiante;
    }

    public List<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(List<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public double getTotalDineroRecaudado() {
        return totalDineroRecaudado;
    }

    public void setTotalDineroRecaudado(double totalDineroRecaudado) {
        this.totalDineroRecaudado = totalDineroRecaudado;
    }
}

