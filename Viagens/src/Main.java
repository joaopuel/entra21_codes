import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Onibus onibus = new Onibus(3);
        onibus.getAssento("02").ocupar();
        onibus.getAssento("07").ocupar();
        onibus.getAssento("11").ocupar();
        onibus.getAssento("12").ocupar();
        System.out.println("Ônibus:");
        onibus.mostrarAssento();

        Aviao aviao = new Aviao(3, 4);
        System.out.println("Avião:");
        aviao.mostrarAssento();

    }
}
