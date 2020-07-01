package locadora.Model.VO;

import java.text.NumberFormat;

import java.util.Locale;

public abstract class Produto {
    Locale localeBR = new Locale( "pt", "BR" );  
    NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR); 
    
    //M�todos
    private int idProduto;
    private String titulo;
    private String genero;
    private int anoDeLancamento;
    private int qtdExemplares;
    private double valorDoAluguel;

    //M�todos
    public void incluirProduto() {
        //toDo
    }

    public void alterarProduto() {
        //toDo
    }

    public void removerProduto() {
        //toDo
    }

    public void pesquisarProduto() {
        //toDo
    }

    public void imprimirListaProdutos() {
        //Pesquisa por T�tulo, Nome do autor, estilo...
        //toDo
    }

    //M�todos Especiais - Getters e Setters
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo != null)
            if(titulo.equals("")){
                System.out.println("Produto sem t�tulo!");
                this.titulo = "Produto sem t�tulo";
            }else
        this.titulo = titulo; 
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if(genero != null)
            if(genero.equals("")){
                System.out.println("Produto sem g�nero!");
                this.titulo = "Produto sem genero";
            }else
    this.genero = genero;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        if(anoDeLancamento>1900 && anoDeLancamento < 2050)//aqui d� pra colocar um Calendar.YEAR
            this.anoDeLancamento = anoDeLancamento;
        else System.out.println("Valor n�o aceit�vel.");
    }

    public int getQtdExemplares() {
        return qtdExemplares;
    }

    public void setQtdExemplares(int qtdExemplares) {
        if(qtdExemplares>0)
            this.qtdExemplares = qtdExemplares;
        else System.out.println("Valor n�o aceit�vel.");
    }

    public double getValorDoAluguel() {
        return valorDoAluguel;
    }

    public void setValorDoAlulguel(double valorDoAluguel) {
        if (valorDoAluguel > 0)
            this.valorDoAluguel = valorDoAluguel;
        else System.out.println("Valor n�o aceit�vel.");
    }

    //M�todos Especiais - Construtor


    //Construtor default
        public Produto() {}
        public Produto(int idProduto, String titulo, String genero, int anoDeLancamento, int qtdExemplares, double valorDoAluguel) {
        this.idProduto = idProduto;
        this.titulo = titulo;
        this.genero = genero;
        this.anoDeLancamento = anoDeLancamento;
        this.qtdExemplares = qtdExemplares;
        this.valorDoAluguel = valorDoAluguel;
    }

    //M�todos Especiais - toString
    @Override
    public String toString() {
        return "Produto{" + "\nC�digo do Produto: " + idProduto + "\nT�tulo: " + titulo + "\nG�nero: " + genero + "\nAno de lan�amento: " + anoDeLancamento + "\nQuantidade de exemplares: " + qtdExemplares + "\nValor do aluguel: " + (dinheiroBR.format(valorDoAluguel)) + "\n" + '}';
    }
}
