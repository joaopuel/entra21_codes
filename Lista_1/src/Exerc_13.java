import java.util.Scanner;

public class Exerc_13 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Numero de maçãs: ");
        double x = sc.nextDouble();

        if(x<12)
        {
            System.out.printf("Custo = R$%.2f", (1.30*x));
        }
        else
        {
            System.out.printf("Custo = R$%.2f", (1.0*x));
        }

        sc.close();
    }
}
