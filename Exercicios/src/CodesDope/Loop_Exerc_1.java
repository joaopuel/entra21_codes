package CodesDope;
import java.util.Scanner;

public class Loop_Exerc_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] x = new int[10];
        int i;
        double media=0;

        for(i=0; i<10; i++)
        {
            System.out.print("Digite valor " + (i+1) + ": ");
            x[i] = sc.nextInt();
        }

        for(i=0; i<10; i++)
        {
            System.out.print(x[i] + " - ");
            media = media + (x[i]/10.0);
        }
        System.out.println();
        System.out.println("Média = " + media);
    }
}
