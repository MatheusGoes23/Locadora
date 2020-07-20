package locadora;

import locadora.Model.BO.ClienteBO;
import locadora.Model.BO.ClienteInterBO;
import locadora.Model.BO.ConectarBDinterBO;
import locadora.Model.BO.DiscoBO;
import locadora.Model.BO.DiscoInterBO;
import locadora.Model.BO.LivroBO;
import locadora.Model.BO.LivroInterBO;
import locadora.Model.BO.ProdutoBO;
import locadora.Model.VO.ClienteVO;
import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.Model.DAO.ClienteDAO;
import locadora.Model.VO.ProdutoVO;
import locadora.exception.InsertException;

public class BOTeste {

	public static void main(String[] args) {

		// ----------- TESTE CLIENTE ------------

		ClienteInterBO<ClienteVO> clibo = new ClienteBO();
		ClienteVO cli = new ClienteVO();
		cli.setIdCliente(31L);
		cli.setNome("Matheus Gssss");
		cli.setCpf("987.654.351-00");
		cli.setTelefone("(85) 9.9959-9999");
		cli.setEndereco("Rua Ceara, 404 - Casa 08 - Ceara");
		// try {
		// clibo.inserir(cli);
		// clibo.alterar(cli);
		// clibo.remover(cli);
		// clibo.removerByCPF(cli);

		// } catch (InsertException e) {
		// e.printStackTrace();
		// }

		// ---------- TESTE DISCO ------------

		DiscoInterBO<DiscoVO> discbo = new DiscoBO();
		DiscoVO disc = new DiscoVO();

		disc.setIdProduto(13L);
		disc.setTitulo("Rubber Soul");
		disc.setNomeDaBanda("The Beatles");
		disc.setGenero("Rock");
		disc.setAnoDeLancamento(1965);
		disc.setQtdExemplares(5);
		disc.setValorDoAlulguel(12.0);
		// try {
		// discbo.inserir(disc);
		// discbo.alterarValor(disc);
		// discbo.alterarQuantidade(disc);
		// discbo.remover(disc);

		// } catch (InsertException e) {
		// e.printStackTrace();
		// }

		// ---------- TESTE DISCO ------------

		LivroInterBO<LivroVO> livbo = new LivroBO();
		LivroVO liv = new LivroVO();

		liv.setIdProduto(9L);
		liv.setTitulo("Harry Potter");
		liv.setAutor("J.K Rowling");
		liv.setGenero("Ficcao");
		liv.setAnoDeLancamento(2019);
		liv.setQtdExemplares(2);
		liv.setQtdPaginas(400);
		liv.setValorDoAlulguel(99);
		// try {
				// livbo.inserir(liv);
				// livbo.alterarValor(liv);
				// livbo.alterarQuantidade(liv);
				// livbo.remover(liv);

				// } catch (InsertException e) {
				// e.printStackTrace();
				// }

		

	}
}
