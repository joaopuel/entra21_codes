import classes.Tarefa;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tarefa tarefa = new Tarefa();

        System.out.print("Informe a tarefa: ");
        tarefa.setNome(sc.nextLine());
        System.out.print("Descrição: ");
        tarefa.setDescricao(sc.nextLine());

        System.out.println(tarefa.getUuid());
        System.out.println(tarefa.getNome() +  ": " + tarefa.getDescricao());
    }
}
