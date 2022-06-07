package classes;

public class ListaTarefas {

    //ATRIBUTOS
    private int tamanhoLista;
    private String nomeLista;
    private Tarefa[] tarefas;

    //CONSTRUTOR
    public ListaTarefas(int tamanhoLista){
        this.setTarefas(new Tarefa[tamanhoLista]);
        this.setTamanhoLista(tamanhoLista);
    }

    //MÉTODOS
    public boolean adicionarTarefa(Tarefa tarefa){
        if(tarefa.getOrdem() < this.getTamanhoLista() && tarefa.getOrdem() > 0) {
            for (int i = 0; i < this.getTamanhoLista(); i++) {
                if (this.getTarefas()[i] == null) {
                    this.getTarefas()[i] = tarefa;
                    return true;
                } else if (tarefa.getOrdem() == this.getTarefas()[i].getOrdem()){
                    break;
                }
            }
        }
        return false;
    }

    public Tarefa buscarTarefa(int ordem){
        for(Tarefa tarefa : this.getTarefas()){
            if(tarefa != null && tarefa.getOrdem() == ordem){
                return tarefa;
            }
        }
        return null;
    }

    public boolean alterarOrdemTarefa(int antigaOrdem, int novaOrdem){
        Tarefa tarefaAntiga = buscarTarefa(antigaOrdem);
        Tarefa novaTarefa = buscarTarefa(novaOrdem);
        if(tarefaAntiga == null || novaTarefa == null){
            return false;
        }
        tarefaAntiga.setOrdem(novaOrdem);
        novaTarefa.setOrdem(antigaOrdem);
        return true;
    }

    /*Dps
    public boolean alterarOrdemOutroJeito(int antigaOrdem, int novaOrdem){
        Tarefa tarefaAntiga = buscarTarefa(antigaOrdem);
        Tarefa novaTarefa = buscarTarefa(novaOrdem);

        if(tarefaAntiga == null || novaTarefa == null){
            return false;
        }

        String uuid = "";

        for(int i=0; i<this.getTamanhoLista(); i++)
        {
            Tarefa tarefa = buscarTarefa(i);
            if(uuid.equals(tarefa.getUuid())){
                continue;
            }
            tarefa.setOrdem();
            nome = tarefa.getNome();
        }

        return true;
    }*/

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