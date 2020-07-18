package locadora;

import locadora.Model.BO.DiscoBO;
import locadora.Model.BO.ProdutoBO;
import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.Model.VO.ProdutoVO;

public class BOTeste {

	public static void main(String[] args) {
		ProdutoBO bo = new DiscoBO();
		ProdutoVO produtos[] = bo.listarProdutos();

		for (int i = 0; i < 3; i++) {
			System.out.println(produtos[i].getTitulo());
		}
		LivroVO livro = new LivroVO();
		System.out.println(livro.getTitulo());
		bo.alterar(livro);
		System.out.println(livro.getTitulo());

		DiscoVO disco = new DiscoVO();
		System.out.println(disco.getTitulo());
		bo.alterar(disco);
		System.out.println(disco.getTitulo());
	}
}
