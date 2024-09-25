package co.edu.uniquindio.poo;

import java.util.Date;
import java.util.List;

public class Prestamo {
    private String codigo;
    private Date fechaPrestamo;
    private Date fechaEntrega;
    private double costo;
    private Bibliotecario bibliotecario;
    private Estudiante estudiante;
    private List<DetallePrestamo> detallePrestamos;

    // Constructor
    public Prestamo(String codigo, Date fechaPrestamo, Date fechaEntrega, Bibliotecario bibliotecario, Estudiante estudiante, List<DetallePrestamo> detallePrestamos) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.bibliotecario = bibliotecario;
        this.estudiante = estudiante;
        this.detallePrestamos = detallePrestamos;
        this.costo = calcularCosto();
    }

    /**
     * @return
     */
    public final double calcularCosto() {
        double total = 0;
        for (DetallePrestamo detalle : detallePrestamos) {
            //total += detalle.getCantidad() * detalle.getLibro().consultarDisponibilidad() ? 10 : 0; // Precio fijo por libro
        }
        return total;
    }

    public void entregarPrestamo() {
        // Lógica de entrega del préstamo
    }

    public List<DetallePrestamo> getDetallePrestamos() {
        return detallePrestamos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setDetallePrestamos(List<DetallePrestamo> detallePrestamos) {
        this.detallePrestamos = detallePrestamos;
    }
}
