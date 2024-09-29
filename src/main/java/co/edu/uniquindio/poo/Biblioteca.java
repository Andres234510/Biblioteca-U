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

    
    /**
     * Metodo para consultatar un libro el codigo
     * @param codigo
     * @return El nombre del libro al que le perteneceel codigo
     */
    public Libro consultarLibroPorCodigo(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro
    }

    
    /**
     * Metodo para contar Prestamos Por Nombre Libro 
     * @param titulo
     * @return la cantida de prestamos
     */
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

    /**
     * Metodo para remplazar un libro
     * @param codigo
     * @param nuevoLibro
     */
    public void reemplazarLibro(String codigo, Libro nuevoLibro) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                libros.remove(libro);
                libros.add(nuevoLibro);
                break;
            }
        }
    }

    /**
     * Metodo oara agregar un prestamo
     * @param prestamo
     */
    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
        prestamo.getBibliotecario().getPrestamos().add(prestamo);
        prestamo.getEstudiante().getPrestamos().add(prestamo);
    }

    /**
     * Metodo para agregar un libro al prestamo
     * @param prestamo
     * @param libro
     * @param cantidad
     */
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

    /**
     * Metodo para entregar el prestamo
     * @param prestamo
     * @return
     */
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

    /**
     * Metodo consultar Prestamo Por Codigo
     * @param codigo
     * @return la info del prestamo segun el codigo
     */
    public Prestamo consultarPrestamoPorCodigo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                return prestamo;
            }
        }
        return null; // Si no se encuentra el préstamo
    }

    /**
     * MEtodo para contar Prestamos Por Bibliotecario
     * @param bibliotecario
     * @return LOs prestamos hechos
     */
    public int contarPrestamosPorBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecario.getPrestamos().size();
    }

    /**
     * Metodo para obtener Estudiante Con Mas Prestamos
     * @return Un estudiante con mayor prestamos
     */
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
    
    /**
     * Metodo para calcular Total Dinero Recaudado
     * @return totalRecaudado
     */
    public double calcularTotalDineroRecaudado() {
        double totalRecaudado = 0;
        for (Prestamo prestamo : prestamos) {
            totalRecaudado += prestamo.getTotal();
        }
        return totalRecaudado;
    }

    /**
     * MEtodo para calcular Pago Bibliotecario
     * @param bibliotecario
     * @return Total pago
     */
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