public interface MeioTransporte {

    //Métodos
    boolean verificarOcupacao(String verifica);
    int quantidadeLivre();
    void mostrarAssento();
    Assento getAssento(String assento);
}
