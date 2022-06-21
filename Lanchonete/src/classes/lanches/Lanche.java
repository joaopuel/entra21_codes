package classes.lanches;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Lanche {

    //Atributos
    private ArrayList<String> ingredientes = new ArrayList<>();
    private double valor;
    private String tipo;

    //Métodos
    public void adicionarIngredientes(String ingrediente){
        this.ingredientes.add(ingrediente);
    }

    public abstract void mostrarDetalhesComanda();

    public abstract void mostrarDetalhesLanche(Scanner in);

    //Getters & Setters
    public void setValor(double valor){
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

    public ArrayList<String> getIngredientes() {
        return this.ingredientes;
    }
}
