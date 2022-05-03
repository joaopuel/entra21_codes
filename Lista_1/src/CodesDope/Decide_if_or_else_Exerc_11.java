package CodesDope;

import java.util.Scanner;

public class Decide_if_or_else_Exerc_11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Escreva uma letra: ");
        String x = sc.nextLine();
        int ascii = x.charAt(0);

        if(ascii<97)
        {
            System.out.println("Letra maiúscula");
        }
        else
        {
            System.out.println("Letra minúscula");
        }

        sc.close();
    }
}
