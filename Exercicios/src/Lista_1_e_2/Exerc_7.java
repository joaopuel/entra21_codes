package Lista_1_e_2;

import java.util.Scanner;

public class Exerc_7 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Custo de fábrica: ");
        double fabrica = sc.nextDouble();


        System.out.print("Custo final = R$" + (fabrica*((28.0/100.0)+(45.0/100.0)+1.0)));

    }
}
