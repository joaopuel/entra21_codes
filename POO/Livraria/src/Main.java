import classes.Menus.EMenu;
import classes.avaliacao.*;
import classes.guardados.*;
import classes.itens.*;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Estante estante = new Estante(5);
        boolean loop = true;

        while(loop) {
            EMenu opcao = escolherOpcao();

            switch (opcao) {
                case ADICIONAR_ITEM:
                    adcionarItem(estante);
                    break;
                case BUSCAR_ITEM:
                    buscarERetornarItem(estante);
                    break;
                case REMOVER_ITEM:
                    removerItem(estante);
                    break;
                case MOSTRAR_ITENS:
                    mostrarItens(estante);
                    break;
                case SAIR:
                    loop = false;
                    break;
                default:
                    System.err.println("Opção não implementada!");
            }
        }
    }

    private static EMenu escolherOpcao() {
        EMenu escolha = null;
        while (escolha == null) {
            System.out.println("Selecione uma opção");
            for (EMenu menu : EMenu.values()) {
                System.out.printf("(%d) - %s\n", menu.getValor(), menu.getDescricao());
            }
            escolha = EMenu.getByValorOpcao(in.nextInt());
            in.nextLine();
            if (escolha == null) {
                System.err.println("Selecione uma opção válida!");
            }
        }
        return escolha;
    }

    public static void removerItem(Estante estante){
        if(estante.quantidadeItens() == 0) {
            System.err.println("A estante está vazia!");
        }else {
            int posicao;
            while(true) {
                System.out.println("Posição: ");
                posicao = in.nextInt();
                in.nextLine();
                if(posicao >= 0 && posicao < estante.getCapMaxima()){
                    break;
                }
                System.err.println("Insira uma posição válida!");
            }
            Item item = estante.removerItem(posicao);
            if(item == null){
                System.err.println("Não existe um item nessa posição!");
            }else{
                System.out.println("O item " + item.getTitulo() + " foi removido!");
            }
        }
    }

    public static void buscarERetornarItem(Estante estante){
        if(estante.quantidadeItens() == 0) {
            System.err.println("A estante está vazia!");
        }else {
            System.out.println("Título: ");
            Item item = estante.buscaItem(in.nextLine());
            if(item == null){
                System.err.println("Esse item não existe na estante!");
            }else {

                while(true) {
                    System.out.println("Menu");
                    System.out.println("(1) - Avaliar");
                    System.out.println("(2) - Ver avaliações");
                    System.out.println("(0) - Voltar");
                    int opcao = in.nextInt();
                    in.nextLine();

                    switch (opcao) {
                        case 1:
                            avaliarItem(item);
                            break;
                        case 2:
                            verAvaliacoes(item);
                            break;
                        case 0:
                            break;
                        default:
                            System.err.println("Insira uma opção válida");
                    }

                    if(opcao==0){
                        break;
                    }
                }
            }
        }
    }

    public static void avaliarItem(Item item){
        int cont = 0;
        for(Avaliacao avaliacao : item.getAvaliacoes()){
            if(avaliacao != null){
                cont++;
            }
        }
        if(cont == item.getAvaliacoes().size()){
            System.err.println("O número máximo de avaliações foi alcançado!");
        }else {
            item.avaliar();
        }
    }

    public static void verAvaliacoes(Item item){
        System.out.println();
        System.out.println("Avaliações:\n");
        for(Avaliacao avaliacao : item.getAvaliacoes())
        {
            if(avaliacao != null) {
                System.out.println(avaliacao.getNome() + ":");
                System.out.println("Avaliação: " + avaliacao.getRating());
                System.out.println("Feedback: " + avaliacao.getFeedback() + "\n");
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("Classificação final: " + item.getTotalRating());
        System.out.println();
    }

    public static void mostrarItens(Estante estante){
        System.out.println("\nA estante pussuí " + estante.quantidadeItens() + " itens. ");
        for(int i=0; i < estante.getCapMaxima(); i++) {
            Item item = estante.getItens().get(i);
            if(item != null) {
                System.out.print("[" + i + "] - " + item.getTitulo());
                System.out.print("(" + item.getGenero() + ") ");
                if (item instanceof Livro) {
                    Livro livro = (Livro) item;
                    System.out.print(": " + livro.getAnoPublicacao());
                    System.out.print(" - " + livro.getAutor());
                }else{
                    DVD dvd = (DVD) item;
                    System.out.print(": " + dvd.getAnoLancamento());
                    System.out.print(" - " + dvd.getDiretor());
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void adcionarItem(Estante estante){
        if(estante.estanteCheia()){
            System.err.println("Sua estante está cheia não é possível adicionar mais itens!");
        }else {
            Item item = null;

            while (item == null) {
                System.out.println("O que deseja inserir na estante? ");
                System.out.println("(1) - Livro");
                System.out.println("(2) - DVD");
                int opcao = in.nextInt();
                in.nextLine();

                switch (opcao) {
                    case 1:
                        item = new Livro();
                        break;
                    case 2:
                        item = new DVD();
                        break;
                    default:
                        System.err.println("Insira uma opção válida!");
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

            if (item instanceof Livro) {
                Livro livro = (Livro) item;
                System.out.print("Autor: ");
                livro.setAutor(in.nextLine());
                System.out.print("Quantidade de Páginas: ");
                livro.setQtdePaginas(in.nextInt());
                in.nextLine();
                System.out.print("Ano de publicação: ");
                livro.setAnoPublicacao(in.nextInt());
                in.nextLine();
                System.out.print("Edição: ");
                livro.setEdicao(in.nextInt());
                in.nextLine();
            } else {
                DVD dvd = (DVD) item;
                System.out.print("Diretor: ");
                dvd.setDiretor(in.nextLine());
                System.out.print("Duração: ");
                dvd.setDuracao(in.nextDouble());
                in.nextLine();
                System.out.print("Ano de lançamento: ");
                dvd.setAnoLancamento(in.nextInt());
                in.nextLine();
            }

            if (!estante.adcionarItem(item)) {
                System.err.println("Não foi possível adicionar item!");
            }

            System.out.println();
        }
    }
}