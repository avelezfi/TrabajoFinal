import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del vector de personas: ");
        int tamanio;

        while (!sc.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            sc.next();
        }

        tamanio = sc.nextInt();
        menu menu = new menu(tamanio);
        menu.mostrarMenu();

        sc.close();
    }
}