package Lista_1_e_2;

import java.util.Scanner;

public class Exerc_18 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Horas trabalhadas: ");
        double x = sc.nextDouble();
        System.out.print("Salário por hora: ");
        double y = sc.nextDouble();

        if(x > (40.0*4.0))
        {
            System.out.printf("Salário do mês: R$%.2f", (y*40.0*4.0+y*(1.5)*(x-40.0*4.0)));
        }
        else
        {
            System.out.printf("Salário do mês: R$%.2f", (y*x));
        }

    }
}
