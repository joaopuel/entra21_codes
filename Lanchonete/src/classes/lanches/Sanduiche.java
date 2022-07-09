package classes.lanches;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Sanduiche extends Lanche{
    //Atributos
    private final HashMap<String, Double> adicionais = new HashMap<>();

    //Métodos
    public void adicionarAdicionais(String adicional, double valor){
        this.adicionais.put(adicional, valor);
    }

    @Override
    public void mostrarDetalhesComanda() {
        System.out.println("==" + this.getTipo() + "==");
        if (!this.adicionais.isEmpty()) {
            System.out.println("--ADICIONAIS--");
            for (String adicional : this.getAdicionais().keySet()) {
                System.out.printf("+ %s: R$%.2f\n", adicional, this.getAdicionais().get(adicional));
            }
            System.out.println("------------");
        }
    }

    @Override
    public void mostrarDetalhesLanche(Scanner in){
        System.out.print("Deseja adicionais? (S/N)");
        String adicional = in.nextLine();
        if (adicional.equalsIgnoreCase("S")) {
            System.out.println("Escreva \"parar\" quando não quiser mais adicionais.");
            for (int i = 0; i < 10; i++) {
                System.out.print("Insira adicional: ");
                adicional = in.nextLine();
                if (adicional.equalsIgnoreCase("parar")) {
                    break;
                }
                System.out.print("Insira o valor do adicional: R$");
                this.adicionarAdicionais(adicional, in.nextDouble());
                in.nextLine();
                if (i == 9) {
                    System.out.println("Não é possível acrescentar mais adicionais.");
                }
            }
        }
    }

    //Getters & Setters
    public HashMap<String, Double> getAdicionais() {
        return this.adicionais;
    }

    @Override
    public double getValor(){
        double total=0;
        for(String adicional : this.getAdicionais().keySet()){
            total+=this.getAdicionais().get(adicional);
        }
        return super.getValor()+total;
    }
}
