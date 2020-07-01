package locadora.Model.VO;


public class Livro extends Produto {
    //Variáveis
    private String autor;
    private int qtdPaginas;

    //Métodos
    public void incluirLivro() {
        //toDo
    }

    public void alterarLivro() {
        //toDo
    }

    public void removerLivro() {
        //toDo
    }

    public void pesquisarLivro() {
        //toDo
    }

    public void imprimirListaLivros() {
        //Pesquisa por Título, Nome do autor, estilo...
        //toDo
    }

    //Métodos Especiais - Getters e Setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if(autor != null)
            if(autor.equals("")){
                System.out.println("Livro sem autor!");
                this.autor = "Livro sem autor";
            }else
        this.autor = autor;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        if(qtdPaginas>0)
            this.qtdPaginas = qtdPaginas;
        else System.out.println("Valor não aceitável.");
    }

    //Métodos Especiais - Construtor
    public Livro() {}
    public Livro(int codigoDoLivro, String titulo, String autor, String genero, int anoDeLancamento, int qtdPaginas, int qtdExemplares, double valorDoAluguel) {
        this.autor = autor;
        this.qtdPaginas = qtdPaginas;
    }
}
