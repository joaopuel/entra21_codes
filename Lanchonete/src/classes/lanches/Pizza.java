package classes.lanches;

import java.util.Scanner;

public class Pizza extends MiniPizza{

    //Atributos
    private String tamanhoPizza;

    //Construtor
    public Pizza(){
        this.setTipo("Pizza");
    }

    //Métodos
    @Override
    public void mostrarDetalhesComanda(){
        super.mostrarDetalhesComanda();
        System.out.println("-- TAMANHO: " + this.getTamanhoPizza().toUpperCase() + " --");
    }

    @Override
    public void mostrarDetalhesLanche(Scanner in){
        super.mostrarDetalhesLanche(in);

        System.out.println("Informe o tamanho da pizza");
        System.out.println("XS - broto");
        System.out.println("SM - pequena");
        System.out.println("MD - média");
        System.out.println("LG - grande");
        System.out.println("XL - família");
        this.setTamanhoPizza(in.nextLine().toUpperCase());
    }
    //Getters & Setters
    public void setTamanhoPizza(String tamanho){
        this.tamanhoPizza = tamanho;
    }

    public String getTamanhoPizza(){
        return this.tamanhoPizza;
    }
}
