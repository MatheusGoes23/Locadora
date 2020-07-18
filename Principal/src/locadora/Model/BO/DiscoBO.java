package locadora.Model.BO;

import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.ProdutoVO;

public class DiscoBO extends ProdutoBO {

	// Métodos
	public void incluir(ProdutoVO produto) {
		// toDo
	}

	public void alterar(ProdutoVO produto) {
		// toDo
	}

	public void remover(ProdutoVO produto) {
		// toDo
	}

	public ProdutoVO imprimirFicha(ProdutoVO produto) {
		// Ficha do Livro
		// toDo
		DiscoVO disco = new DiscoVO();

		return disco;
	}

	public ProdutoVO[] pesquisarTitulo(String titulo) {
		// toDo
		DiscoVO discos[] = new DiscoVO[5];

		return discos;
	}

	public ProdutoVO[] pesquisarAno(int ano) {
		// toDo
		DiscoVO discos[] = new DiscoVO[5];

		return discos;
	}

	public ProdutoVO[] pesquisarGenero(String genero) {
		// toDo
		DiscoVO discos[] = new DiscoVO[5];

		return discos;
	}

	public void imprimirLista() {
		// Imprime listagem de discos com Código, Título, QtdExemplares...
		// public List<DiscoVO> imprimirLista(){
		// toDo
	}
}