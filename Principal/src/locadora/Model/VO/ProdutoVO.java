package locadora.Model.VO;

import java.text.NumberFormat;

import java.util.Locale;


public abstract class ProdutoVO {
    Locale localeBR = new Locale( "pt", "BR" );  
    NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR); 
    
    //Vari�veis
    private Long idProduto;
    private String titulo;
    private String genero;
    private int anoDeLancamento;
    private int qtdExemplares;
    private double valorDoAluguel;
    
    //M�todos Especiais - Getters e Setters
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null)
            titulo = "";
            if (titulo.equals("")) {
                System.out.println("Produto sem t�tulo!");
                this.titulo = "Produto sem t�tulo";
            } else
                this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null)
            genero = "";
            if (genero.equals("")) {
                System.out.println("Produto sem g�nero!");
                this.titulo = "Produto sem genero";
            } else
                this.genero = genero;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        if (anoDeLancamento > 1900 && anoDeLancamento < 2050) //aqui d� pra colocar um Calendar.YEAR
            this.anoDeLancamento = anoDeLancamento;
        else
            System.out.println("Valor n�o aceit�vel.");
    }

    public int getQtdExemplares() {
        return qtdExemplares;
    }

    public void setQtdExemplares(int qtdExemplares) {
        if (qtdExemplares > 0)
            this.qtdExemplares = qtdExemplares;
        else
            System.out.println("Valor n�o aceit�vel.");
    }

    public double getValorDoAluguel() {
        return valorDoAluguel;
    }

    public void setValorDoAlulguel(double valorDoAluguel) {
        if (valorDoAluguel > 0)
            this.valorDoAluguel = valorDoAluguel;
        else
            System.out.println("Valor n�o aceit�vel.");
    }
    
    
    //M�todos Especiais - Construtor
    public ProdutoVO() {//Construtor default
    }

    //M�todos Especiais - toString
    public String toString() {
        String saida;
        saida = "\nC�digo do Produto: " + idProduto + "\nT�tulo: " + titulo + "\nG�nero: " + genero + "\nAno de lan�amento: " + anoDeLancamento + "\nQuantidade de exemplares: " + qtdExemplares + "\nValor do aluguel: " + (dinheiroBR.format(valorDoAluguel));
        return saida;
    }
}
