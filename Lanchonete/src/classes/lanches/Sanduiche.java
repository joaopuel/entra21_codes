package classes.lanches;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Sanduiche extends Lanche{
    //Atributos
    private ArrayList<String> adicionais = new ArrayList<>();

    //Métodos
    public void adicionarAdicionais(String adicional){
        this.adicionais.add(adicional);
    }

    @Override
    public void mostrarDetalhesComanda() {
        System.out.println("==" + this.getTipo() + "==");
        if (!this.adicionais.isEmpty()) {
            System.out.println("--ADICIONAIS--");
            for (String adicional : this.getAdicionais()) {
                System.out.println("+ " + adicional);
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
                System.out.println("Insira adicional: ");
                adicional = in.nextLine();
                if (adicional.equalsIgnoreCase("parar")) {
                    break;
                }
                if (i == 9) {
                    System.out.println("Não é possível acrescentar mais adicionais.");
                }
            }
        }
    }

    //Getters & Setters
    public ArrayList<String> getAdicionais() {
        return this.adicionais;
    }
}
