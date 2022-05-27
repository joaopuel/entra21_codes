package classes;

public class XBurger extends Sanduiche{
    public boolean aberto;
    public XBurger(){
        this.adicionarIngredientes("Hamburguer");
        this.adicionarIngredientes("Queijunto");
        this.adicionarIngredientes("Preijo");
        this.adicionarIngredientes("Pão");
        this.tipo = "XBurguer";
    }
    @Override
    public void montarComanda() {
        super.montarComanda();
        if (this.aberto) {
            System.out.println("-- LANCHE ABERTO --");
        }
    }
}
