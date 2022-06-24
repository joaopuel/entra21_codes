import java.util.ArrayList;

public class Aviao implements MeioTransporte{

    //Atributos
    private ArrayList<AssentoVoo> assentos = new ArrayList<>();

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
            if(verificarOcupacao(assentoVoo.getCodigo())){
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
    public Assento getAssento(String codigo) {
        for(AssentoVoo assentoVoo : this.getAssentos()){
            if(assentoVoo.getCodigo().equalsIgnoreCase(codigo)){
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
