package classes;

public class ListaTarefas {

    //ATRIBUTOS
    private int tamanhoLista;
    private String nomeLista;
    private Tarefa[] tarefas;

    //CONSTRUTOR
    public ListaTarefas(int tamanhoLista){
        this.tamanhoLista = tamanhoLista;
    }

    //MÉTODOS
    public boolean adicionarTarefa(Tarefa tarefa){
          //todo
        return false;
    }

    public Tarefa buscarTarefa(int posicao){
        //todo
        return null;
    }

    public boolean alterarOrdemTarefa(Tarefa tarefa, int novaPosicao){
        //todo
        return false;
    }

    //GETTER & SETTER

    public int getTamanhoLista() {
        return this.tamanhoLista;
    }

    public void setTamanhoLista(int tamanhoLista) {
        this.tamanhoLista = tamanhoLista;
    }

    public String getNomeLista() {
        return this.nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public Tarefa[] getTarefas() {
        return this.tarefas;
    }

    public void setTarefas(Tarefa[] tarefas) {
        this.tarefas = tarefas;
    }
}
