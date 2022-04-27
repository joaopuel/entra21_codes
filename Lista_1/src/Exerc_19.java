import java.util.Scanner;

public class Exerc_19 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Altura: ");
        double altura = sc.nextDouble();
        System.out.print("Sexo: ");
        Scanner sc1 = new Scanner(System.in);
        String sexo = sc1.nextLine();

        if(sexo.equals("M"))
        {
            System.out.println("Olá, " + nome + "\nSeu peso ideal é " + ((72.7*altura)-58.0));
        }
        else
        {
            System.out.println("Olá, " + nome + "\nSeu peso ideal é " + ((62.1*altura)-44.7));
        }
    }
}
