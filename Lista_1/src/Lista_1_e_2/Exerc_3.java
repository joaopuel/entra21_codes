package Lista_1_e_2;

import java.util.Scanner;

public class Exerc_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Base: ");
        double x = sc.nextDouble();

        System.out.print("Altura: ");
        double y = sc.nextDouble();

        System.out.println("Área = " + (x*y));
        System.out.println("Perímetro = " + (2*x+2*y));

        sc.close(); //Encerra o programa
    }
}