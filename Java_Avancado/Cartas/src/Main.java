import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Carta> baralho = new ArrayList<>();
        for(Naipe naipe : Naipe.values()){
            for(ValorCarta valorCarta : ValorCarta.values()){
                Carta carta = new Carta();
                carta.setNaipe(naipe);
                carta.setValorCarta(valorCarta);
                baralho.add(carta);
            }
        }

        for(Carta carta : baralho){
            System.out.println(carta.getValorCarta() + " de " + carta.getNaipe() + ": " + carta.getNaipe().getNaipe() + " " + carta.getValorCarta().getValor() + " " + carta.getNaipe().getNaipe());
        }


    }
}
