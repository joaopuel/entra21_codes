package classes.itens;

import java.util.Scanner;

public class Livro extends Item{

    //Atributos
    private String autor;
    private int qtdePaginas, anoPublicacao, edicao;

    //Métodos
    @Override
    public void montarDetalhes(Scanner in) {
        System.out.print("Autor: ");
        this.setAutor(in.nextLine());
        System.out.print("Quantidade de Páginas: ");
        this.setQtdePaginas(in.nextInt());
        in.nextLine();
        System.out.print("Ano de publicação: ");
        this.setAnoPublicacao(in.nextInt());
        in.nextLine();
        System.out.print("Edição: ");
        this.setEdicao(in.nextInt());
        in.nextLine();
    }

    @Override
    public void mostrarDetalhes() {
        System.out.print(": " + this.getAnoPublicacao());
        System.out.print(" - " + this.getAutor());
        System.out.print(" (QdPgs: " + this.getQtdePaginas());
        System.out.print(", Ed: " + this.getEdicao() + ")");
    }

    //Getters & Setter
    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQtdePaginas() {
        return this.qtdePaginas;
    }

    public void setQtdePaginas(int qtdePaginas) {
        this.qtdePaginas = qtdePaginas;
    }

    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getEdicao() {
        return this.edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
}
