package classes.pedido;

import classes.lanches.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pedido {

    //Atributos
    private final ArrayList<Lanche> lanches = new ArrayList<>();
    private final LocalDateTime dataPedido = LocalDateTime.now();

    //Métodos
    public void imprimirComanda(){
        System.out.println("Data do pedido: " + getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        for(Lanche lanche : this.getLanches()){
            lanche.mostrarDetalhesComanda();
                /*
                OUTRA FORMA DE PRINTAR OS NOMES DOS LANCHES
                String classes = this.getClass().getName();
                System.out.println("==" + (classes).replace("classes.", "") + "==");
                */

            System.out.println("--INGREDIENTES--");
            for(String ingrediente : lanche.getIngredientes()){
                System.out.println(ingrediente);
            }
            System.out.println("------------");
            System.out.printf("Valor: R$%.2f\n", lanche.getValor());
        }
        System.out.println("##############\nTOTAL: R$" + this.calcularValorTotal());
        System.out.println("##############\n");
    }

    public double calcularValorTotal(){
        double total = 0;
        for(Lanche lanche:this.getLanches()) {
            total = total + lanche.getValor();
        }
        return total;
    }

    public void adicionarLanche(Lanche lanche){
        this.lanches.add(lanche);
    }

    //Getters & Settes
    public ArrayList<Lanche> getLanches() {
        return this.lanches;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }
}
