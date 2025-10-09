import java.util.Scanner;

public class menu {
   private vectores vector;
    private Matriz matriz;
    private Lista listaPersonas;
    private ListaEnlazada listaEnlazada;
    private Scanner sc;

    // ---------- CONSTRUCTOR ----------
    public menu() {
        this.vector = null;
        this.matriz = new Matriz(3, 3);
        this.listaPersonas = new Lista();
        this.listaEnlazada = new ListaEnlazada(); // ✅ inicializada correctamente
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Trabajar con MATRIZ");
            System.out.println("2. Trabajar con VECTOR");
            System.out.println("3. Trabajar con LISTA");
            System.out.println("4. Trabajar con LISTA ENLAZADA");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    menuMatriz();
                    break;
                case 2:
                    menuVector();
                    break;
                case 3:
                    menuLista();
                    break;
                case 4:
                    menuListaEnlazada();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // ---------- MÉTODO MENU MATRIZ ----------
    private void menuMatriz() {
        System.out.print("Ingrese número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese número de columnas: ");
        int columnas = sc.nextInt();
        sc.nextLine();

        matriz = new Matriz(filas, columnas);

        int opc;
        do {
            System.out.println("\n--- MENÚ MATRIZ ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar matriz");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Promedio peso (diagonal principal)");
            System.out.println("6. Promedio altura (diagonal secundaria)");
            System.out.println("7. Volver al menú principal");
            System.out.print("Elija una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> agregarPersonaMatriz();
                case 2 -> matriz.mostrarMatriz();
                case 3 -> eliminarPersonaMatriz();
                case 4 -> buscarPersonaMatriz();
                case 5 -> matriz.promedioPesoDiagonalPrincipal();
                case 6 -> matriz.promedioAlturaDiagonalSecundaria();
                case 7 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opc != 7);
    }

    private void agregarPersonaMatriz() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Peso: ");
        float peso = sc.nextFloat();
        System.out.print("Altura: ");
        float altura = sc.nextFloat();
        sc.nextLine();

        persona p = new persona(nombre, apellido, peso, altura);
        matriz.agregarPersona(p);
    }

    private void eliminarPersonaMatriz() {
        System.out.print("Ingrese fila: ");
        int fila = sc.nextInt();
        System.out.print("Ingrese columna: ");
        int columna = sc.nextInt();
        sc.nextLine();
        matriz.eliminarPersona(fila, columna);
    }

    private void buscarPersonaMatriz() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = sc.nextLine();
        matriz.buscarPersona(nombre);
    }

    // ---------- MÉTODO MENU VECTOR ----------
    private void menuVector() {
        System.out.print("Ingrese el tamaño del vector: ");
        int tamanio = sc.nextInt();
        sc.nextLine();

        vector = new vectores(tamanio);

        int opc;
        do {
            System.out.println("\n--- MENÚ VECTOR ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar vector");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elija una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> agregarPersonaVector();
                case 2 -> vector.mostrarVector();
                case 3 -> eliminarPersonaVector();
                case 4 -> buscarPersonaVector();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opc != 5);
    }

    private void agregarPersonaVector() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Peso: ");
        float peso = sc.nextFloat();
        System.out.print("Altura: ");
        float altura = sc.nextFloat();
        sc.nextLine();

        persona p = new persona(nombre, apellido, peso, altura);
        vector.agregarPersona(p);
    }

    private void eliminarPersonaVector() {
        System.out.print("Ingrese la posición a eliminar: ");
        int pos = sc.nextInt();
        sc.nextLine();
        vector.eliminarPersona(pos);
    }

    private void buscarPersonaVector() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = sc.nextLine();
        vector.buscarPersona(nombre);
    }

    // ---------- MÉTODO MENU LISTA ----------
    private void menuLista() {
        listaPersonas = new Lista();
        int opc;
        do {
            System.out.println("\n--- MENÚ LISTA ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elija una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> agregarPersonaLista();
                case 2 -> listaPersonas.mostrarLista();
                case 3 -> eliminarPersonaLista();
                case 4 -> buscarPersonaLista();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opc != 5);
    }

    private void agregarPersonaLista() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Peso: ");
        float peso = sc.nextFloat();
        System.out.print("Altura: ");
        float altura = sc.nextFloat();
        sc.nextLine();

        persona p = new persona(nombre, apellido, peso, altura);
        listaPersonas.agregarPersona(p);
    }

    private void eliminarPersonaLista() {
        System.out.print("Ingrese el nombre a eliminar: ");
        String nombre = sc.nextLine();
        listaPersonas.eliminarPersona(nombre);
    }

    private void buscarPersonaLista() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = sc.nextLine();
        listaPersonas.buscarPersona(nombre);
    }

    // ---------- MÉTODO MENU LISTA ENLAZADA ----------
    private void menuListaEnlazada() {
        int opc;
        do {
            System.out.println("\n--- MENÚ LISTA ENLAZADA ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar lista enlazada");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elija una opción: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> agregarPersonaListaEnlazada();
                case 2 -> listaEnlazada.mostrarListas();  // ✅ ahora sí funciona
                case 3 -> eliminarPersonaListaEnlazada();
                case 4 -> buscarPersonaListaEnlazada();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opc != 5);
    }

    private void agregarPersonaListaEnlazada() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Peso: ");
        float peso = sc.nextFloat();
        System.out.print("Altura: ");
        float altura = sc.nextFloat();
        sc.nextLine();

        persona p = new persona(nombre, apellido, peso, altura);
        listaEnlazada.agregarPersona(p);
    }

    private void eliminarPersonaListaEnlazada() {
        System.out.print("Ingrese el nombre a eliminar: ");
        String nombre = sc.nextLine();
        listaEnlazada.eliminarPersona(nombre);
    }

    private void buscarPersonaListaEnlazada() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = sc.nextLine();
        listaEnlazada.buscarPersona(nombre);
    }
}

