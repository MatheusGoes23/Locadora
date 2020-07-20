package locadora;

import java.util.Calendar;

import locadora.Model.BO.ClienteBO;
import locadora.Model.BO.ClienteInterBO;
import locadora.Model.BO.DiscoBO;
import locadora.Model.BO.DiscoInterBO;
import locadora.Model.BO.LivroBO;
import locadora.Model.BO.LivroInterBO;
import locadora.Model.BO.LocacaoBO;
import locadora.Model.BO.LocacaoInterBO;
import locadora.Model.BO.UsuarioBO;
import locadora.Model.BO.UsuarioInterBO;
import locadora.Model.VO.ClienteVO;
import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.Model.VO.LocacaoVO;
import locadora.Model.VO.UsuarioVO;

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

		// ----------- TESTE USUÁRIO ------------
		UsuarioInterBO<UsuarioVO> usubo = new UsuarioBO();
		UsuarioVO usu = new UsuarioVO();

		usu.setIdUsuario(4L);
		usu.setLogin("Giovanni");
		usu.setSenha("123456");
		usu.setPerfil(2);
		// try {
		// usubo.inserir(usu);
		// usubo.alterar(usu);
		// usubo.remover(usu);

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

		// ---------- TESTE LOCAÇÃO ------------

		LocacaoInterBO<LocacaoVO> locbo = new LocacaoBO();
		LocacaoVO loc = new LocacaoVO();

		loc.setIdLocacao(20L);
		loc.setDataDaLocacao(Calendar.getInstance());
		loc.setDataDaDevolucao();
		loc.setCliente(cli);
		loc.setProduto(disc);
		loc.setValorLocacao(20);
		loc.setMulta(5);
		loc.setDesconto(2.5);
		loc.setValorPago(7.5);
		loc.setPago(false);

		// try {
		// locbo.inserir(loc);
		// locbo.remover(loc);

		// } catch (InsertException e) {
		// e.printStackTrace();
		// }
	}
}
