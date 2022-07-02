package classes.Menus;

import classes.IMenu;

import java.util.Arrays;

public enum EMenuAdiciona implements IMenu {
    LIVRO(1, "Livro"),
    DVD(2, "DVD");

    //Atributos
    private final int valor;
    private final String descricao;

    //Construtor
    EMenuAdiciona(int valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }

    //Métodos
    public static EMenuAdiciona getByValorOpcao(int escolha){
        return Arrays.stream(EMenuAdiciona.values()).filter(EMenuAdiciona -> EMenuAdiciona.getValor() == escolha).findFirst().orElse(null);
    }

    //Getters
    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
