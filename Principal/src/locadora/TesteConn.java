package locadora;

import java.sql.ResultSet;
import java.util.Calendar;

import locadora.Model.DAO.ClienteDAO;
import locadora.Model.DAO.DiscoDAO;
import locadora.Model.DAO.LivroDAO;
import locadora.Model.DAO.LocacaoDAO;
import locadora.Model.DAO.UsuarioDAO;
import locadora.Model.VO.ClienteVO;
import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.Model.VO.LocacaoVO;
import locadora.Model.VO.UsuarioVO;

public class TesteConn {
	public static void main(String[] args) {

		// ----------- TESTE CLIENTE ------------
		ClienteDAO<ClienteVO> clidao = new ClienteDAO<ClienteVO>();
		ClienteVO cli = new ClienteVO();

		cli.setIdCliente(2L);
		cli.setNome("Matress Goes");
		cli.setCpf("987.654.321-00");
		cli.setTelefone("(85) 9.9999-9999");
		cli.setEndereco("Rua Ceara, 404 - Casa 08 - Ceara");

		// clidao.inserir(cli);
		// clidao.alterar(cli);
		// clidao.remover(cli);
		// clidao.removerByCPF(cli);

		// Buscar pelo CPF ou ID:
	//	ResultSet resultcli;
	//	try {

		//	resultcli = clidao.buscar(cli);
		//	resultcli = clidao.buscarByCPF(cli);
		//	System.out.println(resultcli.next());
		//} catch (Exception e) {

		//}

		// ----------- TESTE USUÁRIO ------------
		UsuarioDAO<UsuarioVO> usudao = new UsuarioDAO<UsuarioVO>();
		UsuarioVO usu = new UsuarioVO();

		usu.setIdUsuario(4L);
		usu.setLogin("Giovanni");
		usu.setSenha("123789");
		usu.setPerfil(2);

		// usudao.inserir(usu);
		// usudao.alterar(usu);
		// usudao.remover(usu);

		// ---------- TESTE DISCO ------------
		DiscoDAO<DiscoVO> discdao = new DiscoDAO<DiscoVO>();
		DiscoVO disc = new DiscoVO();

		disc.setIdProduto(13L);
		disc.setTitulo("Abbey Road");
		disc.setNomeDaBanda("The Beatles");
		disc.setGenero("Rock");
		disc.setAnoDeLancamento(1969);
		disc.setQtdExemplares(2);
		disc.setValorDoAlulguel(8.0);

		// discdao.inserir(disc);
		// discdao.alterarValor(disc);
		// discdao.alterarQuantidade(disc);
		// discdao.remover(disc);

		// Busca pelo id do disco:
		// ResultSet resultdisc;
		// try {
		// resultdisc = discdao.buscar(disc);
		// System.out.println(resultdisc.next());
		// } catch (Exception e) {

		// }

		// ---------- TESTE LIVRO ------------
		LivroDAO<LivroVO> livdao = new LivroDAO<LivroVO>();
		LivroVO liv = new LivroVO();

		liv.setIdProduto(4L);
		liv.setTitulo("Harry Potter");
		liv.setAutor("J.K Rowling");
		liv.setGenero("Ficcao");
		liv.setAnoDeLancamento(2019);
		liv.setQtdExemplares(2);
		liv.setQtdPaginas(400);
		liv.setValorDoAlulguel(15);

		// livdao.inserir(liv);
		// livdao.alterarValor(liv);
		// livdao.alterarQuantidade(liv);
		// livdao.remover(liv);

		// Busca pelo id do livro:
		// ResultSet resultliv;
		// try {
		// resultliv = livdao.buscar(liv);
		// System.out.println(resultliv.next());
		// } catch (Exception e) {

		// }

		// ---------- TESTE LOCAÇÃO ------------
		LocacaoDAO<LocacaoVO> locdao = new LocacaoDAO<LocacaoVO>();
		LocacaoVO loc = new LocacaoVO();

		loc.setIdLocacao(19L);
		loc.setDataDaLocacao(Calendar.getInstance());
		loc.setDataDaDevolucao();
		loc.setCliente(cli);
		loc.setProduto(disc);
		loc.setValorLocacao(20);
		loc.setMulta(5);
		loc.setDesconto(2.5);
		loc.setValorPago(7.5);
		loc.setPago(false);

		// locdao.inserir(loc);
		// locdao.remover(loc);

		// Busca pelo id da locação:
		// ResultSet resultloc;
		// try {
		// resultloc = locdao.buscar(loc);
		// System.out.println(resultloc.next());
		// } catch (Exception e) {

		// }

	}
}