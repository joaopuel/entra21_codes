package classes.lanches;

public class Pizza extends MiniPizza{
    private String tamanhoPizza;
    public Pizza(){
        this.setTipo("Pizza");
    }

    @Override
    public void montarComanda() {
        super.montarComanda();
        System.out.println("-- TAMANHO: " + this.getTamanhoPizza().toUpperCase() + " --");
    }

    public void setTamanhoPizza(String tamanho){
        this.tamanhoPizza = tamanho;
    }

    public String getTamanhoPizza(){
        return this.tamanhoPizza;
    }
}
