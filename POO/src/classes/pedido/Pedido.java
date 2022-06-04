package classes.pedido;

import classes.lanches.*;

public class Pedido {
    private final Lanche[] lanches = new Lanche[10];

    public void imprimirComanda(){
        for(Lanche lanche : this.getLanches()){
            if(lanche != null){
                if(lanche instanceof MiniPizza){
                    MiniPizza miniPizza = ((MiniPizza)lanche);
                    System.out.println("==" + lanche.getTipo() + " - " + miniPizza.getSabor() + "==");
                    if (miniPizza.isBordaRecheada()) {
                        System.out.println("-- COM BORDA RECHEADA: " + miniPizza.getSaborBorda().toUpperCase() + " --");
                    }
                    if(lanche instanceof Pizza){
                        System.out.println("-- TAMANHO: " + ((Pizza)lanche).getTamanhoPizza().toUpperCase() + " --");
                    }
                }else {
                    System.out.println("==" + lanche.getTipo() + "==");
                    if(lanche instanceof XBurger){
                        if (((XBurger)lanche).isAberto()) {
                            System.out.println("-- LANCHE ABERTO --");
                        }
                    }
                }

                /*
                OUTRA FORMA DE PRINTAR OS NOMES DOS LANCHES
                String classes = this.getClass().getName();
                System.out.println("==" + (classes).replace("classes.", "") + "==");
                */

                System.out.println("--INGREDIENTES--");
                for(String ingrediente : lanche.getIngredientes()){
                    if(ingrediente != null){
                        System.out.println(ingrediente);
                    }
                }
                System.out.println("------------");
                if(lanche instanceof Sanduiche){
                    Sanduiche sanduiche = ((Sanduiche) lanche);
                    if (sanduiche.getAdicionais()[0] != null) {
                        System.out.println("--ADICIONAIS--");
                        for (String adicional : sanduiche.getAdicionais()) {
                            if (adicional != null) {
                                System.out.println("+ " + adicional);
                            }
                        }
                        System.out.println("------------");
                    }
                }
                System.out.printf("Valor: R$%.2f\n", lanche.getValor());
            }
        }
        System.out.println("##############\nTOTAL: R$" + calcularValorTotal());
        System.out.println("##############\n");
    }
    public double calcularValorTotal(){
        double total = 0;
        for(Lanche lanche:this.getLanches()) {
            if(lanche != null){
                total = total + lanche.getValor();
            }
        }
        return total;
    }

    public void adicionarLanche(Lanche lanche){
        for(int i=0; i<10; i++) {
            if(this.getLanches()[i] == null) {
                this.getLanches()[i] = lanche;
                break;
            }
        }
    }

    public Lanche[] getLanches() {
        return this.lanches;
    }
}
