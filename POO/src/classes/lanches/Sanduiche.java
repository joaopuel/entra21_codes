package classes.lanches;

public abstract class Sanduiche extends Lanche{
    private final String[] adicionais = new String[10];
    public void adicionarAdicionais(String adicional){
        for(int i=0; i<10; i++){
            if(this.adicionais[i]==null) {
                this.adicionais[i] = adicional;
                break;
            }
        }
    }

    public String[] getAdicionais() {
        return this.adicionais;
    }
}
