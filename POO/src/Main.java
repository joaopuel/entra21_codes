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
        Lanche lanche = null;
        int escolha=0;

        while(lanche == null) {
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha) {
                case 1:
                    lanche = new XSalada();
                    break;
                case 2:
                    lanche = new XBurger();
                    break;
                case 3:
                    lanche = new MistoQuente();
                    break;
                case 4:
                    lanche = new HotDog();
                    break;
                case 5:
                    lanche = new MiniPizza();
                    break;
                default:
                    System.err.println("Escolha uma opção válida!");
            }
        }
        if(lanche instanceof Sanduiche){
            System.out.print("Deseja adicionais? (S/N)");
            String adicional = sc.nextLine();
            if(adicional.equalsIgnoreCase("S")){
                System.out.println("Escreva \"parar\" quando não quiser mais adicionais.");
                for(int i=0; i<10; i++) {
                    System.out.println("Insira adicional: ");
                    adicional = sc.nextLine();
                    if(adicional.equalsIgnoreCase("parar")){
                        break;
                    }
                    ((Sanduiche)lanche).adicionarAdicionais(adicional);
                    if(i==9){
                        System.out.println("Não é possível acrescentar mais adicionais.");
                    }
                }
            }

            if(lanche instanceof XBurger)
            {
                System.out.print("Lanche aberto? (S/N)");
                String aberto = sc.nextLine();
                ((XBurger)lanche).aberto = aberto.equalsIgnoreCase("S");
            }
        }
        else
        {
            System.out.print("Borda recheada? (S/N)");
            String recheada = sc.nextLine();
            MiniPizza miniPizza = ((MiniPizza)lanche);
            miniPizza.bordaRecheada = recheada.equalsIgnoreCase("S");
            if(miniPizza.bordaRecheada)
            {
                System.out.print("Sabor da borda: ");
                miniPizza.saborBorda = sc.nextLine();
            }
        }

        System.out.print("Informe o valor do(a) " + lanche.tipo + ": R$");
        lanche.valor = sc.nextDouble();

        lanche.montarComanda();
    }
}