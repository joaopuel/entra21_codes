package classes.lanches;

public class MiniPizza extends Lanche{
    private boolean bordaRecheada;
    private String sabor;
    private String saborBorda;
    public MiniPizza(){
        this.adicionarIngredientes("Massa");
        this.adicionarIngredientes("Muzzarela");
        this.adicionarIngredientes("Massa de Tomate");
        this.setTipo("Mini Pizza");
    }
    public void adicionarSaborEIngredientes(String sabor){
        this.setSabor(sabor);
        switch (sabor.toUpperCase()){
            case "4 QUEIJOS":
                this.adicionarIngredientes("Catupiry");
                this.adicionarIngredientes("Provolone");
                this.adicionarIngredientes("Cheddar");
                break;
            case "CALABRESA":
                this.adicionarIngredientes("Calabresa");
                break;
            case "FRANGO C/ CATUPIRY":
                this.adicionarIngredientes("Catupiry");
                this.adicionarIngredientes("Frango");
                break;
            case "MARGUERITA":
                this.adicionarIngredientes("Tomate");
                this.adicionarIngredientes("Manjericão");
                break;
            case "PORTUGUESA":
                this.adicionarIngredientes("Presunto");
                this.adicionarIngredientes("Cebola");
                this.adicionarIngredientes("Ovo");
                break;
        }
    }

    // GETTERS & SETTERS
    public void setBordaRecheada(boolean bordaRecheada){
        this.bordaRecheada = bordaRecheada;
    }

    public boolean isBordaRecheada(){
        return this.bordaRecheada;
    }

    public void setSaborBorda(String saborBorda){
        this.saborBorda = saborBorda;
    }

    public String getSaborBorda(){
        return this.saborBorda;
    }

    public void setSabor(String sabor){
        this.sabor = sabor;
    }

    public String getSabor(){
        return this.sabor;
    }
}
