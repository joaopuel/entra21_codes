package classes.lanches;

public abstract class Lanche {
    private final String[] ingredientes = new String[10];
    private double valor;
    private String tipo;
    public void adicionarIngredientes(String ingrediente){
        for(int i=0; i<10; i++){
            if(this.ingredientes[i]==null){
                this.ingredientes[i] = ingrediente;
                break;
            }
        }
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String[] getIngredientes() {
        return this.ingredientes;
    }
}
