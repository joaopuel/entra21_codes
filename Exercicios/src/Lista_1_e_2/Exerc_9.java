package Lista_1_e_2;

import java.util.Scanner;

public class Exerc_9 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite temperatura em Fahrenheit: ");
        double fahr = sc.nextDouble();

        double cels = 5*((fahr-32)/9);

        System.out.printf("Temperatura em celsius = %.2fº", cels);

        sc.close();
    }
}
