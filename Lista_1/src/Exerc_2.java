import java.util.Scanner;

public class Exerc_2 {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.print("Escreva um valor: ");

        int x=sc.nextInt();

        System.out.println("Número inserido = " + x);

        x--;

        System.out.println("Antecessor = " + x);

        sc.close(); //Encerra o programa
    }
}
