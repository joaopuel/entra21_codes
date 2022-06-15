package classes.lanches;

public class Pizza extends MiniPizza{
    private String tamanhoPizza;
    public Pizza(){
        this.setTipo("Pizza");
    }

    public void setTamanhoPizza(String tamanho){
        this.tamanhoPizza = tamanho;
    }

    public String getTamanhoPizza(){
        return this.tamanhoPizza;
    }
}
