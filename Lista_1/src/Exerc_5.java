import java.util.Scanner;
import java.text.DecimalFormat;

public class Exerc_5 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Total de eleitores: ");
        double total = sc.nextInt();
        System.out.print("Total de votos em branco: ");
        double brancos = sc.nextInt();
        System.out.print("Total de votos nulos: ");
        double nulos = sc.nextInt();

        double validos = total-brancos-nulos;

        System.out.println("Votos válidos = " + validos + "\n" + "--------------------");
        System.out.println("Válidos = " + new DecimalFormat("#,##0.00").format((validos/total)*100 ) + "%");
        System.out.println("Brancos = " + new DecimalFormat("#,##0.00").format((brancos/total)*100) + "%");
        System.out.println("Nulos = " + new DecimalFormat("#,##0.00").format((nulos/total)*100) + "%");

        sc.close();
    }
}
