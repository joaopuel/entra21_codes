import classes.cliente.Cliente;
import classes.cliente.EMenu;
import classes.lanches.*;

import java.util.InputMismatchException;
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
        Lanche lanche = null;
        while (lanche == null) {
            try {
                EMenu escolha = escolherOpcao();
            } catch (InputMismatchException e){
                System.err.println("Escolha uma opção válida!");
            } finally {
                sc.nextLine();
            }
            switch (escolha) {
                case XSALADA -> lanche = new XSalada();
                case 2 -> lanche = new XBurger();
                case 3 -> lanche = new MistoQuente();
                case 4 -> lanche = new HotDog();
                case 5 -> lanche = new MiniPizza();
                case 6 -> lanche = new Pizza();
                default -> System.err.println("Escolha uma opção válida!");
            }
        }
        lanche.mostrarDetalhesLanche(sc);
        System.out.print("Informe o valor do(a) " + lanche.getTipo() + ": R$");
        lanche.setValor(sc.nextDouble());
        sc.nextLine();
        return lanche;
    }

    private static EMenu escolherOpcao() {
        EMenu opcao = null;
        while(opcao == null){
            System.out.println("- MENU -");
        }
    }
}
