package Lista_1_e_2;

import java.util.Scanner;

public class Exerc_21 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Conta: ");
        int conta = sc.nextInt();
        System.out.print("Saldo: ");
        double saldo = sc.nextDouble();
        System.out.print("Débito: ");
        double debito = sc.nextDouble();
        System.out.print("Crédito: ");
        double credito = sc.nextDouble();

        System.out.printf("Conta: %d\nSalto atual: R$%.2f\n", conta, (saldo-debito+credito));

        if((saldo-debito+credito)<0)
        {
            System.out.print("Saldo Negativo");
        }
        else
        {
            System.out.print("Saldo Positivo");
        }
    }

}
