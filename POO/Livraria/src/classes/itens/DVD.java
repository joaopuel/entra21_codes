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
        System.out.print("Diretor: ");
        this.setDiretor(in.nextLine());
        System.out.print("Duração: ");
        this.setDuracao(in.nextDouble());
        in.nextLine();
        System.out.print("Ano de lançamento: ");
        this.setAnoLancamento(in.nextInt());
        in.nextLine();
    }

    @Override
    public void mostrarDetalhes() {
        System.out.print(": " + this.getAnoLancamento());
        System.out.print(" - " + this.getDiretor());
        System.out.print(" (Dur: " + this.getDuracao() + "h)");
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
