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
        
        Cliente cliente = new Cliente("Giovanni Guimarães", "Rua das Acácias, 15", "(84) 9.9660-9271", "057.089.248-10");
        System.out.println(cliente);
        System.out.println("Cliente: " + cliente.getNome() + "\tTelefone: " + cliente.getTelefone());

        
        System.out.println("Cadastro de Locação");
        System.out.println("===================");
        //Coletar dados da Locação - colocar idLocacao variável estática para contar automaticamente a cada inclusão de nova locacao
        Locacao locacao = new Locacao();
        //penso que tudo isso por ir para a classe Locação na função incluirLocacao() 
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
        System.out.print("Data: ");
        locacao.setDataDaLocacao(dataHoje);
        System.out.println(sdf.format(locacao.getDataDaLocacao().getTime()));
        System.out.print("CPF: ");
        locacao.setCpfCliente(leitura.nextLine());
        System.out.print("Código do Produto: ");
        locacao.setCodigoProduto(leitura.nextInt());
        //System.out.print(produto.getTitulo()); a ideia é mostrar também o título do livro quando for digitadoo código
        System.out.print("Devolução: ");
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
        //Coletar dados do livro - colocar idProduto variável estática para contar automaticamente a cada inclusão de novo produto
        livro.setIdProduto(1);
        //penso que tudo isso por ir para a classe Livros na função incluirLivros()
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
        leitura.nextLine(); //para limpar o buffer de teclado
        System.out.println(livro);
        
        
        System.out.println("Cadastro de Discos");
        System.out.println("==================");
        Disco disco = new Disco();
        //Coletar dados do disco - colocar idProduto variável estática para contar automaticamente a cada inclusão de novo produto
        disco.setIdProduto(2);
        //penso que tudo isso por ir para a classe Disco na função incluirDisco()
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
        leitura.nextLine(); // para limpar o buffer de teclado
        System.out.println(disco);
        leitura.close();
    }
}
