import java.util.Scanner;

public class Exerc_16 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Número 1: ");
        double x = sc.nextDouble();
        System.out.println("Número 2: ");
        double y = sc.nextDouble();;

        if(x>y)
        {
            System.out.println("Ordem é " + y + " - " + x);
        }
        else
        {
            if(x==y)
            {
                System.out.println("Números são iguais");
            }
            else
            {
                System.out.println("Ordem é " + x + " - " + y);
            }
        }
    }
}
