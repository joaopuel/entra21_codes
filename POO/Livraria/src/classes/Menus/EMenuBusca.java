package classes.Menus;

import classes.IMenu;

import java.util.Arrays;

public enum EMenuBusca implements IMenu {
    AVALIAR(1, "Avaliar"),
    VER_AVALIACOES(2, "Ver avaliações"),
    VOLTAR(0, "Voltar");

    //Atributos
    private final int valor;
    private final String descricao;

    //Construtor
    EMenuBusca(int valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }

    //Métodos
    public static EMenuBusca getByValorOpcao(int escolha){
        return Arrays.stream(EMenuBusca.values()).filter(EMenuBusca -> EMenuBusca.getValor()==escolha).findFirst().orElse(null);
    }

    //Getters
    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}