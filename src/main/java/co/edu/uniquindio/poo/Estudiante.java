package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {
    private List<Prestamo> prestamosRealizados;

    // Constructor
    public Estudiante(String nombre, String cedula, String telefono, String correo) {
        super(nombre, cedula, telefono, correo);
        this.prestamosRealizados = new ArrayList<>();
    }

    public void solicitarPrestamo(Prestamo prestamo) {
        prestamosRealizados.add(prestamo);
    }

    public List<Prestamo> consultarPrestamos() {
        return prestamosRealizados;
    }
}
