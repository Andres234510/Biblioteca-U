package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Persona {
    private double salario;
    private int antiguedad;
    private List<Prestamo> prestamosRealizados;

    // Constructor
    public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salario, int antiguedad) {
        super(nombre, cedula, telefono, correo);
        this.salario = salario;
        this.antiguedad = antiguedad;
        this.prestamosRealizados = new ArrayList<>();
    }

    // Método para calcular el pago
    public double calcularPago() {
        // Ejemplo: pago base más una bonificación por antigüedad
        return salario + (antiguedad * 50); // Fórmula simple de pago
    }

    public void realizarPrestamo(Prestamo prestamo) {
        prestamosRealizados.add(prestamo);
    }

    public List<Prestamo> getPrestamosRealizados() {
        return prestamosRealizados;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setPrestamosRealizados(List<Prestamo> prestamosRealizados) {
        this.prestamosRealizados = prestamosRealizados;
    }
}
