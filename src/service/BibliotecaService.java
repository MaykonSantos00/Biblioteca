package service;

import model.Emprestimo;
import model.Livro;
import model.Usuario;
import util.TratadorDeErros;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        this.livros.add(livro);
        System.out.println("Livro cadastrado");
    }

    public void cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        System.out.println("Usuario cadastrado");
    }

    public void realizarEmprestimo(String cpf, String id) {
        Livro livro = buscarLivro(id);
        Usuario usuario = buscarUsuario(cpf);
        Validador.validarLivroDisponivel(livro);
        Emprestimo emprestimo = new Emprestimo(livro, usuario);
        usuario.adicionarEmprestimo(emprestimo);
        livro.setDisponivel(false);
        System.out.println("Emprestimo realizado");
    }

    public void devolverEmprestimo(String cpf, String id) {
        try {
            Livro livro = buscarLivro(id);
            Usuario usuario = buscarUsuario(cpf);
            for (Emprestimo emprestimo : usuario.getEmprestimos()) {
                if (emprestimo.getLivro().getId().equals(id) && (!emprestimo.isEmprestado())) {
                    usuario.removerEmprestimo(emprestimo);
                    livro.setDisponivel(true);
                    emprestimo.alterarStatusEmprestimo(true);
                    System.out.println("Emprestimo devolvido com sucesso");
                    return;
                }
            }
            throw new Exception();
        } catch (Exception e) {
            TratadorDeErros.main(e.getMessage());
        }
    }

    private Livro buscarLivro(String id) {
        for (Livro livro : this.livros) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }

        return null;
    }

    private Usuario buscarUsuario(String cpf) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }
}
