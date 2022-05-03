package Lista_1_e_2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Exerc_6 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu salário: ");
        double salario = sc.nextDouble();
        System.out.print("Digite o percentual de reajuste: ");
        double reajuste = sc.nextDouble();

        System.out.println("Novo salário = R$" + new DecimalFormat("0.00").format((salario*((reajuste/100)+1))));

    }
}
