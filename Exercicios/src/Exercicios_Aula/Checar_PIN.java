package Exercicios_Aula;

import java.util.Scanner;

public class Checar_PIN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String pin = "91352";
        int count = 0;
        boolean x = false;

        while(true)
        {
            System.out.print("Digite o PIN: ");
            String informado = sc.nextLine();

            if(informado.length() != 5)
            {
                System.out.println("\nO PIN informado deve conter 5 digitos.\n");
                continue;
            }

            count += 1;

            for(int i=0; i<5; i++)
            {
                if(informado.charAt(i)!=pin.charAt(i))
                {
                    if(count==3)
                    {
                        System.err.println("\nVocê excedeu o número de tentativas. Acesso negado.");
                        break;
                    }

                    System.out.println("\nPIN inválido. Você tem mais " + (3-count) + " tentativas.\n");
                    break;
                }

                System.out.println("\nPIN correto. Liberando Acesso...");
                x = true;
                break;

            }

            if(count==3 || x)
            {
                break;
            }
        }
    }
}
