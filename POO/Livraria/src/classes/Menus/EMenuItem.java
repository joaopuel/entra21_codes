package classes.Menus;

import classes.IMenu;

import java.util.Arrays;

public enum EMenuItem implements IMenu {
    AVALIAR_ITEM(1, "Avaliar item"),
    VER_AVALIACOES(2, "Ver avaliações"),
    MOSTRAR_DETALHES(3, "Mostrar detalhes"),
    VOLTAR(0, "Voltar");

    //Atributos
    private final int valor;
    private final String descricao;

    //Construtor
    EMenuItem(int valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }

    //Métodos
    public static EMenuItem getByValorOpcao(int escolha){
        return Arrays.stream(EMenuItem.values()).filter(EMenuItem -> EMenuItem.getValor()==escolha).findFirst().orElse(null);
    }

    //Getters
    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}