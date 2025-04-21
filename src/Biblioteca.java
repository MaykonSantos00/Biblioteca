import model.Categoria;
import model.Livro;
import model.Usuario;
import service.BibliotecaService;

public class Biblioteca {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();

        Livro livro = new Livro("A culpa é das estrelas", "George Orell","123456", Categoria.ROMANCE);
        Usuario usuario = new Usuario("Maykon", "04753245284");

        biblioteca.cadastrarLivro(livro);
        biblioteca.cadastrarUsuario(usuario);

        biblioteca.realizarEmprestimo("04753245284","123456");
        biblioteca.devolverEmprestimo("04753245284","123456");
    }
}