import java.util.ArrayList;

public class Aviao implements MeioTransporte{

    private static final String setRed =  "\u001B[31m";
    private static final String setGreen =  "\u001B[32m";
    private static final String setWhite = "\u001B[0m";

    //Atributos
    private ArrayList<AssentoVoo> assentos = new ArrayList<>();

    //Cosntrutor
    public Aviao(int linhasCadeirasLuxo, int linhasCadeirasEconomicas){
        int letraCodigo = 65;
        int num = 1;
        for(int i=1; i<=(linhasCadeirasLuxo*4); i++){
            AssentoVoo assentoVoo = new AssentoVoo();
            assentoVoo.setClasse("Executiva");
            char letra = (char) letraCodigo;
            if(num<10){
                assentoVoo.setCodigo(letra + "0" + num);
            }else {
                assentoVoo.setCodigo(letra + "" + num);
            }
            this.getAssentos().add(assentoVoo);
            letraCodigo++;
            if(i % 4 == 0){
                letraCodigo = 65;
                num++;
            }
        }
        letraCodigo = 65;
        num = 1;
        for(int i=1; i<=(linhasCadeirasEconomicas*6); i++){
            AssentoVoo assentoVoo = new AssentoVoo();
            assentoVoo.setClasse("Econômica");
            char letra = (char) letraCodigo;
            if(num<10){
                assentoVoo.setCodigo(letra + "0" + num);
            }else {
                assentoVoo.setCodigo(letra + "" + num);
            }
            this.getAssentos().add(assentoVoo);
            letraCodigo++;
            if(i % 6 == 0){
                letraCodigo = 65;
                num++;
            }
        }
        /*Pode ser também
        this.getAssentos().get(i).setCodigo(String.valueOf(i));
        this.getAssentos().get(i).setCodigo(((Integer) i.toString));*/
    }

    //Métodos
    @Override
    public boolean verificarOcupacao(String codigo) {
        for(AssentoVoo assentoVoo : this.getAssentos()){
            if(assentoVoo.getCodigo().equalsIgnoreCase(codigo)){
                return assentoVoo.isOcupado();
            }
        }
        return false;
    }

    @Override
    public int quantidadeLivre() {
        int qtdeLivre = 0;
        for(AssentoVoo assentoVoo : this.getAssentos()){
            if(!assentoVoo.isOcupado()){
                qtdeLivre++;
            }
        }
        return qtdeLivre;
    }

    @Override
    public void mostrarAssento() {
        System.out.println("\t\t\t\t-- EXECUTIVA --");
        System.out.print("\t\t");
        int pos = 0;
        for(int i=0; i<this.getAssentos().size(); i++){
            if(getAssentos().get(i).getClasse().equalsIgnoreCase("Econômica")){
                pos = i;
                break;
            }

            if(this.getAssentos().get(i).isOcupado()){
                System.out.print(setRed);
                System.out.print("[XXX]\t");
            }else {
                System.out.print(setGreen);
                System.out.print("[" + this.getAssentos().get(i).getCodigo() + "]\t");
            }
            System.out.print(setWhite);
            if((i+1) % 4 == 0){
                System.out.print("\n\t\t");
            }else if((i+1) % 2 ==0){
                System.out.print("||\t");
            }

        }
        System.out.println("\n\t\t\t\t-- ECONÔMICA --");
        for(int i=pos; i<this.getAssentos().size(); i++){

            if(this.getAssentos().get(i).isOcupado()){
                System.out.print(setRed);
                System.out.print("[XXX]\t");
            }else {
                System.out.print(setGreen);
                System.out.print("[" + this.getAssentos().get(i).getCodigo() + "]\t");
            }
            System.out.print(setWhite);
            if((i-1) % 6 == 0){
                System.out.println();
            }else if((i-1) % 3 ==0){
                System.out.print("||\t");
            }

        }
    }

    @Override
    public Assento getAssento(String assento) {
        for(AssentoVoo assentoVoo : this.getAssentos()){
            if(assentoVoo.getCodigo().equalsIgnoreCase(assento)){
                return assentoVoo;
            }
        }
        return null;
    }

    public Assento getAssento(String assento, String classe) {
        for(AssentoVoo assentoVoo : this.getAssentos()){
            if(assentoVoo.getCodigo().equalsIgnoreCase(assento) && assentoVoo.getClasse().equalsIgnoreCase(classe)){
                return assentoVoo;
            }
        }
        return null;
    }

    //Getters & Setters
    public ArrayList<AssentoVoo> getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<AssentoVoo> assentos) {
        this.assentos = assentos;
    }
}
