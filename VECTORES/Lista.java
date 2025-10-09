import java.util.ArrayList;

public class Lista {
        private ArrayList<persona> listaPersonas;

    public Lista() {
        this.listaPersonas = new ArrayList<persona>();

    }

    public boolean listaVacia() {
        return listaPersonas.isEmpty();
    }

    public void agregarPersona(persona p) {
        listaPersonas.add(p);
        System.out.println("Persona agregada correctamente.");
    }

    public void mostrarLista() {
        if (!listaVacia()) {
            System.out.println("\n--- LISTA DE PERSONAS ---");
            for (int i = 0; i < listaPersonas.size(); i++) {
                persona p = listaPersonas.get(i);
                System.out.println((i + 1) + ". Nombre: " + p.getNombre() +
                                   ", Apellido: " + p.getApellido() +
                                   ", Peso: " + p.getPeso() +
                                   ", Altura: " + p.getAltura());
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }

    public void eliminarPersona(String nombre) {
        if (!listaVacia()) {
            boolean eliminado = false;
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                    listaPersonas.remove(i);
                    System.out.println("Persona eliminada correctamente.");
                    eliminado = true;
                    break;
                }
            }
            if (!eliminado) {
                System.out.println("No se encontró una persona con ese nombre.");
            }
        } else {
            System.out.println("La lista está vacía.");
        }
    }

    public int buscarPersona(String nombre) {
        if (!listaVacia()) {
            for (int i = 0; i < listaPersonas.size(); i++) {
                if (listaPersonas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Persona encontrada en la posición " + i);
                    return i;
                }
            }
            System.out.println("No se encontró a la persona con nombre " + nombre);
        } else {
            System.out.println("La lista está vacía.");
        }
        return -1;
    }
}