import java.util.Scanner;

public class menu {
    private Scanner scanner;
    private vectores vector;
    private Matriz matriz;

    public menu(int tamanio) {
        this.vector = new vectores(tamanio);
        this.matriz = new Matriz(3, 3); 
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcionPrincipal;

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN =====");
            System.out.println("1. Trabajar con Vector");
            System.out.println("2. Trabajar con Matriz");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcionPrincipal = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcionPrincipal) {
                case 1 -> menuVector();
                case 2 -> menuMatriz();
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcionPrincipal != 3);
    }

   
    private void menuVector() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ VECTOR ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarPersonaVector();
                case 2 -> vector.mostrarVector();
                case 3 -> eliminarPersonaVector();
                case 4 -> buscarPersonaVector();
                case 5 -> System.out.println("↩ Volviendo al menú principal...");
                default -> System.out.println(" Opción no válida.");
            }
        } while (opcion != 5);
    }


    private void menuMatriz() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ MATRIZ ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar matriz");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Promedio de peso (diagonal principal)");
            System.out.println("6. Promedio de altura (diagonal secundaria)");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarPersonaMatriz();
                case 2 -> matriz.mostrarMatriz();
                case 3 -> eliminarPersonaMatriz();
                case 4 -> buscarPersonaMatriz();
                case 5 -> matriz.promedioPesoDiagonalPrincipal();
                case 6 -> matriz.promedioAlturaDiagonalSecundaria();
                case 7 -> System.out.println(" Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }

   
    private void agregarPersonaVector() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Peso (kg): ");
        float peso = scanner.nextFloat();
        System.out.print("Altura (m): ");
        float altura = scanner.nextFloat();
        scanner.nextLine();

        persona p = new persona(nombre, apellido, peso, altura);
        vector.agregarPersona(p);
    }

    private void eliminarPersonaVector() {
        System.out.print("Ingrese la posición a eliminar: ");
        int pos = scanner.nextInt();
        vector.eliminarPersona(pos);
    }

    private void buscarPersonaVector() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = scanner.nextLine();
        vector.buscarPersona(nombre);
    }


    private void agregarPersonaMatriz() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Peso (kg): ");
        float peso = scanner.nextFloat();
        System.out.print("Altura (m): ");
        float altura = scanner.nextFloat();
        scanner.nextLine();

        persona p = new persona(nombre, apellido, peso, altura);
        matriz.agregarPersona(p);
    }

    private void eliminarPersonaMatriz() {
        System.out.print("Ingrese la fila: ");
        int fila = scanner.nextInt();
        System.out.print("Ingrese la columna: ");
        int columna = scanner.nextInt();
        matriz.eliminarPersona(fila, columna);
    }

    private void buscarPersonaMatriz() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = scanner.nextLine();
        matriz.buscarPersona(nombre);
    }
}