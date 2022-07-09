package classes.menus;
import java.util.Arrays;

public enum EMenu {
    XSALADA(1, "X-Salada"),
    XBURGUER(2, "X-Burguer"),
    MISTO_QUENTE(3, "Misto Quente"),
    HOT_DOG(4, "Mini Pizza"),
    MINIPIZZA(5, "Mini Pizza"),
    PIZZA(6, "Pizza");

    //Atrinutos
    private final int valorOpcao;
    private final String descricao;

    //Construtor
    EMenu(int valorOpcao, String descricao){
        this.valorOpcao = valorOpcao;
        this.descricao = descricao;
    }

    //Métodos
    public static EMenu getByValorOpcao(int valorOpcao){
        return Arrays.stream(EMenu.values()).filter(EMenu -> EMenu.getValorOpcao() == valorOpcao).findFirst().orElse(null);
    }

    //Getters
    public int getValorOpcao() {
        return valorOpcao;
    }

    public String getDescricao() {
        return descricao;
    }
}
