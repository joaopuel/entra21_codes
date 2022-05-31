package classes;

public class XBurger extends Sanduiche{
    private boolean aberto;
    public XBurger(){
        this.adicionarIngredientes("Hamburguer");
        this.adicionarIngredientes("Queijunto");
        this.adicionarIngredientes("Preijo");
        this.adicionarIngredientes("Pão");
        this.setTipo("XBurguer");
    }
    @Override
    public void montarComanda() {
        super.montarComanda();
        if (this.isAberto()) {
            System.out.println("-- LANCHE ABERTO --");
        }
    }

    public void setAberto(boolean aberto){
        this.aberto = aberto;
    }

    public boolean isAberto(){
        return this.aberto;
    }
}
