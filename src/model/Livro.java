package model;

public class Livro {
    private String titulo;
    private String autor;
    private String id;
    private boolean disponivel = true;
    private Categoria categoria;

    public Livro(String titulo, String autor, String id, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getId() {
        return id;
    }
}
