package locadora.Model.BO;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Locale;

public class Locacao {
    Locale localeBR = new Locale( "pt", "BR" );  
    NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR); 

    // Vari�veis
    private Calendar dataDaLocacao;
    private String cpfCliente;
    private int codigoProduto; //dever� ser um array pois o cliente pode locar mais de um produto por vez
    private Calendar dataDaDevolucao;
    private double valorLocacao;
    private double multa;
    private double desconto;
    private double valorPago;
    private boolean pago;
    
    //M�todos
    public void incluirLocacao() {
        //toDo
    }
    
    public void alterarLocacao() {
        //toDo
    }
    
    public void removerLocacao(){
        //toDo
    }
    
    public void pesquisarLocacao() {
        //toDo
    }
    
    public void imprimirFaturamentoMes() {
        //Lista dos itens alugados num determinado m�s com os valores somados
        //toDo
    }
    
    public void imprimirLocacaoData() {
        //Lista de itens alugados num determinado per�odo
        //toDo
    }
    
    public void imprimirLocacaoCliente() {
        //Lista de itens(codigo e titulo) alugados por um cliente
        //toDo
    }
    
    public void imprimirComprovanteLocacao() {
        //Um recibo para loca��o
        //toDo
    }
    
    //M�todos Especiais - Getters e Setters
    

    
    public void setDataDaLocacao(Calendar dataDaLocacao) {
        this.dataDaLocacao = dataDaLocacao;
    }

    public Calendar getDataDaLocacao() {
        return dataDaLocacao;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        if(cpfCliente != null)
            if(cpfCliente.equals("")){
                System.out.println("Loca��o sem CPF!");
                this.cpfCliente = "Loca�ao sem CPF";
            }else
        this.cpfCliente = cpfCliente;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        if(codigoProduto>0)
        this.codigoProduto = codigoProduto;
    else
        System.out.println("C�digo do produto inv�lido!");
    }


    public void setDataDaDevolucao(Calendar dataDaDevolucao) {
        if(dataDaDevolucao != null)
            if(dataDaDevolucao.equals("")){
                System.out.println("Loca��o sem data de devolu��o!");
                this.dataDaDevolucao = null;
            }else
        this.dataDaDevolucao = dataDaDevolucao;
    }

    public Calendar getDataDaDevolucao() {
        return dataDaDevolucao;
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        if(valorLocacao>0)
            this.valorLocacao = valorLocacao;
        else System.out.println("Valor n�o aceit�vel.");
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        if(multa>=0 && multa < valorLocacao)
            this.multa = multa;
        else System.out.println("Valor n�o aceit�vel.");
    }
    
    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        if(desconto>=0 && desconto<valorLocacao)
            this.desconto = desconto;
        else System.out.println("Valor n�o aceit�vel.");
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        if(valorPago>0)
            this.valorPago = valorLocacao + multa - desconto;
        else System.out.println("Valor n�o aceit�vel.");
    }    

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    //M�todos Especiais - Construtor
    public Locacao(){}; //Construtor default
    public Locacao(Calendar dataDaLocacao, String cpfCliente, int codigoProduto, Calendar dataDaDevolucao, double valorLocacao, double multa, double desconto, double valorPago, boolean pago) {
        this.dataDaLocacao = dataDaLocacao;
        this.cpfCliente = cpfCliente;
        this.codigoProduto = codigoProduto;
        this.dataDaDevolucao = dataDaDevolucao;
        this.valorLocacao = valorLocacao;
        this.multa = multa;
        this.desconto = desconto;
        this.valorPago = valorPago;
        this.pago = pago;
    }
    
    //M�todos Especiais - toString
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
        return "Loca��o{" + "\nData da locacao: " + sdf.format(getDataDaLocacao().getTime()) + "\nCPF: " + cpfCliente + "\nC�digo do produto: " + codigoProduto + "\nData da devolu��o: " + sdf.format(getDataDaDevolucao().getTime()) + "\nValor da locacao: " + (dinheiroBR.format(valorLocacao)) + "\nMulta: " + (dinheiroBR.format(multa)) + "\nDesconto:" + (dinheiroBR.format(desconto)) + "\nValor pago: " + (dinheiroBR.format(valorPago)) + "\nPago: " + pago + "\n" + '}';
    }
}