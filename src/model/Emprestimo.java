package model;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean emprestado = false;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusDays(7);
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void alterarStatusEmprestimo(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public Livro getLivro() {
        return livro;
    }
}
