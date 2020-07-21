package locadora;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Locale;
import java.util.Scanner;

import locadora.Model.BO.ClienteBO;
import locadora.Model.BO.ClienteInterBO;
import locadora.Model.BO.DiscoBO;
import locadora.Model.BO.DiscoInterBO;
import locadora.Model.BO.LivroBO;
import locadora.Model.BO.LivroInterBO;
import locadora.Model.VO.ClienteVO;
import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.Model.VO.LocacaoVO;
import locadora.Model.VO.UsuarioVO;
import locadora.exception.InsertException;

public class Principal {
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		Locale localeBR = new Locale("pt", "BR");
		NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR);
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");

		UsuarioVO usuario = new UsuarioVO(1L, "Webminst", "Giggio51", 3); // ("Cadastro de Usuário - hardcoded")
		ClienteInterBO<ClienteVO> clivo = new ClienteBO();
		ClienteVO cliente = new ClienteVO();
		// Invocação explicita em outra classe

		LivroInterBO<LivroVO> livvo = new LivroBO();
		LivroVO livro = new LivroVO();
		DiscoInterBO<DiscoVO> discvo = new DiscoBO();
		DiscoVO disco = new DiscoVO();

		LocacaoVO locacao = new LocacaoVO();

		System.out.println(usuario);

		// Entrada de dados para cadastrar um cliente
		System.out.println("====================");
		System.out.println("Cadastro de Clientes");
		System.out.print("CPF: ");
		cliente.setCpf(leitura.nextLine());
		System.out.print("Nome: ");
		cliente.setNome(leitura.nextLine());
		System.out.print("Telefone: ");
		cliente.setTelefone(leitura.nextLine());
		System.out.print("Endereço: ");
		cliente.setEndereco(leitura.nextLine());
		System.out.println("====================");

		
		try {
			clivo.inserir(cliente);
		} catch (InsertException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(cliente.toString());
		// Entrada de dados para cadastrar um livro
		System.out.println("==================");
		System.out.println("Cadastro de Livros");
		livro.setIdProduto(livro.getIdProduto() + 1);
		System.out.print("Nome do livro: ");
		livro.setTitulo(leitura.nextLine());
		System.out.print("Autor: ");
		livro.setAutor(leitura.nextLine());
		System.out.print("Gênero: ");
		livro.setGenero(leitura.nextLine());
		System.out.print("Ano de lançamento: ");
		livro.setAnoDeLancamento(leitura.nextInt());
		System.out.print("Quantidade: ");
		livro.setQtdExemplares(leitura.nextInt());
		System.out.print("Páginas: ");
		livro.setQtdPaginas(leitura.nextInt());
		System.out.print("Valor: ");
		livro.setValorDoAlulguel(leitura.nextDouble());
		System.out.println("==================");

		
		try {
			livvo.inserir(livro);
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(livro.toString());

		// Entrada de dados para cadastrar um disco
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("==================");
		System.out.println("Cadastro de Discos");
		// disco.setIdProduto(disco.getIdProduto() + 1);
		System.out.print("Nome do disco: ");
		disco.setTitulo(leitura.nextLine());
		System.out.print("Banda: ");
		disco.setNomeDaBanda(leitura.nextLine());
		System.out.print("Gênero: ");
		disco.setGenero(leitura.nextLine());
		System.out.print("Ano de lançamento: ");
		disco.setAnoDeLancamento(leitura.nextInt());
		System.out.print("Quantidade: ");
		disco.setQtdExemplares(leitura.nextInt());
		System.out.print("Valor: ");
		disco.setValorDoAlulguel(leitura.nextDouble());
		System.out.println("==================");

		System.out.println(disco.toString());
		try {
			discvo.inserir(disco);
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Entrada de dados para cadastrar uma locação
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("===================");
		System.out.println("Cadastro de Locação");
		locacao.setIdLocacao(locacao.getIdLocacao() + 1);
		System.out.print("Data: ");
		System.out.println(sdf.format(locacao.getDataDaLocacao().getTime()));
		// Limpando o buffer do teclado
		System.out.print("CPF: ");
		locacao.setCliente(cliente);
		// A ideia é mostrar também o nome do cliente quando for digitado o cpf
		// System.out.print(cliente.getNome());
		System.out.print("Código do Produto: ");
		locacao.setProduto(disco);
		// A ideia é mostrar também o título do livro quando for digitado o código
		// System.out.print(produto.getTitulo());
		System.out.print("Devolução: ");
		locacao.setDataDaDevolucao();
		System.out.println(sdf.format(locacao.getDataDaDevolucao().getTime()));
		System.out.print("Valor: ");
		locacao.setValorLocacao(leitura.nextDouble());
		System.out.print("Multa: ");
		locacao.setMulta(leitura.nextDouble());
		System.out.print("Desconto: ");
		locacao.setDesconto(leitura.nextDouble());
		System.out.print("Valor Pago: ");
		locacao.setValorPago(locacao.getValorLocacao() + locacao.getMulta() - locacao.getDesconto());
		System.out.println((dinheiroBR.format(locacao.getValorPago())));
		System.out.print("Pago: ");
		locacao.setPago(leitura.nextBoolean());
		System.out.println("===================");

		System.out.println(locacao);

	}
}
