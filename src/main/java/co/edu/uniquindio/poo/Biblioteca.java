package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    private double totalDineroRecaudo;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private Collection<Libro> libros;
    private Collection<Estudiante> estudiantes;

    public Biblioteca(String nombre, double totalDineroRecaudo) {
        this.nombre = nombre;
        this.totalDineroRecaudo = totalDineroRecaudo;
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
        estudiantes = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotalDineroRecaudo() {
        return totalDineroRecaudo;
    }

    public void setTotalDineroRecaudo(double totalDineroRecaudo) {
        this.totalDineroRecaudo = totalDineroRecaudo;
    }

    public Collection<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(Collection<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Collection<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }

    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        bibliotecarios.add(bibliotecario);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro consultarLibroPorCodigo(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro
    }

    
    public int contarPrestamosPorNombreLibro(String titulo) {
        int cantidadPrestamos = 0;
        for (Prestamo prestamo : prestamos) {
            for (DetallePrestamo detalle : prestamo.getDetallePrestamos()) {
                if (detalle.getLibro().getTitulo().equals(titulo)) {
                    cantidadPrestamos++;
                }
            }
        }
        return cantidadPrestamos;
    }

    public void reemplazarLibro(String codigo, Libro nuevoLibro) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                libros.remove(libro);
                libros.add(nuevoLibro);
                break;
            }
        }
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
        prestamo.getBibliotecario().getPrestamos().add(prestamo);
        prestamo.getEstudiante().getPrestamos().add(prestamo);
    }

    public void adicionarLibroAlPrestamo(Prestamo prestamo, Libro libro, int cantidad) {
        if (libro.getUnidadesDisponibles() >= cantidad) {
            libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() - cantidad);
            if (libro.getUnidadesDisponibles() == 0) {
                libro.setEstado(false);
            }
            DetallePrestamo detalle = new DetallePrestamo(cantidad, prestamo, libro);
            prestamo.getDetallePrestamos().add(detalle);
        }
    }

    public double entregarPrestamo(Prestamo prestamo) {
        LocalDate fechaPrestamo = prestamo.getFechaPrestamo();
        LocalDate fechaEntrega = prestamo.getFechaEntrega();
        long diasPrestamo = java.time.temporal.ChronoUnit.DAYS.between(fechaPrestamo, fechaEntrega);
        
        double costo = prestamo.calcularTotal() * diasPrestamo;
        
        for (DetallePrestamo detalle : prestamo.getDetallePrestamos()) {
            Libro libro = detalle.getLibro();
            libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() + detalle.getCantidad());
            if (libro.getUnidadesDisponibles() > 0) {
                libro.setEstado(true);
            }
        }
        return costo;
    }

    public Prestamo consultarPrestamoPorCodigo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                return prestamo;
            }
        }
        return null; // Si no se encuentra el préstamo
    }

    public int contarPrestamosPorBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecario.getPrestamos().size();
    }

    public Estudiante obtenerEstudianteConMasPrestamos() {
        Estudiante mayorPrestamos = null;
        int maxPrestamos = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getPrestamos().size() > maxPrestamos) {
                maxPrestamos = estudiante.getPrestamos().size();
                mayorPrestamos = estudiante;
            }
        }
        return mayorPrestamos;
    }
    
    public double calcularTotalDineroRecaudado() {
        double totalRecaudado = 0;
        for (Prestamo prestamo : prestamos) {
            totalRecaudado += prestamo.getTotal();
        }
        return totalRecaudado;
    }

    public double calcularPagoBibliotecario(Bibliotecario bibliotecario) {
        double totalPago = 0;
        LocalDate hoy = LocalDate.now();
        for (Prestamo prestamo : bibliotecario.getPrestamos()) {
            totalPago += prestamo.getTotal() * 0.20;
        }
        long antiguedad = java.time.temporal.ChronoUnit.YEARS.between(bibliotecario.getFechaIngreso(), hoy);
        totalPago += totalPago * (antiguedad * 0.02);
        return totalPago;
    }
    

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", totalDineroRecaudo=" + totalDineroRecaudo + ", bibliotecarios="
                + bibliotecarios + ", prestamos=" + prestamos + ", libros=" + libros + ", estudiantes=" + estudiantes
                + "]";
    }

}