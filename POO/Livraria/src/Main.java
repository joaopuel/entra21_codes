import classes.IMenu;
import classes.Loja;
import classes.Menus.*;
import classes.guardados.*;
import classes.itens.*;
import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static final String SET_RED = "\u001B[31m";
    public static final String SET_WHITE = "\u001B[0m";
    public static Scanner in = new Scanner(System.in);
    static Loja loja = new Loja();
    public static void main(String[] args) {

        boolean loop = true;

        while(loop) {
            try {
                EMenu opcao = (EMenu) escolherOpcao(null);
                switch (opcao) {
                    case ADICIONAR_ITEM -> adcionarItem();
                    case BUSCAR_ITEM -> buscarItemETratarRetorno();
                    case REMOVER_ITEM -> removerItem();
                    case MOSTRAR_ITENS -> mostrarItens();
                    case ADICIONAR_ESTANTES -> adicionarEstante();
                    case SAIR -> loop = false;
                    default -> System.out.println(SET_RED + "Opção não implementada!" + SET_WHITE);
                }
                System.out.println();
            }catch (RuntimeException e){
                if(in.hasNext()){
                    in.nextLine();
                }
                System.out.println("Aconteceu algum problema!");
                e.printStackTrace();

            }
        }
        System.out.println("Programa Encerrado!");
    }

    private static void adicionarEstante() {
        while (true) {
            System.out.print("Informe um identificador: ");
            String id = in.nextLine().toLowerCase();
            if (loja.getEstantes().containsKey(id)) {
                System.out.println("Identificador já utilizado!");
            } else {
                System.out.print("Informe a capacidade máxima da estante: ");
                loja.getEstantes().put(id, new Estante(in.nextInt()));
                in.nextLine();
                break;
            }
        }
    }

    /**
     * Retorna uma opção de menu de acordo com o que vier no parametro
     * @param item = Inteiro referente ao valor da opção do menu
     * @return A opção de menu escolhida ou null
     */
    private static IMenu escolherOpcao(Item item) {
        IMenu escolha = null;
        while (escolha == null) {
            if (item != null) {
                while (escolha == null) {
                    System.out.println(item.getTitulo()+ " encontrado! Ações disponíveis: ");
                    for(EMenuItem i : EMenuItem.values()) {
                        System.out.printf("(%d) %s\n", i.getValor(), i.getDescricao());
                    }
                    escolha = EMenuItem.getByValorOpcao(in.nextInt());
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

    public static void removerItem(){
        if (loja.getEstantes().isEmpty()) {
            System.out.println("Sem estantes!");
        } else {
            Estante estante = buscarEstante();
            if (estante.quantidadeItens() == 0) {
                System.out.println(SET_RED + "A estante está vazia!" + SET_WHITE);
            } else {
                int posicao;
                while (true) {
                    System.out.println("Posição: ");
                    posicao = in.nextInt();
                    in.nextLine();
                    if (posicao >= 0 && posicao < estante.getItens().size()) {
                        break;
                    }
                    System.out.println(SET_RED + "Insira uma posição válida!" + SET_WHITE);
                }
                Item item = estante.removerItem(posicao);
                System.out.println("O item " + item.getTitulo() + " foi removido!");
            }
        }
    }

    public static void buscarItemETratarRetorno(){
        if (loja.getEstantes().isEmpty()) {
            System.out.println("Sem estantes!");
        } else {
            System.out.print("Informe o título para busca: ");
            String titulo = in.nextLine();
            Item item = null;
            for (Estante e : loja.getEstantes().values()) {
                item = e.buscarItem(titulo);
                if (item != null) {
                    break;
                }
            }
            if (item == null) {
                System.out.println(SET_RED + "Esse item não existe na Loja!" + SET_WHITE);
            } else {
                boolean loop = true;
                while (loop) {
                    EMenuItem opcao = (EMenuItem) escolherOpcao(item);
                    switch (opcao) {
                        case AVALIAR_ITEM -> item.avaliar();
                        case VER_AVALIACOES -> verAvaliacoes(item);
                        case MOSTRAR_DETALHES -> {
                            System.out.println("Título: " + item.getTitulo());
                            System.out.println("Gênero: " + item.getGenero());
                            item.mostrarDetalhes();
                            System.out.printf("Valor: R$%.2f\n", item.getValor());
                        }
                        case VOLTAR -> loop = false;
                        default -> System.out.println(SET_RED + "Opcão não implementada" + SET_WHITE);
                    }
                }
            }
        }
    }

    public static void verAvaliacoes(@NotNull Item item){
        item.getAvaliacoes().forEach(a -> {
            System.out.println("Autor: "+a.getNome());
            System.out.println("avaliação: "+a.getRating());
            System.out.println("Comentário: ");
            System.out.println("Data: " + a.getDataAvaliacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            System.out.println(a.getFeedback());
            System.out.println("--------------------");
        });
        System.out.println("Classificação final: "+item.getTotalRating());
    }

    public static void mostrarItens(){
        if (loja.getEstantes().isEmpty()) {
            System.out.println("Sem estantes!");
        }else {
            for (String key: loja.getEstantes().keySet()) {
                Estante estante = loja.getEstantes().get(key);
                System.out.println("\nEstante: '"+key+"'");
                System.out.println("A estante pussuí " + estante.quantidadeItens() + " itens. ");
                for (int i = 0; i < estante.getItens().size(); i++) {
                    Item item = estante.getItens().get(i);
                    System.out.print("[" + i + "] - " + item.getTitulo());
                    System.out.print("(" + item.getGenero() + ") ");
                    System.out.println();
                }
            }
        }
    }

    //Adicionar item na estante
    public static void adcionarItem(){
        if(loja.getEstantes().isEmpty()){
            System.out.println("Sem estantes!");
        }else {
            Estante estante = buscarEstante();
            if (estante.estanteCheia()) {
                System.out.println(SET_RED + "Sua estante está cheia não é possível adicionar mais itens!" + SET_WHITE);
            } else {
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
                }else {
                    System.out.println("Item adicionado com sucesso!");
                }
            }
        }
    }

    private static Estante buscarEstante() {
        Estante e = null;
        while(e == null) {
            System.out.print("Informe o identificador da estante: ");
            e = loja.getEstantes().get(in.nextLine().toLowerCase());
            if (e == null) {
                System.out.println("Estante não encontrada!");
            }
        }
        return e;
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