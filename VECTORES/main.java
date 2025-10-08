import java.util.Scanner;

public class main {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del vector: ");
        int tamanio = sc.nextInt();
        sc.nextLine();

        menu m = new menu(tamanio);
        m.mostrarMenu();

        sc.close();
    }
}
