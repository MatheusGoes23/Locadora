package locadora.Model.DAO;

import locadora.Model.BO.ProdutoBO;
import locadora.Model.VO.ProdutoVO;

public abstract class ProdutoDAO<VO extends ProdutoVO> extends ConectarBD<VO> {

	// Métodos
	public void incluir(ProdutoVO produto) {
		// toDo
	}

	public void alterarProduto(ProdutoVO produto) {
		// toDo
	}

	public void removerProduto(ProdutoVO produto) {
		// toDo
	}

	public void pesquisarProduto(ProdutoVO produto) {
		// Pesquisar cliente por Nome ou CPF
		// toDo
	}

	public void imprimirFichaProduto(ProdutoVO produto) {
		// Imprime um lista de Clientes com CPF, Nome, Telefone...
		// toDo
	}
}
