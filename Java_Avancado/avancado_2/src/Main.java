import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ex3();
    }

    public static void ex1(){
        HashMap<String, Double> produtos = new HashMap<>();
        produtos.put("maça", 1.6);
        produtos.put("banana", 0.4);
        produtos.put("abacate", 1.5);
        System.out.println(produtos);
        for(String key : produtos.keySet()){
            System.out.println(key + ": " + produtos.get(key));
        }
    }

    public static void ex2(){
        HashMap<String, Double> produtos = new HashMap<>();
        boolean executa = true;
        while(executa){
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto");
            System.out.println("3 - Mostrar lista de produtos");
            System.out.println("4 - Remover produto");
            System.out.println("0 - Sair");
            int escolha = in.nextInt();
            in.nextLine();

            switch (escolha){
                case 0:
                    executa = false;
                    break;
                case 1:
                    System.out.print("Produto: ");
                    String chave = in.nextLine().toLowerCase();

                    if(produtos.containsKey(chave)){
                        System.out.println("Produto já existente, deseja atualizar o valor? (S/N)");
                        if(in.nextLine().equalsIgnoreCase("N")){
                            continue;
                        }
                    }

                    System.out.print("Valor: ");
                    double valor = in.nextDouble();
                    in.nextLine();
                    produtos.put(chave, valor);
                    break;
                case 2:
                    if(produtos.isEmpty()){
                        System.err.println("Não há produtos cadastrados!");
                    }else {
                        System.out.print("Informe o produto: ");
                        String busca = in.nextLine().toLowerCase();
                        if(produtos.containsKey(busca)){
                            System.out.println(busca + " : " + produtos.get(busca));
                        }else {
                            System.err.println("Produto '" + busca + "' não encontrado!");
                        }
                    }
                    break;
                case 3:
                    System.out.println(produtos);
                    break;
                case 4:
                    if(produtos.isEmpty()){
                        System.err.println("Não há produtos cadastrados!");
                    }else {
                        System.out.print("Informe o produto: ");
                        String busca = in.nextLine().toLowerCase();
                        if(produtos.containsKey(busca)){
                            produtos.remove(busca);
                        }else {
                            System.err.println("Produto '" + busca + "' não encontrado!");
                        }
                    }
                    break;
                default:
                    System.err.println("Informe uma opção válida!");
            }
        }
    }

    public static void ex3(){
        HashMap<String, ArrayList<Carro>> hashMap = new HashMap<>();
        boolean executa = true;
        while(executa){
            System.out.println("Menu:");
            System.out.println("1 - Mostrar lista de veículos disponíveis para venda");
            System.out.println("2 - Cadastrar veículo");
            System.out.println("3 - Vender veículo");
            System.out.println("0 - Sair");
            int escolha = in.nextInt();
            in.nextLine();

            switch (escolha){
                case 0:
                    executa = false;
                    break;
                case 1:
                    if(hashMap.isEmpty()) {
                        System.err.println("Não há veículos cadastrados!");
                    } else {
                        System.out.println();
                        for (String key : hashMap.keySet()) {
                            System.out.println("Marca: " + key);
                            for (Carro carro : hashMap.get(key)) {
                                System.out.println(">> " + carro.getModelo() + " - R$" + carro.getValorVenda());
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Informe a marca: ");
                    String marca = in.nextLine().toLowerCase();
                    ArrayList<Carro> lista = new ArrayList<>();
                    do {
                        Carro carro = new Carro();
                        System.out.print("Informe o modelo: ");
                        carro.setModelo(in.nextLine().toLowerCase());
                        System.out.print("Informe o valor: ");
                        carro.setValorVenda(in.nextDouble());
                        in.nextLine();
                        lista.add(carro);

                        System.out.println("Deseja cadastrar mais um carro? (S/N)");
                    } while (in.nextLine().equalsIgnoreCase("S"));
                    hashMap.put(marca, lista);
                    break;
                case 3:
                    if(hashMap.isEmpty()){
                        System.err.println("Não há veículos cadastrados!");
                    }else {
                        System.out.print("Informe a marca: ");
                        String buscaMarca = in.nextLine().toLowerCase();
                        if(hashMap.containsKey(buscaMarca)){
                            System.out.print("Informe o modelo: ");
                            String buscaModelo = in.nextLine().toLowerCase();
                            System.out.print("Informe o valor: ");
                            double buscaValor = in.nextDouble();
                            in.nextLine();
                            ArrayList<Carro> buscaLista = hashMap.get(buscaMarca);
                            if(!buscaLista.isEmpty()){
                                for (Carro carro : buscaLista){
                                    if(carro.getModelo().equalsIgnoreCase(buscaModelo)){
                                        System.out.println("Veículo " + buscaModelo + " da " + buscaMarca + " -> Vendido!");
                                        buscaLista.remove(carro);
                                    }
                                }
                                // System.err.println("Veículo '" + buscaCarro.getModelo() + "' de valor R$" + buscaCarro.getValorVenda() + " não encontrado!");
                            }else {
                                System.out.println("Não há veículos cadastrados para a marca " + buscaMarca);
                            }
                        }else {
                            System.err.println("Marca '" + buscaMarca + "' não encontrada!");
                        }
                    }
                    break;
                default:
                    System.err.println("Informe uma opção válida!");
            }
        }
    }
}
