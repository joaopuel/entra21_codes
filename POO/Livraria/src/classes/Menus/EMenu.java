package classes.Menus;

import classes.IMenu;

import java.util.Arrays;

public enum EMenu implements IMenu {
    ADICIONAR_ITEM(1, "Adicionar item"),
    BUSCAR_ITEM(2, "Buscar item"),
    REMOVER_ITEM(3, "Remover item"),
    MOSTRAR_ITENS(4, "Mostrar itens da estante"),
    SAIR(0, "Sair");

    //Atributos
    private final int valor;
    private final String descricao;

    //Construtor
    EMenu(int valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }

    //Métodos
    public static EMenu getByValorOpcao(int escolha) {
        return Arrays.stream(EMenu.values()).filter(EMenu -> EMenu.getValor()==escolha).findFirst().orElse(null);
    }

    //Getters
    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
