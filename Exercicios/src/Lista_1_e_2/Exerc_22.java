package Lista_1_e_2;

import java.util.Scanner;

public class Exerc_22 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Estoque atual: ");
        int atual = sc.nextInt();
        System.out.print("Estoque máximo: ");
        int max = sc.nextInt();
        System.out.print("Estoque mínimo: ");
        int min = sc.nextInt();

        if(atual>=((max+min)/2))
        {
            System.out.print("Não efetuar compra");
        }
        else
        {
            System.out.print("Efetuar compra");
        }
    }
}
