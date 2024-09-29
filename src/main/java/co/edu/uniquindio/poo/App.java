package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        // Crear una instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", 0.0);
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Administrar Bibliotecarios");
            System.out.println("2. Administrar Estudiantes");
            System.out.println("3. Administrar Libros");
            System.out.println("4. Administrar Préstamos");
            System.out.println("5. Reportes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    administrarBibliotecarios(biblioteca, scanner);
                    break;
                case 2:
                    administrarEstudiantes(biblioteca, scanner);
                    break;
                case 3:
                    administrarLibros(biblioteca, scanner);
                    break;
                case 4:
                    administrarPrestamos(biblioteca, scanner);
                    break;
                case 5:
                    generarReportes(biblioteca);
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        scanner.close();
    }

    // Métodos del menú para gestionar cada opción

    private static void administrarBibliotecarios(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\n--- Administrar Bibliotecarios ---");
        System.out.println("1. Crear nuevo bibliotecario");
        System.out.println("2. Mostrar bibliotecarios");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre del bibliotecario: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese la cédula: ");
                String cedula = scanner.nextLine();
                System.out.print("Ingrese el teléfono: ");
                int telefono = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Ingrese el correo: ");
                String correo = scanner.nextLine();
                System.out.print("Ingrese el salario: ");
                double salario = scanner.nextDouble();
                System.out.print("Ingrese la fecha de ingreso (yyyy-mm-dd): ");
                String fechaIngresoStr = scanner.next();
                LocalDate fechaIngreso = LocalDate.parse(fechaIngresoStr);

                Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, correo, telefono, salario, fechaIngreso);
                biblioteca.agregarBibliotecario(bibliotecario);
                System.out.println("Bibliotecario agregado exitosamente.");
                break;

            case 2:
                System.out.println("Lista de bibliotecarios:");
                for (Bibliotecario biblio : biblioteca.getBibliotecarios()) {
                    System.out.println(biblio);
                }
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void administrarEstudiantes(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\n--- Administrar Estudiantes ---");
        System.out.println("1. Crear nuevo estudiante");
        System.out.println("2. Mostrar estudiantes");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre del estudiante: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese la cédula: ");
                String cedula = scanner.nextLine();
                System.out.print("Ingrese el teléfono: ");
                int telefono = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                System.out.print("Ingrese el correo: ");
                String correo = scanner.nextLine();
                System.out.print("Ingrese el estado (true para activo, false para inactivo): ");
                boolean estado = scanner.nextBoolean();

                Estudiante estudiante = new Estudiante(nombre, cedula, correo, telefono, estado);
                biblioteca.agregarEstudiante(estudiante);
                System.out.println("Estudiante agregado exitosamente.");
                break;

            case 2:
                System.out.println("Lista de estudiantes:");
                for (Estudiante est : biblioteca.getEstudiantes()) {
                    System.out.println(est);
                }
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void administrarLibros(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\n--- Administrar Libros ---");
        System.out.println("1. Crear nuevo libro");
        System.out.println("2. Consultar libro por código");
        System.out.println("3. Contar préstamos de un libro");
        System.out.println("4. Reemplazar libro");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el código del libro: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese el ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Ingrese el autor: ");
                String autor = scanner.nextLine();
                System.out.print("Ingrese el título: ");
                String titulo = scanner.nextLine();
                System.out.print("Ingrese la editorial: ");
                String editorial = scanner.nextLine();
                System.out.print("Ingrese la fecha de publicación (yyyy-mm-dd): ");
                String fechaPublicacionStr = scanner.next();
                LocalDate fechaPublicacion = LocalDate.parse(fechaPublicacionStr);
                System.out.print("Ingrese las unidades disponibles: ");
                int unidadesDisponibles = scanner.nextInt();
                System.out.print("Ingrese el precio: ");
                double precio = scanner.nextDouble();

                Libro libro = new Libro(codigo, isbn, autor, titulo, editorial, unidadesDisponibles, fechaPublicacion, precio);
                biblioteca.agregarLibro(libro);
                System.out.println("Libro agregado exitosamente.");
                break;

            case 2:
                System.out.print("Ingrese el código del libro a consultar: ");
                String codigoConsulta = scanner.nextLine();
                Libro libroConsultado = biblioteca.consultarLibroPorCodigo(codigoConsulta);
                if (libroConsultado != null) {
                    System.out.println(libroConsultado);
                } else {
                    System.out.println("Libro no encontrado.");
                }
                break;

            case 3:
                System.out.print("Ingrese el nombre del libro para contar préstamos: ");
                String nombreLibro = scanner.nextLine();
                int cantidadPrestamos = biblioteca.contarPrestamosPorNombreLibro(nombreLibro);
                System.out.println("El libro ha sido prestado " + cantidadPrestamos + " veces.");
                break;

            case 4:
                System.out.print("Ingrese el código del libro a reemplazar: ");
                String codigoReemplazo = scanner.nextLine();
                System.out.print("Ingrese los nuevos datos del libro (ISBN, autor, título, editorial, fecha, unidades, precio): ");
                // Obtener nuevos datos del libro como en el caso 1
                System.out.print("Ingrese el ISBN: ");
                String nuevoIsbn = scanner.nextLine();
                System.out.print("Ingrese el autor: ");
                String nuevoAutor = scanner.nextLine();
                System.out.print("Ingrese el título: ");
                String nuevoTitulo = scanner.nextLine();
                System.out.print("Ingrese la editorial: ");
                String nuevaEditorial = scanner.nextLine();
                System.out.print("Ingrese la fecha de publicación (yyyy-mm-dd): ");
                String nuevaFechaPublicacionStr = scanner.next();
                LocalDate nuevaFechaPublicacion = LocalDate.parse(nuevaFechaPublicacionStr);
                System.out.print("Ingrese las unidades disponibles: ");
                int nuevasUnidadesDisponibles = scanner.nextInt();
                System.out.print("Ingrese el precio: ");
                double nuevoPrecio = scanner.nextDouble();

                Libro nuevoLibro = new Libro(codigoReemplazo, nuevoIsbn, nuevoAutor, nuevoTitulo, nuevaEditorial, nuevasUnidadesDisponibles, nuevaFechaPublicacion, nuevoPrecio);
                biblioteca.reemplazarLibro(codigoReemplazo, nuevoLibro);
                System.out.println("Libro reemplazado exitosamente.");
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void administrarPrestamos(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\n--- Administrar Préstamos ---");
        System.out.println("1. Crear nuevo préstamo");
        System.out.println("2. Adicionar libro al préstamo");
        System.out.println("3. Entregar préstamo");
        System.out.println("4. Consultar préstamo por código");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
    
        switch (opcion) {
            case 1:
                // Crear un nuevo préstamo
                System.out.print("Ingrese el código del préstamo: ");
                String codigoPrestamo = scanner.nextLine();
                System.out.print("Ingrese la fecha de préstamo (yyyy-mm-dd): ");
                LocalDate fechaPrestamo = LocalDate.parse(scanner.nextLine());
                System.out.print("Ingrese la fecha de entrega (yyyy-mm-dd): ");
                LocalDate fechaEntrega = LocalDate.parse(scanner.nextLine());
                
                System.out.println("Seleccione el bibliotecario que realiza el préstamo: ");
                for (Bibliotecario bibliotecario : biblioteca.getBibliotecarios()) {
                    System.out.println(bibliotecario.getCedula() + ": " + bibliotecario.getNombre());
                }
                System.out.print("Ingrese la cédula del bibliotecario: ");
                String cedulaBibliotecario = scanner.nextLine();
                Bibliotecario bibliotecario = buscarBibliotecarioPorCedula(biblioteca, cedulaBibliotecario);
    
                System.out.println("Seleccione el estudiante que realiza el préstamo: ");
                for (Estudiante estudiante : biblioteca.getEstudiantes()) {
                    System.out.println(estudiante.getCedula() + ": " + estudiante.getNombre());
                }
                System.out.print("Ingrese la cédula del estudiante: ");
                String cedulaEstudiante = scanner.nextLine();
                Estudiante estudiante = buscarEstudiantePorCedula(biblioteca, cedulaEstudiante);
    
                if (bibliotecario != null && estudiante != null) {
                    Prestamo prestamo = new Prestamo(codigoPrestamo, fechaPrestamo, fechaEntrega, bibliotecario, estudiante);
                    biblioteca.agregarPrestamo(prestamo);
                    System.out.println("Préstamo creado exitosamente.");
                } else {
                    System.out.println("Bibliotecario o estudiante no encontrado.");
                }
                break;
    
            case 2:
                // Adicionar libro a un préstamo
                System.out.print("Ingrese el código del préstamo: ");
                String codigoPr = scanner.nextLine();
                Prestamo prestamoSeleccionado = biblioteca.consultarPrestamoPorCodigo(codigoPr);
                if (prestamoSeleccionado != null) {
                    System.out.println("Seleccione el libro a adicionar: ");
                    for (Libro libro : biblioteca.getLibros()) {
                        System.out.println(libro.getCodigo() + ": " + libro.getTitulo());
                    }
                    System.out.print("Ingrese el código del libro: ");
                    String codigoLibro = scanner.nextLine();
                    Libro libroSeleccionado = biblioteca.consultarLibroPorCodigo(codigoLibro);
    
                    if (libroSeleccionado != null && libroSeleccionado.getUnidadesDisponibles() > 0) {
                        System.out.print("Ingrese la cantidad de unidades a adicionar: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        biblioteca.adicionarLibroAlPrestamo(prestamoSeleccionado, libroSeleccionado, cantidad);
                        System.out.println("Libro adicionado al préstamo.");
                    } else {
                        System.out.println("Libro no encontrado o sin unidades disponibles.");
                    }
                } else {
                    System.out.println("Préstamo no encontrado.");
                }
                break;
    
            case 3:
                // Entregar préstamo
                System.out.print("Ingrese el código del préstamo a entregar: ");
                String codigoEntrega = scanner.nextLine();
                Prestamo prestamoAEntregar = biblioteca.consultarPrestamoPorCodigo(codigoEntrega);
                if (prestamoAEntregar != null) {
                    double costoTotal = biblioteca.entregarPrestamo(prestamoAEntregar);
                    System.out.println("Préstamo entregado. Costo total del préstamo: $" + costoTotal);
                } else {
                    System.out.println("Préstamo no encontrado.");
                }
                break;
    
            case 4:
                // Consultar préstamo por código
                System.out.print("Ingrese el código del préstamo: ");
                String codigoConsulta = scanner.nextLine();
                Prestamo prestamoConsultado = biblioteca.consultarPrestamoPorCodigo(codigoConsulta);
                if (prestamoConsultado != null) {
                    System.out.println(prestamoConsultado);
                } else {
                    System.out.println("Préstamo no encontrado.");
                }
                break;
    
            default:
                System.out.println("Opción no válida.");
        }
    }
    
    // Métodos auxiliares para buscar bibliotecarios y estudiantes por cédula
    private static Bibliotecario buscarBibliotecarioPorCedula(Biblioteca biblioteca, String cedula) {
        for (Bibliotecario bibliotecario : biblioteca.getBibliotecarios()) {
            if (bibliotecario.getCedula().equals(cedula)) {
                return bibliotecario;
            }
        }
        return null;
    }
    
    private static Estudiante buscarEstudiantePorCedula(Biblioteca biblioteca, String cedula) {
        for (Estudiante estudiante : biblioteca.getEstudiantes()) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }
    



    private static void generarReportes(Biblioteca biblioteca) {
        System.out.println("\n--- Reportes ---");
        System.out.println("1. Estudiante con más préstamos");
        System.out.println("2. Total dinero recaudado");
        System.out.println("3. Total a pagar a bibliotecarios");
        System.out.print("Seleccione una opción: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                Estudiante estudianteConMasPrestamos = biblioteca.obtenerEstudianteConMasPrestamos();
                if (estudianteConMasPrestamos != null) {
                    System.out.println("Estudiante con más préstamos: " + estudianteConMasPrestamos);
                } else {
                    System.out.println("No hay estudiantes con préstamos.");
                }
                break;

            case 2:
                double totalRecaudado = biblioteca.calcularTotalDineroRecaudado();
                System.out.println("Total dinero recaudado: $" + totalRecaudado);
                break;

            case 3:
                System.out.println("Pago total a bibliotecarios:");
                for (Bibliotecario bibliotecario : biblioteca.getBibliotecarios()) {
                    double pago = biblioteca.calcularPagoBibliotecario(bibliotecario);
                    System.out.println(bibliotecario.getNombre() + ": $" + pago);
                }
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }
}

