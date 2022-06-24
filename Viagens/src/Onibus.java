import java.util.ArrayList;

public class Onibus implements MeioTransporte{

    //Atributos
    private ArrayList<AssentoOnibus> assentos = new ArrayList<>();

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
            if(verificarOcupacao(assentoOnibus.getLugar())){
                qtdeLivre++;
            }
        }
        return qtdeLivre;
    }

    @Override
    public void mostrarAssento() {
        //todo
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
}
