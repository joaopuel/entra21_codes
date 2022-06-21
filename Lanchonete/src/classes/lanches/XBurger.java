package classes.lanches;

import java.util.Scanner;

public class XBurger extends Sanduiche{

    //Atributos
    private boolean aberto;

    //Construtor
    public XBurger(){
        this.adicionarIngredientes("Hamburguer");
        this.adicionarIngredientes("Queijunto");
        this.adicionarIngredientes("Preijo");
        this.adicionarIngredientes("Pão");
        this.setTipo("XBurguer");
    }

    //Métodos
    @Override
    public void mostrarDetalhesComanda(){
        super.mostrarDetalhesComanda();
        if (this.isAberto()) {
            System.out.println("-- LANCHE ABERTO --");
        }
    }

    @Override
    public void mostrarDetalhesLanche(Scanner in){
        super.mostrarDetalhesLanche(in);
        System.out.print("Lanche aberto? (S/N)");
        String aberto = in.nextLine();
        this.setAberto(aberto.equalsIgnoreCase("S"));
    }


    //Getters & Setters
    public void setAberto(boolean aberto){
        this.aberto = aberto;
    }

    public boolean isAberto(){
        return this.aberto;
    }
}
