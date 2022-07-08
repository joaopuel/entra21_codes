package classes.itens;

import classes.avaliacao.Avaliacao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Item {

    //Atributos
    private String titulo, genero;
    private double valor;
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    //Métodos
    public void avaliar(){
        Scanner in = new Scanner(System.in);
        Avaliacao avaliacao = new Avaliacao();
        System.out.print("Informe o nome do avaliador: ");
        avaliacao.setNome(in.nextLine());
        System.out.print("Informe uma nota de 0 a 10: ");
        avaliacao.setRating(in.nextDouble());
        in.nextLine();
        System.out.print("Informe algum feedback(opcional): ");
        avaliacao.setFeedback(in.nextLine());
        this.getAvaliacoes().add(avaliacao);
    }

    public double getTotalRating(){
        double valor =  this.getAvaliacoes().stream().mapToDouble(Avaliacao::getRating).sum()/this.avaliacoes.size();
        return Double.isNaN(valor) ? 0 : valor;
    }

    public abstract void montarDetalhes(Scanner in);
    public abstract void mostrarDetalhes();

    //Getters & Setters
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return this.avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
