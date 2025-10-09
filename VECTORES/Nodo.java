public class Nodo {
    private persona dato;      // persona que guarda este nodo
    private Nodo siguiente;    // referencia al siguiente nodo

    // Constructor vacío
    public Nodo() {
        this.dato = null;
        this.siguiente = null;
    }

    // Constructor que recibe una persona
    public Nodo(persona dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Getter y setter para la persona
    public persona getPersona() {
        return dato;
    }

    public void setPersona(persona dato) {
        this.dato = dato;
    }

    // Getter y setter para el siguiente nodo
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    // Método para mostrar el nodo
    public void mostrarNodo() {
        System.out.println(dato.getNombre() + " " + dato.getApellido() +
                " | Peso: " + dato.getPeso() +
                " | Altura: " + dato.getAltura());
    }
}
