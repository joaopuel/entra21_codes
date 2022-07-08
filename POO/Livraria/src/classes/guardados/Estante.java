package classes.guardados;

import classes.itens.Item;

import java.util.ArrayList;

public class Estante {

    //Atributos
    private int capMaxima;
    private ArrayList<Item> itens = new ArrayList<>();

    //Construtor
    public Estante(int capacidadeMaxima){
        this.setCapMaxima(capacidadeMaxima);
    }

    //Métodos
    public boolean estanteCheia(){
        return this.quantidadeItens() == this.getCapMaxima();
    }

    public int quantidadeItens(){
        return this.getItens().size();
    }

    public Item buscarItem(String titulo){
        return this.getItens().stream().filter(item -> item.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
    }

    public boolean adcionarItem(Item item){
        if(!estanteCheia()){
            return this.getItens().add(item); //Retorna true always
        }
        return false;
    }

    public Item removerItem(int posicao){
        return this.getItens().remove(posicao);
    }

    //Getters & Setters
    public int getCapMaxima() {
        return capMaxima;
    }

    public void setCapMaxima(int capMaxima) {
        this.capMaxima = capMaxima;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItems(ArrayList<Item> itens) {
        this.itens = itens;
    }
}
