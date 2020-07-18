package locadora.Model.VO;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Locale;

public class LocacaoVO {
	Locale localeBR = new Locale("pt", "BR");
	NumberFormat dinheiroBR = NumberFormat.getCurrencyInstance(localeBR);
	SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");

	// Variáveis
	private Long idLocacao = 0L;
	private Calendar dataDaLocacao = Calendar.getInstance();
	private ClienteVO cliente;
	private ProdutoVO produto; // deverá ser um array pois o cliente pode locar mais de um produto por vez
	private Calendar dataDaDevolucao = Calendar.getInstance();
	private double valorLocacao;
	private double multa;
	private double desconto;
	private double valorPago;
	private boolean pago;

	// Métodos Especiais - Getters e Setters
	public void setIdLocacao(Long idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Long getIdLocacao() {
		return idLocacao;
	}

	public void setDataDaLocacao(Calendar dataDaLocacao) {
		this.dataDaLocacao = dataDaLocacao;
	}

	public Calendar getDataDaLocacao() {
		return dataDaLocacao;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setProduto(ProdutoVO produto) {
		this.produto = produto;
	}

	public ProdutoVO getProduto() {
		return produto;
	}

	public void setDataDaDevolucao() {
		getDataDaDevolucao().add(Calendar.DAY_OF_MONTH, 7);
	}

	public Calendar getDataDaDevolucao() {
		return dataDaDevolucao;
	}

	public double getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(double valorLocacao) {
		if (valorLocacao > 0)
			this.valorLocacao = valorLocacao;
		else
			System.out.println("Valor não aceitável.");
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		if (multa >= 0)
			this.multa = multa;
		else
			System.out.println("Valor não aceitável.");
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		if (desconto >= 0 && desconto < valorLocacao)
			this.desconto = desconto;
		else
			System.out.println("Valor não aceitável.");
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		if (valorPago > 0)
			this.valorPago = valorLocacao + multa - desconto;
		else
			System.out.println("Valor não aceitável.");
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	// Métodos Especiais - Construtor
	public LocacaoVO() {
	}; // Construtor default
}
