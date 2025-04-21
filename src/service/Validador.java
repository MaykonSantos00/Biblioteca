package service;

import model.Livro;

public class Validador {

    public static void validarLivroDisponivel(Livro livro) {
        if (!livro.isDisponivel()) {
            throw new RuntimeException("Livro indisponível");
        }

    }

}
