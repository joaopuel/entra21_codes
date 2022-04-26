public class Main {

    //comentário de linha

    /* comentário
    de
    bloco */

    static int var1 =10;
    double var3=11.5;
    char var4='A';
    String var5="Frase";
    boolean var6 = true;

    public static void main(String[] args) {
        var1 = var1 + 5;
        ++var1;
        System.out.println(var1);
        System.out.println(++var1);
    }

    /*
    public = pode ser acessada de qualquer lugar do programa
    private = vai ser vista só pela classe que ela foi declarada
    protected = só por classes que estão no mesmo pacote
    */

}
