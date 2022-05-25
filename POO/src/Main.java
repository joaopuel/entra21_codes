import classes.*;

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
        System.out.println("(5) - Mini Pizza - Calabresa");
        int escolha = sc.nextInt();
        Lanche lanche = null;
        switch (escolha){
            case 1:
                lanche =  new XSalada();
                break;
            case 2:
                lanche =  new XBurger();
                break;
            case 3:
                lanche =  new MistoQuente();
                break;
            case 4:
                lanche =  new HotDog();
                break;
            case 5:
                lanche = new MiniPizza();
                break;
            default:
                System.err.println("Escolha uma opção válida!");
        }

        if(escolha==1 || escolha==2)
        {
            System.out.print("Lanche aberto? (S/N)");
            sc.nextLine();
            String aberto = sc.next();
            ((XBurger)lanche).aberto = aberto.equalsIgnoreCase("S");
        }
        if(escolha == 5)
        {
            System.out.print("Borda recheada? (S/N)");
            sc.nextLine();
            String recheada = sc.next();
            MiniPizza miniPizza = ((MiniPizza)lanche);
            miniPizza.bordaRecheada = recheada.equalsIgnoreCase("S");
            if(miniPizza.bordaRecheada)
            {
                System.out.print("Sabor da borda: ");
                sc.nextLine();
                miniPizza.saborBorda = sc.next();
            }
        }

        System.out.print("Informe o valor do(a) " + lanche.tipo + ": R$");
        lanche.valor = sc.nextDouble();

        lanche.montarComanda();
    }
}