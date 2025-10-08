public class Matriz {
    
    private int filas;
    private int columnas;
    private int cantidad; 
    private persona[][] matrizPersonas;

    public Matriz() {
        this(3, 3);
    }

    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matrizPersonas = new persona[filas][columnas];
        this.cantidad = -1; 
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public persona[][] getMatrizPersonas() {
        return matrizPersonas;
    }

    public void setMatrizPersonas(persona[][] matrizPersonas) {
        this.matrizPersonas = matrizPersonas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean matrizVacia() {
        return cantidad == -1;
    }

    public boolean matrizLlena() {
        return cantidad == (filas * columnas) - 1;
    }

    public void agregarPersona(persona p) {
        if (!matrizLlena()) {
            cantidad++;
            int fila = cantidad / columnas;
            int columna = cantidad % columnas;
            matrizPersonas[fila][columna] = p;
            System.out.println("Persona agregada en [" + fila + "][" + columna + "]");
        } else {
            System.out.println("La matriz está llena.");
        }
    }

    public void mostrarMatriz() {
        if (!matrizVacia()) {
            System.out.println("\nMatriz de personas:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    persona p = matrizPersonas[i][j];
                    if (p != null) {
                        System.out.print("[" + p.getNombre() + " " + p.getApellido() + "]\t");
                    } else {
                        System.out.print("[Vacío]\t");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("La matriz está vacía.");
        }
    }

    public void eliminarPersona(int fila, int columna) {
        if (!matrizVacia() && fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            if (matrizPersonas[fila][columna] != null) {
                matrizPersonas[fila][columna] = null;
                reorganizarMatriz();
                cantidad--;
                System.out.println("Persona eliminada de [" + fila + "][" + columna + "]");
            } else {
                System.out.println("No hay persona en esa posición.");
            }
        } else {
            System.out.println("Posición inválida o matriz vacía.");
        }
    }

    private void reorganizarMatriz() {
        persona[] temp = new persona[filas * columnas];
        int index = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matrizPersonas[i][j] != null) {
                    temp[index++] = matrizPersonas[i][j];
                }
            }
        }
        cantidad = -1;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int pos = ++cantidad;
                matrizPersonas[i][j] = (pos < index) ? temp[pos] : null;
            }
        }
    }

    public void buscarPersona(String nombre) {
        if (!matrizVacia()) {
            boolean encontrado = false;
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    persona p = matrizPersonas[i][j];
                    if (p != null && p.getNombre().equalsIgnoreCase(nombre)) {
                        System.out.println("Persona encontrada en [" + i + "][" + j + "]");
                        encontrado = true;
                    }
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró a la persona con nombre " + nombre);
            }
        } else {
            System.out.println("La matriz está vacía.");
        }
    }

    public float promedioPesoDiagonalPrincipal() {
        if (matrizVacia()) {
            System.out.println("La matriz está vacía.");
            return 0;
        }
        float suma = 0;
        int contador = 0;
        for (int i = 0; i < filas && i < columnas; i++) {
            persona p = matrizPersonas[i][i];
            if (p != null) {
                suma += p.getPeso();
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No hay personas en la diagonal principal.");
            return 0;
        }
        float promedio = suma / contador;
        System.out.println("Promedio de peso en la diagonal principal: " + promedio);
        return promedio;
    }

    public float promedioAlturaDiagonalSecundaria() {
        if (matrizVacia()) {
            System.out.println("La matriz está vacía.");
            return 0;
        }
        float suma = 0;
        int contador = 0;
        for (int i = 0; i < filas && i < columnas; i++) {
            int j = columnas - 1 - i;
            persona p = matrizPersonas[i][j];
            if (p != null) {
                suma += p.getAltura();
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("No hay personas en la diagonal secundaria.");
            return 0;
        }
        float promedio = suma / contador;
        System.out.println("Promedio de altura en la diagonal secundaria: " + promedio);
        return promedio;
    }
    }

