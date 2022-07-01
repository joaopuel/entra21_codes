public enum PlayerOption {
    ;

    //Atributos
    private final int value;
    private final String description;

    //Construtor
    PlayerOption(int value, String description){
        this.value = value;
        this.description = description;
    }

    //Getters
    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
