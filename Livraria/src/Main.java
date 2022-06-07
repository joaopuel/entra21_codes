import classes.Livro;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Livro livro = new Livro();
        livro.setTitulo("Harry Potter");
        livro.avaliar();
        livro.avaliar();
        livro.avaliar();
        System.out.println(livro.getTotalRating());
    }
}
