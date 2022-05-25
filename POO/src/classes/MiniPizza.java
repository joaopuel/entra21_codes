package classes;

public class MiniPizza extends Lanche{
    public boolean bordaRecheada;
    public String saborBorda;
    public MiniPizza(){
        this.adicionarIngredientes("Massa");
        this.adicionarIngredientes("Queijo");
        this.adicionarIngredientes("Calabresa");
        this.adicionarIngredientes("Extrato de Tomate");
        this.tipo = "Mini Pizza";
    }
    @Override
    public void montarComanda() {
        super.montarComanda();
        if (this.bordaRecheada) {
            System.out.println("-- COM BORDA RECHEADA: " + this.saborBorda.toUpperCase() + " --");
        }
    }
}
