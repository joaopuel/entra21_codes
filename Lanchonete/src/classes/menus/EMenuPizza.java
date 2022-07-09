package classes.menus;

import java.util.Arrays;

public enum EMenuPizza {
    QUATRO_QUEIJOS(1, "4 Queijos"),
    CALABRESA(2, "Calabresa"),
    FRANCO_COM_CATUPIRY(3, "Frango c/ catupiry"),
    MARGUERITA(4, "Marguerita"),
    PORTUGUESA(5, "Portuguesa");

    //Atributos
    private final int valorOpcao;
    private final String descricao;

    //Construtor
    EMenuPizza(int valorOpcao, String descricao){
        this.valorOpcao = valorOpcao;
        this.descricao = descricao;
    }

    //Métodos
    public static EMenuPizza getByValorOpcao(int valorOpcao){
        return Arrays.stream(EMenuPizza.values()).filter(EMenuPizza -> EMenuPizza.getValorOpcao() == valorOpcao).findFirst().orElse(null);
    }

    //Getters
    public int getValorOpcao() {
        return valorOpcao;
    }

    public String getDescricao() {
        return descricao;
    }
}
