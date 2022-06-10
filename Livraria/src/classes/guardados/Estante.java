package classes.guardados;

import classes.itens.Item;

import java.util.Locale;

public class Estante {

    //Atributos
    private int capMaxima;
    private Item[] items;

    //Construtor
    public Estante(int capacidadeMaxima){
        setCapMaxima(capacidadeMaxima);
        setItems(new Item[capacidadeMaxima]);
    }

    //Métodos
    public boolean estanteCheia(){
        return this.quantidadeItens() == this.getCapMaxima();
    }

    public int quantidadeItens(){
        int cont = 0;
        for(Item item : this.getItems()){
            if(item != null){
                cont++;
            }
        }
        return cont;
    }

    public Item buscaItem(String titulo){
        for(Item item : this.getItems()){
            if(item != null && item.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                return item;
            }
        }
        return null;
    }

    public boolean adcionarItem(Item item){
        for(int i=0; i < this.getCapMaxima(); i++){
            if(this.getItems()[i] == null){
                this.getItems()[i] = item;
                return true;
            }
        }
        return false;
    }

    public Item removerItem(int posicao){
        Item item = this.getItems()[posicao];
        this.getItems()[posicao] = null;
        return item;
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
