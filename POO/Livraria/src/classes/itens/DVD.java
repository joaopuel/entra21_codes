package classes.itens;

import java.util.Scanner;

public class DVD extends Item{

    //Atributos
    private String diretor;
    private double duracao;
    private int anoLancamento;

    //Métodos
    @Override
    public void montarDetalhes(Scanner in) {
        System.out.println("Informe o diretor: ");
        this.setDiretor(in.nextLine());
        System.out.println("Informe o ano de lançamento: ");
        this.setAnoLancamento(in.nextInt());
        System.out.println("Informe a duração");
        this.setDuracao(in.nextDouble());
        in.nextLine();
    }

    @Override
    public void mostrarDetalhes() {
        System.out.print("Diretor: "+this.getDiretor());
        System.out.print("Ano de lançamento: "+this.getAnoLancamento());
        System.out.print("Duração: "+this.getDuracao());
    }

    //Getters & Setter
    public String getDiretor() {
        return this.diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public double getDuracao() {
        return this.duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getAnoLancamento() {
        return this.anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
