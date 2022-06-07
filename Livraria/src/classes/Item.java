package classes;

import java.util.Scanner;

public abstract class Item {

    //Atributos
    private String titulo, genero;
    private double valor;
    private Avaliacao[] avaliacoes = new Avaliacao[30];

    //Métodos
    public void avaliar(){
        Scanner in = new Scanner(System.in);
        Avaliacao avaliacao = new Avaliacao();
        System.out.print("Informe o nome do avaliador: ");
        avaliacao.setNome(in.nextLine());
        System.out.print("Informe uma nota de 0 a 10: ");
        avaliacao.setRating(in.nextDouble());
        in.nextLine();
        System.out.print("Informe algum feedback(opcional)");
        avaliacao.setFeedback(in.nextLine());

        for(int i = 0; i < this.getAvaliacoes().length; i++){
            if(this.getAvaliacoes()[i] == null){
                this.getAvaliacoes()[i] = avaliacao;
                break;
            }
        }
    }

    public double getTotalRating(){
        double total = 0;
        double contador = 0;
        for(Avaliacao avaliacao : this.getAvaliacoes()){
            if(avaliacao != null) {
                total += avaliacao.getRating();
                contador++;
            }
        }
        return total/contador;
    }

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

    public Avaliacao[] getAvaliacoes() {
        return this.avaliacoes;
    }

    public void setAvaliacoes(Avaliacao[] avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
