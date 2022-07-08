import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ex5();
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
                        System.out.println("\n** Catálogo **");
                        for (String key : hashMap.keySet()) {
                            System.out.println("--- " + key.toUpperCase() + " ---");
                            for (Carro carro : hashMap.get(key)) {
                                System.out.printf(">> %s: R$%.2f\n", carro.getModelo().toUpperCase(), carro.getValorVenda());
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Informe a marca: ");
                    String marca = in.nextLine().toLowerCase();
                    if(!hashMap.containsKey(marca)) {
                        hashMap.put(marca, new ArrayList<>());
                    }
                    do {
                        Carro carro = new Carro();
                        System.out.print("Informe o modelo: ");
                        carro.setModelo(in.nextLine().toLowerCase());
                        System.out.print("Informe o valor: ");
                        carro.setValorVenda(in.nextDouble());
                        in.nextLine();
                        hashMap.get(marca).add(carro);

                        System.out.println("Deseja cadastrar mais um carro na marca " + marca + "? (S/N)");
                    } while (in.nextLine().equalsIgnoreCase("S"));
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
                            ArrayList<Carro> buscaLista = hashMap.get(buscaMarca);

                            for (int i=0; i<buscaLista.size(); i++){
                                if(buscaLista.get(i).getModelo().equalsIgnoreCase(buscaModelo)){
                                    System.out.printf("%s - valor de venda: R$%.2f\n", buscaModelo.toUpperCase(), buscaLista.get(i).getValorVenda());
                                    System.out.println("Deseja efetuar a venda? (S/N)");
                                    if(in.nextLine().equalsIgnoreCase("S")) {
                                        System.out.println("Veículo " + buscaModelo + " da " + buscaMarca + " -> Vendido!");
                                        buscaLista.remove(i);
                                        if(buscaLista.isEmpty()){
                                            hashMap.remove(buscaMarca);
                                        }
                                    }
                                    break;
                                }
                            }
                        }else {
                            System.err.println("Não há veículos cadastrados para a marca " + buscaMarca.toUpperCase() + "!");
                        }
                    }
                    break;
                default:
                    System.err.println("Informe uma opção válida!");
            }
        }
    }

    public static void ex4(){
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime.getYear());
//        System.out.println(dateTime.getMonth() +  " - " + dateTime.getMonthValue());
//        System.out.println(dateTime.getDayOfMonth());
//        System.out.println(dateTime.getDayOfWeek());
//        System.out.println(dateTime.getHour());
//        System.out.println(dateTime.getMinute());
//        System.out.println(dateTime.getSecond());
//        System.out.println(dateTime.getNano());
//        System.out.println(dateTime.getDayOfYear());
//        System.out.println(dateTime.toLocalDate().isLeapYear());
//        System.out.println(dateTime);

//        LocalDateTime inicio = LocalDateTime.of(2022,7,7,18,15,0);
//        LocalDateTime fim = LocalDateTime.of(2022,7,7,22,0,0);
//        System.out.println(inicio);
//        System.out.println(fim);
//        LocalDateTime tempDateTime = LocalDateTime.from(inicio);
//        int hours = (int) tempDateTime.until(fim, ChronoUnit.HOURS);
//        tempDateTime = tempDateTime.plusHours(hours);
//        int minutes = (int) tempDateTime.until(fim, ChronoUnit.MINUTES);
//        tempDateTime = tempDateTime.plusMinutes(minutes);
//        int seconds = (int)  tempDateTime.until(fim, ChronoUnit.SECONDS);
//
//        System.out.println(LocalTime.of(hours, minutes, seconds).minusMinutes(20));

//        System.out.println(LocalDateTime.now().format(
//                DateTimeFormatter.ISO_DATE
//        ));
//        System.out.println(LocalDateTime.now().format(
//                DateTimeFormatter.ISO_TIME
//        ));
//        System.out.println(LocalDateTime.now().format(
//                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
//        ));
//        System.out.println(LocalDateTime.now().format(
//                DateTimeFormatter.ofPattern("dd/MM/yy HH 'horas', mm 'minutos e' ss 'segundos'") //Colocar aspas simples entre palavras
//        ));

        LocalDateTime inicio = LocalDateTime.of(2022,7,7,18,15,0);
        LocalDateTime fim = LocalDateTime.of(2022,7,7,22,0,0);

        Duration bet = Duration.between(inicio, fim).minusHours(1).minusMinutes(30);

        System.out.println(bet);
        System.out.printf("%d:%d:%d\n", bet.toHoursPart(), bet.toMinutesPart(), bet.toSecondsPart());
    }

    public static void ex5(){
        while(true) {
            try{
                System.out.print("Informe um número: ");
                System.out.println(in.nextInt());
            } catch (InputMismatchException e){
                System.out.println("Não é um número!");
                in.nextLine();
            } //catch (NoSuchElementException e2){
//
//            } finally {
//
//            }
            break;
        }

        while(true) {
            try{
                System.out.print("Informe um número: ");
                System.out.println(in.nextInt());
            } catch (InputMismatchException e){
                in.nextLine();
                throw new RuntimeException("Não é um número!");
            }
        }
    }
}
