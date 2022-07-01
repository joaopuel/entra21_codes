public enum Naipe {
    COPAS("♥"),
    PAUS("♣"),
    OURO("♦"),
    ESPADAS("♠");

    private final String naipe;
    Naipe(String naipe){
        this.naipe = naipe;
    }

    public String getNaipe() {
        return naipe;
    }
}