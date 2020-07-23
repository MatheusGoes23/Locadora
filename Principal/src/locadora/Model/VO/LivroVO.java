package locadora.Model.VO;

public class LivroVO extends ProdutoVO {

	// Vari�veis
	private String autor;
	private int qtdPaginas = 0;

	// M�todos especiais Getters e Setters
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor == null)
			autor = "";
		if (autor.equals("")) {
			System.out.println("Livro sem autor!");
			this.autor = "Livro sem autor";
		} else
			this.autor = autor;
	}

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		if (qtdPaginas >= 0)
			this.qtdPaginas = qtdPaginas;
		else
			System.out.println("Valor n�o aceit�vel.");
	}

	// M�todos Especiais - Construtor
	public LivroVO() {// Construtor default
	}

	// M�todos Especiais - toString
	@Override // Polimorfismo de Sobrescrita
	public String toString() {
		String saida;
		saida = super.toString();
		saida = saida + "\nAutor: " + autor + "\nP�ginas: " + qtdPaginas + "\n";
		return saida;
	}
	
	
}
