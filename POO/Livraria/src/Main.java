import classes.IMenu;
import classes.Menus.*;
import classes.avaliacao.*;
import classes.guardados.*;
import classes.itens.*;
import java.util.Scanner;

public class Main {

    public static final String SET_RED = "\u001B[31m";
    public static final String SET_WHITE = "\u001B[0m";
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Estante estante = new Estante(5);
        boolean loop = true;

        while(loop) {
            EMenu opcao = (EMenu) escolherOpcao(null);

            switch (opcao) {
                case ADICIONAR_ITEM -> adcionarItem(estante);
                case BUSCAR_ITEM -> buscarERetornarItem(estante);
                case REMOVER_ITEM -> removerItem(estante);
                case MOSTRAR_ITENS -> mostrarItens(estante);
                case SAIR -> loop = false;
                default -> System.out.println( SET_RED + "Opção não implementada!" + SET_WHITE);
            }
        }
        System.out.println("Programa Encerrado!");
    }

    private static IMenu escolherOpcao(Item item) {
        IMenu escolha = null;
        while (escolha == null) {
            if (item != null) {
                while (escolha == null) {
                    System.out.println(item.getTitulo()+ " encontrado! Ações disponíveis: ");
                    for(EMenuBusca i : EMenuBusca.values()) {
                        System.out.printf("(%d) %s\n", i.getValor(), i.getDescricao());
                    }
                    escolha = EMenuBusca.getByValorOpcao(in.nextInt());
                    if (escolha == null) {
                        System.err.println("Selecione uma opção válida");
                    }
                }
            } else {
                System.out.println("Selecione uma opção");
                for (EMenu menu : EMenu.values()) {
                    System.out.printf("(%d) - %s\n", menu.getValor(), menu.getDescricao());
                }
                escolha = EMenu.getByValorOpcao(in.nextInt());
            }
            in.nextLine();
            if (escolha == null) {
                System.err.println("Selecione uma opção válida!");
            }
        }
        return escolha;
    }

    public static void removerItem(Estante estante){
        if(estante.quantidadeItens() == 0) {
            System.out.println(SET_RED + "A estante está vazia!" + SET_WHITE);
        }else {
            int posicao;
            while(true) {
                System.out.println("Posição: ");
                posicao = in.nextInt();
                in.nextLine();
                if(posicao >= 0 && posicao < estante.getItens().size()){
                    break;
                }
                System.out.println(SET_RED + "Insira uma posição válida!" + SET_WHITE);
            }
            Item item = estante.removerItem(posicao);
            System.out.println("O item " + item.getTitulo() + " foi removido!");
        }
    }

    public static void buscarERetornarItem(Estante estante){
        if(estante.quantidadeItens() == 0) {
            System.out.println(SET_RED + "A estante está vazia!" + SET_WHITE);
        }else {
            System.out.println("Título: ");
            Item item = estante.buscaItem(in.nextLine());
            if(item == null){
                System.out.println(SET_RED + "Esse item não existe na estante!" + SET_WHITE);
            }else {
                boolean loop = true;
                while(loop) {
                    EMenuBusca opcao = escolherOpcao2();

                    switch (opcao) {
                        case AVALIAR -> item.avaliar();
                        case VER_AVALIACOES -> verAvaliacoes(item);
                        case VOLTAR -> loop = false;
                        default -> System.out.println(SET_RED + "Opcão não implementada" + SET_WHITE);
                    }
                }
            }
        }
    }

    private static EMenuBusca escolherOpcao2() {
        EMenuBusca escolha = null;
        while (escolha == null) {
            System.out.println("Selecione uma opção");
            for (EMenuBusca menu : EMenuBusca.values()) {
                System.out.printf("(%d) - %s\n", menu.getValor(), menu.getDescricao());
            }
            escolha = EMenuBusca.getByValorOpcao(in.nextInt());
            in.nextLine();
            if (escolha == null) {
                System.out.println(SET_RED + "Selecione uma opção válida!" + SET_WHITE);
            }
        }
        return escolha;
    }

    public static void verAvaliacoes(Item item){
        System.out.println();
        System.out.println("Avaliações:\n");
        for(Avaliacao avaliacao : item.getAvaliacoes())
        {
            System.out.println(avaliacao.getNome() + ":");
            System.out.println("Avaliação: " + avaliacao.getRating());
            System.out.println("Feedback: " + avaliacao.getFeedback() + "\n");
        }
        System.out.println("--------------------------------------");
        System.out.println("Classificação final: " + item.getTotalRating());
        System.out.println();
    }

    public static void mostrarItens(Estante estante){
        System.out.println("\nA estante pussuí " + estante.quantidadeItens() + " itens. ");
        for(int i=0; i < estante.getItens().size(); i++) {
            Item item = estante.getItens().get(i);
            System.out.print("[" + i + "] - " + item.getTitulo());
            System.out.print("(" + item.getGenero() + ") ");
            item.mostrarDetalhes();
            System.out.printf(" -> R$%.2f" , item.getValor());
            System.out.println();
        }
        System.out.println();
    }

    public static void adcionarItem(Estante estante){
        if(estante.estanteCheia()){
            System.out.println(SET_RED + "Sua estante está cheia não é possível adicionar mais itens!" + SET_WHITE);
        }else {
            Item item = null;

            while (item == null) {
                EMenuAdiciona opcao = escolherOpcao3();

                switch (opcao) {
                    case LIVRO -> item = new Livro();
                    case DVD -> item = new DVD();
                    default -> System.out.println(SET_RED + "Insira uma opção válida!" + SET_WHITE);
                }
            }

            System.out.println("Insira as informações do " + (item.getClass().getName()).replace("classes.itens.", ""));
            System.out.print("Título: ");
            item.setTitulo(in.nextLine());
            System.out.print("Gênero: ");
            item.setGenero(in.nextLine());
            System.out.print("Valor: ");
            item.setValor(in.nextDouble());
            in.nextLine();

            item.montarDetalhes(in);

            if (!estante.adcionarItem(item)) {
                System.out.println(SET_RED + "Não foi possível adicionar item!" + SET_WHITE);
            }

            System.out.println();
        }
    }

    private static EMenuAdiciona escolherOpcao3() {
        EMenuAdiciona escolha = null;
        while (escolha == null) {
            System.out.println("Selecione uma opção");
            for (EMenuAdiciona menu : EMenuAdiciona.values()) {
                System.out.printf("(%d) - %s\n", menu.getValor(), menu.getDescricao());
            }
            escolha = EMenuAdiciona.getByValorOpcao(in.nextInt());
            in.nextLine();
            if (escolha == null) {
                System.out.println(SET_RED + "Selecione uma opção válida!" + SET_WHITE);
            }
        }
        return escolha;
    }
}