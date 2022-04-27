import java.util.Scanner;

public class Exerc_12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Valor: ");
        double x = sc.nextDouble();

        if(x<0)
        {
            System.out.println("Negativo");
        }
        else
        {
            System.out.println("Positivo");
        }

        sc.close();
    }
}
