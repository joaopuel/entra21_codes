package classes;

import java.util.UUID;

public class ChecklistItem {

    //ATRIBUTOS
    private String uuid, nome, descricao;
    private boolean completa;
    private int ordem;

    //MÉTODOS
    public void completar(){
        setCompleta(true);
    }

    //CONSTRUTOR
    public ChecklistItem(){
        this.setUuid(UUID.randomUUID().toString());
    }

    //GETTERS & SETTERS
    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompleta() {
        return this.completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public int getOrdem() {
        return this.ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
}
