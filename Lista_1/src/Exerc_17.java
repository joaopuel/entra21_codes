import java.util.Scanner;

public class Exerc_17 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Início: ");
        int x = sc.nextInt();
        System.out.println("Fim: ");
        int y = sc.nextInt();

        if (x>24 || y>24)
        {
            System.out.println("Não são horários válidos");
        }
        else
        {
            if(x>=y)
            {
                System.out.println("Duração: " + (24-x+y) + " horas");
            }
            else
            {
                System.out.println("Duração: " + (y-x) + " horas");
            }
        }
    }
}
