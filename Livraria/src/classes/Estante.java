package classes;

public class Estante {

    //Atributos
    private int capMaxima;
    private Item[] items;

    //Construtor
    public Estante(int capacidadeMaxima){
        this.items = new Item[capacidadeMaxima];
    }

    //Métodos
    public boolean estanteCheia(){
        //todo
        return false;
    }

    public int quantidadeItens(){
        //todo
        return 0;
    }

    public Item buscaItem(String titulo){
        //todo
        return null;
    }

    public boolean adcionarItem(Item item){
        //todo
        return false;
    }

    public Item removerItem(int posicao){
        //todo
        return null;
    }

    //Getters & Setters
    public int getCapMaxima() {
        return capMaxima;
    }

    public void setCapMaxima(int capMaxima) {
        this.capMaxima = capMaxima;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
}
