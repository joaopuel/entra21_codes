import java.util.Scanner;

public class Exerc_20 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Salário: ");
        double x = sc.nextDouble();
        System.out.print("Valor de vendas: ");
        double y = sc.nextDouble();

        if(y>1500.0)
        {
            System.out.printf("Salário total: R$%.2f", (x+(y-1500.0)*0.05+0.03*1500.0));
        }
        else
        {
            System.out.printf("Salário total: R$%.2f", (x+0.03*y));
        }
    }
}
