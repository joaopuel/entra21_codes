import java.util.ArrayList;

public class Onibus implements MeioTransporte{

    private static final String setRed =  "\u001B[31m";
    private static final String setGreen =  "\u001B[32m";
    private static final String setWhite = "\u001B[0m";

    //Atributos
    private ArrayList<AssentoOnibus> assentos = new ArrayList<>();
    private boolean leito;

    //Construtor
    public Onibus(int linhasCadeiras){
        for(int i=1; i<=(linhasCadeiras*4); i++){
            AssentoOnibus assentoOnibus = new AssentoOnibus();
            if(i<10){
                assentoOnibus.setLugar("0" + i);
            }else{
                assentoOnibus.setLugar("" + i);
            }
            this.getAssentos().add(assentoOnibus);
        }
    }

    //Métodos
    @Override
    public boolean verificarOcupacao(String lugar) {
        for(AssentoOnibus assentoOnibus : this.getAssentos()){
            if(assentoOnibus.getLugar().equalsIgnoreCase(lugar)){
                return assentoOnibus.isOcupado();
            }
        }
        return false;
    }

    @Override
    public int quantidadeLivre() {
        int qtdeLivre = 0;
        for(AssentoOnibus assentoOnibus : this.getAssentos()){
            if(!assentoOnibus.isOcupado()){
                qtdeLivre++;
            }
        }
        return qtdeLivre;
    }

    @Override
    public void mostrarAssento() {
        for(int i=0; i<this.getAssentos().size(); i++){
            if(this.getAssentos().get(i).isOcupado()){
                System.out.print(setRed);
                System.out.print("[XX]\t");
            }else {
                System.out.print(setGreen);
                System.out.print("[" + this.getAssentos().get(i).getLugar() + "]\t");
            }
            System.out.print(setWhite);
            if((i+1) % 4 == 0){
                System.out.println();
            }else if((i+1) % 2 ==0){
                System.out.print("||\t");
            }
        }
    }

    @Override
    public Assento getAssento(String lugar) {
        for(AssentoOnibus assentoOnibus : this.getAssentos()){
            if(assentoOnibus.getLugar().equalsIgnoreCase(lugar)){
                return assentoOnibus;
            }
        }
        return null;
    }

    //Getters & Setters
    public ArrayList<AssentoOnibus> getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<AssentoOnibus> assentos) {
        this.assentos = assentos;
    }

    public boolean isLeito() {
        return leito;
    }

    public void setLeito(boolean leito) {
        this.leito = leito;
    }
}
