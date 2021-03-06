package classes;

import java.util.UUID;

public class Tarefa {

    //ATRIBUTOS
    private String uuid;
    private String nome, descricao;
    private boolean completa;
    private int ordem;
    private ChecklistItem[] checklistItems;

    //CONSTRUTOR
    public Tarefa(){
        this.setUuid(UUID.randomUUID().toString());
    }

    //MÉTODOS
    public void completar(){
        setCompleta(true);
        for(ChecklistItem item : this.getChecklistItems()){
            if(item!=null){
                item.completar();
            }
        }
    }

    public boolean temChecklist(){
        return this.getChecklistItems() != null;
    }

    public void criarChecklist(int tamanho){
        this.setChecklistItems(new ChecklistItem[tamanho]);
    }

    public boolean adicionarChecklist(ChecklistItem item){
        for (int i = 0; i < this.getChecklistItems().length; i++) {
            if (this.getChecklistItems()[i] == null) {
                this.getChecklistItems()[i] = item;
                return true;
            }
        }
        return false;
    }

    //GETTER & SETTER
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public boolean isCompleta() {
        return this.completa;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int getOrdem() {
        return this.ordem;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public ChecklistItem[] getChecklistItems() {
        return this.checklistItems;
    }

    public void setChecklistItems(ChecklistItem[] checklistItems) {
        this.checklistItems = checklistItems;
    }
}
