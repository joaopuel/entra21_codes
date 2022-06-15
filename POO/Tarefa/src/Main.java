import classes.*;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Informe a quantidade de tarefas da lista: ");
        ListaTarefas lt = new ListaTarefas(sc.nextInt());
        sc.nextLine();
        System.out.println("Informe um nome para a lista de tarefas: ");
        lt.setNomeLista(sc.nextLine());
        while(true) {
            Tarefa t = criarTarefa();
            if(!lt.adicionarTarefa(t)){
                System.out.println("Impossível adicionar tarefa!");
                break;
            }
            System.out.println("Informe um nome para o item: ");
            System.out.println("Deseja adcionar mais tarefas? (S/N)");
            String add = sc.nextLine();
            if (add.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static Tarefa criarTarefa(){
        Tarefa t = new Tarefa();
        System.out.println("Informe o nome da tarefa: ");
        t.setNome(sc.nextLine());
        System.out.println("Informe a descrição da tarefa: ");
        t.setDescricao(sc.nextLine());
        System.out.println("Ordem da tarefa: ");
        t.setOrdem(sc.nextInt());
        sc.nextLine();
        System.out.println("Tareda tem checklist? (S/N)");
        String checklist = sc.nextLine();
        if(checklist.equalsIgnoreCase("S")) {
            System.out.println("Informe o tamanho da checklist");
            t.criarChecklist(sc.nextInt());
            sc.nextLine();
            while(true){
                ChecklistItem item = new ChecklistItem();
                System.out.println("Informe um nome para o item: ");
                item.setNome(sc.nextLine());
                System.out.println("Informe uma descrição para o item: ");
                item.setDescricao(sc.nextLine());
                t.adicionarChecklist(item);
                System.out.println("Deseja adcionar mais itens? (S/N)");
                String add = sc.nextLine();
                if(add.equalsIgnoreCase("N")){
                    break;
                }
            }
        }
        return t;
    }
}
