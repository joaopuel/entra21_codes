import classes.guardados.*;
import classes.itens.*;

import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Estante estante = new Estante(5);

        while (true) {

            if(!estante.adcionarItem(definirItem())){
                System.out.println("Não foi possível adicionar item.");
                continue;
            }

            System.out.println("\nA estante pussuí " + estante.quantidadeItens() + " itens.");

            for(Item item : estante.getItems()) {
                if(item != null) {
                    System.out.print(item.getTitulo());
                    System.out.print("(" + item.getGenero() + ")");
                    if (item instanceof Livro) {
                        Livro livro = (Livro) item;
                        System.out.print(": " + livro.getAnoPublicacao());
                        System.out.print(" - " + livro.getAutor());
                    }else{
                        DVD dvd = (DVD) item;
                        System.out.print(": " + dvd.getAnoLancamento());
                        System.out.print(" - " + dvd.getDiretor());
                    }
                    System.out.println("\n");
                }
            }

            if(estante.estanteCheia()){
                break;
            }
        }
    }

    public static Item definirItem(){
        Item item = null;

        while(item == null) {
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

        if(item instanceof Livro){
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

        return item;
    }
}
