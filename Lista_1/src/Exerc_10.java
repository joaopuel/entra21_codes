import java.util.Scanner;

public class Exerc_10 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double not_1 = sc.nextDouble();
        System.out.print("Digite a segunda nota: ");
        double not_2 = sc.nextDouble();
        System.out.print("Digite a terceira nota: ");
        double not_3 = sc.nextDouble();

        System.out.printf("Média Final = %.2f", ((not_1*2.0+not_2*3.0+not_3*5.0)/10.0));
    }
}
