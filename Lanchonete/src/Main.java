import classes.cliente.Cliente;
import classes.menus.EMenu;
import classes.lanches.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            Cliente cliente = new Cliente();
            System.out.print("Insira o nome do cliente: ");
            cliente.setNome(sc.nextLine());

            do {
                cliente.getPedido().adicionarLanche(montarLanche());
                System.out.println("Deseja mais um lanche? (S/N)");
            } while (!sc.nextLine().equalsIgnoreCase("N"));
            System.out.println("Cliente: " + cliente.getNome());
            cliente.getPedido().imprimirComanda();

            System.out.print("Há um novo cliente? (S/N)");
        } while (!sc.nextLine().equalsIgnoreCase("N"));
    }

    private static Lanche montarLanche(){

        /* PARA VERIFICAR A CLASSE OU TIPO DA VARIÀVEL
        int x = 0;
        XSalada sla = new XSalada();
        System.out.println(((Object)x).getClass().getSimpleName()); PARA DADOS DE TIPO PRIMITIVO
        System.out.println(sla.getClass().getSimpleName());*/
        Lanche lanche = null;
        while (lanche == null) {
            EMenu escolha = escolherOpcao();
            switch (escolha) {
                case XSALADA -> lanche = new XSalada();
                case XBURGUER -> lanche = new XBurger();
                case MISTO_QUENTE -> lanche = new MistoQuente();
                case HOT_DOG -> lanche = new HotDog();
                case MINIPIZZA -> lanche = new MiniPizza();
                case PIZZA -> lanche = new Pizza();
                default -> System.err.println("Opção não implementada!");
            }
        }
        lanche.mostrarDetalhesLanche(sc);
        System.out.print("Informe o valor do(a) " + lanche.getTipo() + ": R$");
        lanche.setValor(sc.nextDouble());
        sc.nextLine();
        return lanche;
    }

    public static EMenu escolherOpcao() {
        EMenu opcao = null;
        while(opcao == null){
            try {
                System.out.println("- MENU -");
                Arrays.stream(EMenu.values()).forEach(EMenu -> {
                    System.out.printf("(%d) - %s\n", EMenu.getValorOpcao(), EMenu.getDescricao());
                });
                System.out.println("Selecione uma opção: ");
                opcao = EMenu.getByValorOpcao(sc.nextInt());
            }catch (RuntimeException e){
                System.out.println("Selecione uma opção válida!");
            }finally {
                sc.nextLine();
            }
        }
        return opcao;
    }
}
