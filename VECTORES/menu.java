import java.util.Scanner;

public class menu {
    private vectores vector;
    private Scanner scanner;

    // Constructor
    public menu(int tamanio) {
        this.vector = new vectores(tamanio);
        this.scanner = new Scanner(System.in);
    }

    // Mostrar menú principal
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE PERSONAS ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }

            opcion = scanner.nextInt();
            ejecutarOpcion(opcion);
        } while (opcion != 5);

        System.out.println("Saliendo del sistema...");
    }

    // Ejecutar opción seleccionada
    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarPersona();
                break;
            case 2:
                vector.mostrarVector();
                break;
            case 3:
                eliminarPersona();
                break;
            case 4:
                buscarPersona();
                break;
            case 5:
                break; // Salir
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void agregarPersona() {
        if (!vector.vectorLleno()) {
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.next();
            System.out.print("Ingrese el apellido: ");
            String apellido = scanner.next();
            System.out.print("Ingrese el peso: ");
            float peso = leerFloat();
            System.out.print("Ingrese la altura: ");
            float altura = leerFloat();

            persona p = new persona(nombre, apellido, peso, altura);
            vector.agregarPersona(p);
        } else {
            System.out.println("El vector está lleno.");
        }
    }

    private void eliminarPersona() {
        if (!vector.vectorVacio()) {
            System.out.print("Ingrese la posición a eliminar (0 a " + vector.getIndice() + "): ");
            int posicion = leerEntero();
            vector.eliminarPersona(posicion);
        } else {
            System.out.println("El vector está vacío.");
        }
    }

    private void buscarPersona() {
        if (!vector.vectorVacio()) {
            System.out.print("Ingrese el nombre a buscar: ");
            String nombre = scanner.next();
            int pos = vector.buscarPersona(nombre);
            if (pos != -1) {
                System.out.println("Persona encontrada en la posición: " + pos);
            }
        } else {
            System.out.println("El vector está vacío.");
        }
    }

    private float leerFloat() {
        while (!scanner.hasNextFloat()) {
            System.out.print("Por favor, ingrese un número decimal válido: ");
            scanner.next();
        }
        return scanner.nextFloat();
    }

    private int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número entero válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}