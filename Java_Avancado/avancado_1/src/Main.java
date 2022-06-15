import java.util.*;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ex3();

    }

    public static void ex1(){
//        Pedir pro usuário informar n números interos até ele digitar 0
//        Quando ele digitar 0, mostrar a lista dos números digitados por ele
        ArrayList<Integer> inteiros = new ArrayList<Integer>();
        while(true){
            System.out.println("Informe um valor inteiro: ");
            int escolha = in.nextInt();
            in.nextLine();
            inteiros.add(escolha);

            if (escolha == 0){
                break;
            }
        }
        System.out.println("Valores informados: ");
        System.out.println(inteiros);
    }

    public static void ex2(){
        /* Pedir pro usuário informar valores até que seja informado 0
           Quando for informado 0, mostrar os valores que o usuário digitou
           mostrar a soma dos números pares e dos números ímpares informados
           mostrar a média de todos os valores informados
        */

        ArrayList<Integer> arr = new ArrayList<>();
        int soma_par=0, soma_impar=0;
        while(true){
            System.out.print("Informe um valor: ");
            int escolha = in.nextInt();
            in.nextLine();
            arr.add(escolha);
            if(escolha%2==0){
                soma_par += escolha;
            }else {
                soma_impar += escolha;
            }
            if(escolha == 0) {
                break;
            }
        }

        double mediaTotal = (double) (soma_par+soma_impar)/arr.size();

        System.out.println("Soma de pares = " + soma_par);
        System.out.println("Soma de impares = " + soma_impar);
        System.out.printf("Média total = %.2f", mediaTotal);
    }

    public static void ex3(){
//        1 - Ler o input do usuário (String) até que seja informado SAIR
//        2 - Pedir pro usuário um valor inteiro > 0
//        3 - Remover da listas as palavras que tenha a quantidade de caracteres menor que o número informado

        ArrayList<String> arr = new ArrayList<>();

        while(true) {
            System.out.print("Informe uma palavra: ");
            String palavra = in.nextLine();

            if (palavra.equalsIgnoreCase("SAIR")){
                break;
            }

            arr.add(palavra);
        }

        System.out.print("Informe um número: ");
        int num = in.nextInt();
        in.nextLine();

        for(int i = 0; i <  arr.size(); i++) {
            if((arr.get(i)).length() < num){
                arr.remove(i);
                i--;
            }
        }
        System.out.println(arr);
    }
}
