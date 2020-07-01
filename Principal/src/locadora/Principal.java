package locadora;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import locadora.Model.BO.Locacao;
import locadora.Model.VO.Cliente;
import locadora.Model.VO.Disco;
import locadora.Model.VO.Livro;
import locadora.Model.VO.Usuario;

public class Principal {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Locale localeBR = new Locale( "pt", "BR" );  
        NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR);
        Calendar dataHoje = Calendar.getInstance();
        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.add(Calendar.DAY_OF_MONTH, 7);
        
        Cliente cliente = new Cliente("Giovanni Guimar�es", "Rua das Ac�cias, 15", "(84) 9.9660-9271", "057.089.248-10");
        System.out.println(cliente);
        System.out.println("Cliente: " + cliente.getNome() + "\tTelefone: " + cliente.getTelefone());

        
        System.out.println("Cadastro de Loca��o");
        System.out.println("===================");
        //Coletar dados da Loca��o - colocar idLocacao vari�vel est�tica para contar automaticamente a cada inclus�o de nova locacao
        Locacao locacao = new Locacao();
        //penso que tudo isso por ir para a classe Loca��o na fun��o incluirLocacao() 
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
        System.out.print("Data: ");
        locacao.setDataDaLocacao(dataHoje);
        System.out.println(sdf.format(locacao.getDataDaLocacao().getTime()));
        System.out.print("CPF: ");
        locacao.setCpfCliente(leitura.nextLine());
        System.out.print("C�digo do Produto: ");
        locacao.setCodigoProduto(leitura.nextInt());
        //System.out.print(produto.getTitulo()); a ideia � mostrar tamb�m o t�tulo do livro quando for digitadoo c�digo
        System.out.print("Devolu��o: ");
        locacao.setDataDaDevolucao(dataDevolucao);
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
        System.out.println(locacao);
        
          
        Usuario usuario = new Usuario(1, "Webminst", "Giggio51", 3);
        usuario.setPerfil(5);
        System.out.println(usuario);
        
        
        
        System.out.println("Cadastro de Livros");
        System.out.println("==================");        
        Livro livro = new Livro();
        //Coletar dados do livro - colocar idProduto vari�vel est�tica para contar automaticamente a cada inclus�o de novo produto
        livro.setIdProduto(1);
        //penso que tudo isso por ir para a classe Livros na fun��o incluirLivros()
        System.out.print("Nome do livro: ");
        livro.setTitulo(leitura.nextLine());
        System.out.print("Autor: ");
        livro.setAutor(leitura.nextLine());
        System.out.print("G�nero: ");
        livro.setGenero(leitura.nextLine());
        System.out.print("Ano de lan�amento: ");
        livro.setAnoDeLancamento(leitura.nextInt());
        System.out.print("Quantidade: ");
        livro.setQtdExemplares(leitura.nextInt());
        System.out.print("P�ginas: ");
        livro.setQtdPaginas(leitura.nextInt());
        System.out.print("Valor: ");
        livro.setValorDoAlulguel(leitura.nextDouble());
        leitura.nextLine(); //para limpar o buffer de teclado
        System.out.println(livro);
        
        
        System.out.println("Cadastro de Discos");
        System.out.println("==================");
        Disco disco = new Disco();
        //Coletar dados do disco - colocar idProduto vari�vel est�tica para contar automaticamente a cada inclus�o de novo produto
        disco.setIdProduto(2);
        //penso que tudo isso por ir para a classe Disco na fun��o incluirDisco()
        System.out.print("Nome do disco: ");
        disco.setTitulo(leitura.nextLine());
        System.out.print("Banda: ");
        disco.setNomeDaBanda(leitura.nextLine());
        System.out.print("G�nero: ");
        disco.setGenero(leitura.nextLine());
        System.out.print("Ano de lan�amento: ");
        disco.setAnoDeLancamento(leitura.nextInt());
        System.out.print("Quantidade: ");
        disco.setQtdExemplares(leitura.nextInt());
        System.out.print("Valor: ");
        disco.setValorDoAlulguel(leitura.nextDouble());
        leitura.nextLine(); // para limpar o buffer de teclado
        System.out.println(disco);
        leitura.close();
    }
}
