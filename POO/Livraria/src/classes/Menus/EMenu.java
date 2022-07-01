package classes.Menus;

public enum EMenu {
    SAIR(0, "Sair"),
    ADICIONAR_ITEM(1, "Adicionar item"),
    BUSCAR_ITEM(2, "Buscar item"),
    REMOVER_ITEM(3, "Remover item"),
    MOSTRAR_ITENS(4, "Mostrar itens da estante");

    //Atributos
    private int valor;
    private String descricao;

    //Construtor
    EMenu(int valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }

    //Métodos
    public static EMenu getByValorOpcao(int escolha) {
        for (EMenu e : EMenu.values()) {
            if (e.getValor() == escolha) {
                return e;
            }
        }
        return null;
    }

    //Getters
    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
