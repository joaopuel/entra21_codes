package classes.lanches;

public class HotDog extends Sanduiche{
    public HotDog(){
        this.adicionarIngredientes("Pão");
        this.adicionarIngredientes("Salsicha");
        this.adicionarIngredientes("Purê de batata");
        this.adicionarIngredientes("Batata palha");
        this.adicionarIngredientes("Vinagrete");
        this.adicionarIngredientes("Queijo Cheddar");
        this.adicionarIngredientes("Milho");
        this.adicionarIngredientes("Ervilha");
        this.setTipo("Hot Dog");
    }
}
