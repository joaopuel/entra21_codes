package classes.lanches;

import java.util.Scanner;

public class MiniPizza extends Lanche{

    //Atributos
    private boolean bordaRecheada;
    private String sabor;
    private String saborBorda;

    //Construtor
    public MiniPizza(){
        this.adicionarIngredientes("Massa");
        this.adicionarIngredientes("Muzzarela");
        this.adicionarIngredientes("Massa de Tomate");
        this.setTipo("Mini Pizza");
    }

    //Métodos
    public void adicionarSaborEIngredientes(String sabor){
        this.setSabor(sabor);
        switch (sabor.toUpperCase()){
            case "4 QUEIJOS":
                this.adicionarIngredientes("Catupiry");
                this.adicionarIngredientes("Provolone");
                this.adicionarIngredientes("Cheddar");
                break;
            case "CALABRESA":
                this.adicionarIngredientes("Calabresa");
                break;
            case "FRANGO C/ CATUPIRY":
                this.adicionarIngredientes("Catupiry");
                this.adicionarIngredientes("Frango");
                break;
            case "MARGUERITA":
                this.adicionarIngredientes("Tomate");
                this.adicionarIngredientes("Manjericão");
                break;
            case "PORTUGUESA":
                this.adicionarIngredientes("Presunto");
                this.adicionarIngredientes("Cebola");
                this.adicionarIngredientes("Ovo");
                break;
        }
    }

    @Override
    public void mostrarDetalhesComanda(){
        System.out.println("==" + this.getTipo() + " - " + this.getSabor() + "==");
        if (this.isBordaRecheada()) {
            System.out.println("-- COM BORDA RECHEADA: " + this.getSaborBorda().toUpperCase() + " --");
        }
    }

    @Override
    public void mostrarDetalhesLanche(Scanner in){
        System.out.println("Escolha o sabor:");
        System.out.println("(1) - 4 Queijos");
        System.out.println("(2) - Calabresa");
        System.out.println("(3) - Frango c/ catupiry");
        System.out.println("(4) - Marguerita");
        System.out.println("(5) - Portuguesa");
        int sabor = in.nextInt();
        in.nextLine();

        switch (sabor) {
            case 1:
                this.adicionarSaborEIngredientes("4 Queijos");
                break;
            case 2:
                this.adicionarSaborEIngredientes("Calabresa");
                break;
            case 3:
                this.adicionarSaborEIngredientes("Frango c/ catupiry");
                break;
            case 4:
                this.adicionarSaborEIngredientes("Marguerita");
                break;
            case 5:
                this.adicionarSaborEIngredientes("Portuguesa");
                break;
            default:
                System.err.println("Escolha um sabor válido");
        }

        System.out.print("Borda recheada? (S/N)");
        String recheada = in.nextLine();
        this.setBordaRecheada(recheada.equalsIgnoreCase("S"));
        if (this.isBordaRecheada()) {
            System.out.print("Sabor da borda: ");
            this.setSaborBorda(in.nextLine());
        }
    }

    // GETTERS & SETTERS
    public void setBordaRecheada(boolean bordaRecheada){
        this.bordaRecheada = bordaRecheada;
    }

    public boolean isBordaRecheada(){
        return this.bordaRecheada;
    }

    public void setSaborBorda(String saborBorda){
        this.saborBorda = saborBorda;
    }

    public String getSaborBorda(){
        return this.saborBorda;
    }

    public void setSabor(String sabor){
        this.sabor = sabor;
    }

    public String getSabor(){
        return this.sabor;
    }
}
