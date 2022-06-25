import java.util.ArrayList;

public class Aviao implements MeioTransporte{

    //Atributos
    private ArrayList<AssentoVoo> assentos = new ArrayList<>();

    //Cosntrutor
    public Aviao(int linhasCadeirasLuxo, int linhasCadeirasEconomicas){
        int letraCodigo = 65;
        for(int i=1; i<=(linhasCadeirasLuxo*4); i++){
            AssentoVoo assentoVoo = new AssentoVoo();
            assentoVoo.setClasse("Executiva");
            char letra = (char) letraCodigo;
            if(i<10){
                assentoVoo.setCodigo(letra + "0" + i);
            }else {
                assentoVoo.setCodigo(letra + "" + i);
            }
            this.getAssentos().add(assentoVoo);
            letraCodigo++;
            if(i % 4 == 0){
                letraCodigo = 65;
            }
        }
        letraCodigo = 65;
        for(int i=1; i<=(linhasCadeirasEconomicas*6); i++){
            AssentoVoo assentoVoo = new AssentoVoo();
            assentoVoo.setClasse("Econômica");
            char letra = (char) letraCodigo;
            if(i<10){
                assentoVoo.setCodigo(letra + "0" + i);
            }else {
                assentoVoo.setCodigo(letra + "" + i);
            }
            this.getAssentos().add(assentoVoo);
            letraCodigo++;
            if(i % 6 == 0){
                letraCodigo = 65;
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
        System.out.println("\t-- EXECUTIVA --");
        for(int i=0; i<this.getAssentos().size(); i++){
            if(getAssentos().get(i).getClasse().equalsIgnoreCase("Econômica")){
                break;
            }
            System.out.print("\t" + this.getAssentos().get(i).getCodigo());
            if((i+1) % 4 == 0){
                System.out.println();
            }
        }
        System.out.println("\t-- ECONÔMICA --");
        for(int i=0; i<this.getAssentos().size(); i++){
            if(getAssentos().get(i).getClasse().equalsIgnoreCase("Executiva")){
                continue;
            }
            System.out.print("\t" + this.getAssentos().get(i).getCodigo());
            if((i+1) % 4 == 0){
                System.out.println();
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
