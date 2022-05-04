package Lista_1_e_2;

import java.util.Scanner;

public class Exerc_4 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos anos você tem?: ");
        int ano = sc.nextInt();

        System.out.print("Quantos meses?: ");
        int mes = sc.nextInt();

        System.out.print("Quantos dia?: ");
        int dia = sc.nextInt();

        System.out.print("Você tem " + (365*ano+30*mes+dia) + " dias de idade.");
        sc.close();
    }
}
