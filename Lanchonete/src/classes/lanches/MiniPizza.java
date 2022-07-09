package classes.lanches;

import classes.menus.EMenuPizza;

import java.util.Arrays;
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
    public void adicionarSaborEIngredientes(EMenuPizza sabor){
        this.setSabor(sabor.getDescricao());
        switch (sabor) {
            case QUATRO_QUEIJOS -> {
                this.adicionarIngredientes("Catupiry");
                this.adicionarIngredientes("Provolone");
                this.adicionarIngredientes("Cheddar");
            }
            case CALABRESA -> this.adicionarIngredientes("Calabresa");
            case FRANCO_COM_CATUPIRY -> {
                this.adicionarIngredientes("Catupiry");
                this.adicionarIngredientes("Frango");
            }
            case MARGUERITA -> {
                this.adicionarIngredientes("Tomate");
                this.adicionarIngredientes("Manjericão");
            }
            case PORTUGUESA -> {
                this.adicionarIngredientes("Presunto");
                this.adicionarIngredientes("Cebola");
                this.adicionarIngredientes("Ovo");
            }
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

        EMenuPizza sabor = escolherOpcao(in);

        this.adicionarSaborEIngredientes(sabor);

        System.out.print("Borda recheada? (S/N)");
        String recheada = in.nextLine();
        this.setBordaRecheada(recheada.equalsIgnoreCase("S"));
        if (this.isBordaRecheada()) {
            System.out.print("Sabor da borda: ");
            this.setSaborBorda(in.nextLine());
        }
    }

    private EMenuPizza escolherOpcao(Scanner in) {
        EMenuPizza opcao = null;
        while(opcao == null) {
            try {
                System.out.println("Escolha o sabor:");
                Arrays.stream(EMenuPizza.values()).forEach(EMenuPizza -> {
                    System.out.printf("(%d) - %s\n", EMenuPizza.getValorOpcao(), EMenuPizza.getDescricao());
                });
                System.out.println("Selecione uma opção: ");
                opcao = EMenuPizza.getByValorOpcao(in.nextInt());
            }catch (RuntimeException e){
                System.out.println("Selecione uma opção válida!");
            }finally {
                in.nextLine();
            }
        }
        return opcao;
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
