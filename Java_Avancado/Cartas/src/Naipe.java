public enum Naipe {
    COPAS("♥"),
    PAUS("♣"),
    OURO("♦"),
    ESPADAS("♠");

    private String naipe;
    Naipe(String naipe){
        this.naipe = naipe;
    }

    public String getNaipe() {
        return naipe;
    }
}