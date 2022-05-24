import classes.HotDog;
import classes.MistoQuente;
import classes.XBurger;
import classes.XSalada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* PARA VERIFICAR A CLASSE OU TIPO DA VARIÀVEL
        int x = 0;
        XSalada sla = new XSalada();
        System.out.println(((Object)x).getClass().getSimpleName()); PARA DADOS DE TIPO PRIMITIVO
        System.out.println(sla.getClass().getSimpleName());*/

        Scanner sc = new Scanner(System.in);
        System.out.println("- MENU -");
        System.out.println("(1) - X-Salada");
        System.out.println("(2) - X-Burguer");
        System.out.println("(3) - Misto Quente");
        System.out.println("(4) - Hot Dog");
        int escolha = sc.nextInt();

        switch (escolha){
            case 1:
                XSalada lanche =  new XSalada();

                System.out.print("Informe o valor do XSalada: R$");
                lanche.valor = sc.nextDouble();

                System.out.print("Lanche aberto? (S/N)");
                sc.nextLine();
                String aberto = sc.next();
                lanche.aberto = aberto.equalsIgnoreCase("S");

                lanche.montarComanda();
                break;
            case 2:
                XBurger lanche2 =  new XBurger();

                System.out.print("Informe o valor do XBurguer: R$");
                lanche2.valor = sc.nextDouble();

                System.out.print("Lanche aberto? (S/N)");
                sc.nextLine();
                String aberto2 = sc.next();
                lanche2.aberto = aberto2.equalsIgnoreCase("S");

                lanche2.montarComanda();
                break;
            case 3:
                MistoQuente lanche3 =  new MistoQuente();

                System.out.print("Informe o valor do Misto Quente: R$");
                lanche3.valor = sc.nextDouble();

                lanche3.montarComanda();
                break;
            case 4:
                HotDog lanche4 =  new HotDog();

                System.out.print("Informe o valor do Hot Dog: R$");
                lanche4.valor = sc.nextDouble();

                lanche4.montarComanda();
                break;
            default:
                System.err.println("Escolha uma opção válida!");
        }
    }
}
