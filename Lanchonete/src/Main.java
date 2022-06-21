import classes.cliente.Cliente;
import classes.lanches.*;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            Cliente cliente = new Cliente();
            System.out.println("Insira o nome do cliente: ");
            cliente.setNome(sc.nextLine());

            while(true) {
                cliente.getPedido().adicionarLanche(montarLanche());
                System.out.println("Deseja mais um lanche? (S/N)");
                if(sc.nextLine().equalsIgnoreCase("N")) {
                    break;
                }
            }
            System.out.println("Cliente: " + cliente.getNome());
            cliente.getPedido().imprimirComanda();

            System.out.print("Há um novo cliente? (S/N)");
            if (sc.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    private static Lanche montarLanche(){

        /* PARA VERIFICAR A CLASSE OU TIPO DA VARIÀVEL
        int x = 0;
        XSalada sla = new XSalada();
        System.out.println(((Object)x).getClass().getSimpleName()); PARA DADOS DE TIPO PRIMITIVO
        System.out.println(sla.getClass().getSimpleName());*/

        System.out.println("- MENU -");
        System.out.println("(1) - X-Salada");
        System.out.println("(2) - X-Burguer");
        System.out.println("(3) - Misto Quente");
        System.out.println("(4) - Hot Dog");
        System.out.println("(5) - Mini Pizza");
        System.out.println("(6) - Pizza");
        Lanche lanche = null;
        int escolha;

        while (lanche == null) {
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
                case 6:
                    lanche = new Pizza();
                    break;
                default:
                    System.err.println("Escolha uma opção válida!");
            }
        }
        lanche.mostrarDetalhesLanche(sc);
        System.out.print("Informe o valor do(a) " + lanche.getTipo() + ": R$");
        lanche.setValor(sc.nextDouble());
        sc.nextLine();
        return lanche;
    }
}
