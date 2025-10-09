public class ListaEnlazada {
      private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public boolean listaVacia() {
        return cabeza == null;
    }

    // ----------------- AGREGAR PERSONA -----------------
    public void agregarPersona(persona persona) {
        Nodo nuevo = new Nodo(persona);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }

        System.out.println("Persona agregada correctamente.");
    }

    // ----------------- MOSTRAR LISTA -----------------
    public void mostrarListas() {
        if (listaVacia()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("\n--- Lista de Personas ---");
            Nodo actual = cabeza;
            int pos = 0;

            while (actual != null) {
                System.out.print(pos + " → ");
                actual.mostrarNodo();
                actual = actual.getSiguiente();
                pos++;
            }
        }
    }

    // ----------------- ELIMINAR PERSONA -----------------
    public void eliminarPersona(String nombre) {
        if (listaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (cabeza.getPersona().getNombre().equalsIgnoreCase(nombre)) {
            cabeza = cabeza.getSiguiente();
            System.out.println("Persona eliminada correctamente.");
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null && !actual.getPersona().getNombre().equalsIgnoreCase(nombre)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            System.out.println("No se encontró a la persona con nombre " + nombre);
        } else {
            anterior.setSiguiente(actual.getSiguiente());
            System.out.println("Persona eliminada correctamente.");
        }
    }

    // ----------------- BUSCAR PERSONA -----------------
    public void buscarPersona(String nombre) {
        if (listaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        int posicion = 0;
        boolean encontrado = false;

        while (actual != null) {
            if (actual.getPersona().getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Persona encontrada en la posición " + posicion + ":");
                actual.mostrarNodo();
                encontrado = true;
                break;
            }

            actual = actual.getSiguiente();
            posicion++;
        }

        if (!encontrado) {
            System.out.println("No se encontró a la persona con nombre " + nombre);
        }
    }
}