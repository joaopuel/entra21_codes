package classes.itens;

public class DVD extends Item{

    //Atributos
    private String diretor;
    private double duracao;
    private int anoLancamento;

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
