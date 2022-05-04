package Lista_1_e_2;

import java.util.Scanner;

public class Exerc_14 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ano de nascimento: ");
        int nasc = sc.nextInt();

        System.out.println("Ano atual: ");
        int atual = sc.nextInt();

        if((atual-nasc)<16)
        {
            System.out.println("Você não pode votar este ano");
        }
        else
        {
            System.out.println("Você pode votar este ano");
        }

        sc.close();
    }
}
