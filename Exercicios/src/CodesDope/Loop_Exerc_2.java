package CodesDope;
import java.util.Scanner;

public class Loop_Exerc_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Escreva um número para primeira figura: ");
        int a = sc.nextInt();

        for(int i=0; i<a; i++)
        {
            for(int j=0; j<(i+1); j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.print("Escreva um número para segunda figura: ");
        int b = sc.nextInt();
        int n = b/2;

        for(int i=0; i<b; i++)
        {
            if(i%2==0 && i!=b-1)
            {
                for(int k=0; k<n; k++)
                {
                    System.out.print(" ");
                }
                n-=1;
            }
            for(int j=0; j<(i+1); j++)
            {
                if(i%2==0)
                {
                    System.out.print("*");
                }
            }
            if(i%2==0)
            {
                System.out.println();
            }
        }

        n = 1;


        for(int i=b; i>0; i--)
        {
            if((b%2!=0 && i%2!=0 && i!=b-1) || (b%2==0 && i%2==0 && i!=b-1))
            {
                for(int k=0; k<n; k++)
                {
                    System.out.print(" ");
                }
                n++;
            }
            for(int j=i-1; j>0; j--)
            {
                if(i%2==0)
                {
                    System.out.print("*");
                }
            }
            if(i%2==0)
            {
                System.out.println();
            }
        }
        System.out.println();
        System.out.print("Escreva um número para terceira figura: ");
        int c = sc.nextInt();

        n = 1;

        for(int i=(c*2); i>0; i--)
        {
            if((c%2!=0 && i%2!=0 && i!=c-1) || (c%2==0 && i%2!=0 && i!=c-2))
            {
                for(int k=0; k<n; k++)
                {
                    System.out.print(" ");
                }
                n++;
            }
            for(int j=i-1; j>0; j--)
            {
                if(i%2==0)
                {
                    if(j%2==0)
                    {
                        System.out.print("0");
                    }
                    if(j%2==1)
                    {
                        System.out.print("1");
                    }
                }
            }
            if(i%2==0)
            {
                System.out.println();
            }
        }
    }
}
