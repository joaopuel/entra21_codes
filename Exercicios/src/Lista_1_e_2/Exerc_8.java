package Lista_1_e_2;

import java.util.Scanner;

public class Exerc_8 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de carros vendidos: ");
        int carros = sc.nextInt();
        System.out.print("Digite o valor total das vendas: ");
        double receita = sc.nextDouble();
        System.out.print("Digite o salário fixo: ");
        double salario = sc.nextDouble();
        System.out.print("Digite o valor recebido por carro vendido: ");
        double comissao = sc.nextDouble();

        System.out.printf("Salário final = R$%.2f", (carros*comissao+salario+(5.0/100.0)*receita));

        sc.close();
    }
}
