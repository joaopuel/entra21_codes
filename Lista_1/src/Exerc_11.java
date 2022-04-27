import java.util.Scanner;

public class Exerc_11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Valor: ");
        double x=sc.nextDouble();

        if(x>10)
        {
            System.out.println("É MAIOR QUE 10!");
        }
        else
        {
            System.out.println("NÃO É MAIOR QUE 10!");
        }

        sc.close();
    }
}
