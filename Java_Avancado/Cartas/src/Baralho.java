import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
    //Atributos
    private ArrayList<Carta> cartas = new ArrayList<>();

    //Construtor
    public Baralho(){
        for(Naipe naipe : Naipe.values()){
            int valor = 1;
            for(ValorCarta valorCarta : ValorCarta.values()){
                Carta carta = new Carta();
                carta.setNaipe(naipe);
                carta.setValorCarta(valorCarta);
                carta.setValorReal(valor);
                valor++;
                this.getCartas().add(carta);
            }
        }
        shuffle();
    }

    //Métodos
    public void shuffle(){
        Collections.shuffle(getCartas());
    }

    public Carta getFromTop(){
        return this.getCartas().remove(0);
    }

    public Carta getFromBottom(){
        return this.getCartas().remove(this.getCartas().size()-1);
    }

    public Carta searchCard(Naipe naipe, ValorCarta valorCarta){
        return this.getCartas().stream().filter(card -> card.getNaipe().equals(naipe) && card.getValorCarta().equals(valorCarta)).findFirst().orElse(null);
    }

    public Carta searchCard(Naipe naipe, int valorReal){
        return this.getCartas().stream().filter(card -> card.getNaipe().equals(naipe) && card.getValorReal() == valorReal).findFirst().orElse(null);
    }

    //Getters & Setters
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
}
