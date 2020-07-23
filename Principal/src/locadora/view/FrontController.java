package locadora.view;




import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import locadora.Model.VO.UsuarioVO;
import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.Model.VO.LocacaoVO;
import locadora.exception.AutenticationException;
import locadora.exception.InsertException;

public class FrontController implements Initializable{
	//VARIAVEIS FXML
	
	//Tela Login
	@FXML private TextField login;
	@FXML private PasswordField senha;
	@FXML private Label erroAut;
	
	//Tela Cadastro
	@FXML private TextField cadLogin;
	@FXML private TextField cadSenha;
	
	//Tela Cadastro Cliente
	@FXML private TextField clienteNome;
	@FXML private TextField clienteTelefone;
	@FXML private TextField clienteCPF;
	@FXML private TextField clienteEnd;
	
	//Tela cadastro de vinil
	@FXML private TextField vinilTitulo;
	@FXML private TextField vinilBanda;
	@FXML private TextField vinilEstilo;
	@FXML private TextField vinilData;
	@FXML private TextField vinilQuantidade;
	@FXML private TextField vinilValor;
	
	// Tela cadastro de Livro
	@FXML private TextField livroTitulo;
	@FXML private TextField livroAutor;
	@FXML private TextField livroGenero;
	@FXML private TextField livroLancamento;
	@FXML private TextField livroPaginas;
	@FXML private TextField livroQuant;
	@FXML private TextField livroValor;
	
	//TABELA CLIENTE
	@FXML private TableColumn <ClienteVO,Integer> tbCpfCliente;
	@FXML private TableColumn <ClienteVO,String> tbNomeCliente;
	@FXML private TableColumn <ClienteVO,String> tbTelefoneCliente;
	@FXML private TableColumn <ClienteVO,String> tbEndCliente;
	@FXML private TableView <ClienteVO> tbClientes;
	
	//TABELA LIVROS
	@FXML private TableColumn <LivroVO,Integer> tbLivroCod;
	@FXML private TableColumn <LivroVO,String> tbLivroTitulo;
	@FXML private TableColumn <LivroVO,String> tbLivroAutor;
	@FXML private TableColumn <LivroVO,String> tbLivroGenero;
	@FXML private TableColumn <LivroVO,Integer> tbLivroLanc;
	@FXML private TableColumn <LivroVO,Integer> tbLivroQuant;
	@FXML private TableColumn <LivroVO,Integer> tbLivroPagina;
	@FXML private TableColumn <LivroVO,Integer> tbLivroValor;
	@FXML private TableView <LivroVO> tbLivros;
	
	@FXML private Button btnPesquisa;
	@FXML private TextField txtPesquisa;
	
	
	//TABELA DISCOS
	
	@FXML private TableColumn <DiscoVO,Integer> tbDiscoCod;
	@FXML private TableColumn <DiscoVO,String> tbDiscoTitulo;
	@FXML private TableColumn <DiscoVO,String> tbDiscoBanda;
	@FXML private TableColumn <DiscoVO,String> tbDiscoGenero;
	@FXML private TableColumn <DiscoVO,Integer> tbDiscoLanc;
	@FXML private TableColumn <DiscoVO,Integer> tbDiscoQuant;
	@FXML private TableColumn <DiscoVO,Integer> tbDiscoValor;
	@FXML private TableView <DiscoVO> tbDiscos;
	
	//ALTERAR VINIL
	@FXML private Label idAlterarVinil;
	@FXML private TextField txtAlteraTitulo;
    @FXML private TextField txtAlteraBanda;
    @FXML private TextField txtAlteraGenero;
    @FXML private TextField txtAlteraData;
    @FXML private TextField txtAlteraValor;
    @FXML private TextField txtAlteraQuant;
	
    private LivroVO livroSelecionado;
	private DiscoVO discoSelecionado;
	private ClienteVO clienteSelecionado;
	
	private ObservableList<LivroVO> livroLista = FXCollections.observableArrayList();
	private ObservableList<DiscoVO> discoLista = FXCollections.observableArrayList();
	private ObservableList<ClienteVO> clienteLista = FXCollections.observableArrayList();
	

	
	//CHAMADAS
	UsuarioInterBO<UsuarioVO> usuBO = new UsuarioBO();
	ClienteInterBO<ClienteVO> cliBO = new ClienteBO();
	DiscoInterBO<DiscoVO> discoBO = new DiscoBO();
	LivroInterBO<LivroVO> livroBO = new LivroBO();
	LocacaoInterBO<LocacaoVO> locaBO = new LocacaoBO();
	
	
	//TRATAMENTO DE USUARIOS
	public void autenticar(ActionEvent event) throws Exception {
		UsuarioVO vo = new UsuarioVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());
		
		
			try {
				erroAut.setVisible(false);
				usuBO.autenticar(vo);
				Telas.telaInicial();
					
			
			} catch (AutenticationException e) {
				erroAut.setText("Algum campo está vazio");
				erroAut.setVisible(true);
			}
		
	}
	
  
   
   public void inserirUsuario() throws InsertException {
	   UsuarioVO vo = new UsuarioVO();
	   vo.setLogin(cadLogin.getText());
	   vo.setSenha(cadSenha.getText());
	   
	   usuBO.inserir(vo);
	   
	   try {
		Telas.telaLogin();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   //TRATAMENTO DE CLIENTE
   public void inserirCliente() {
	   ClienteVO vo = new ClienteVO();
	   vo.setNome(clienteNome.getText());
	   vo.setTelefone(clienteTelefone.getText());
	   vo.setCpf(clienteCPF.getText());
	   vo.setEndereco(clienteEnd.getText());
	   
	   try {
		cliBO.inserir(vo);
		
		clienteNome.setText("");
		clienteTelefone.setText("");
		clienteCPF.setText("");
		clienteEnd.setText("");
		
	} catch (InsertException e) {
		
		e.printStackTrace();
	}
	   
   }
   
   //tabela
   
public void iniciarTabelaCliente() throws InsertException {
	   tbCpfCliente.setCellValueFactory(new PropertyValueFactory<>("cpf"));
	   tbNomeCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
	   tbEndCliente.setCellValueFactory(new PropertyValueFactory<>("endereco"));
	   tbTelefoneCliente.setCellValueFactory(new PropertyValueFactory<>("telefone"));
	   
	   ClienteBO bo = new ClienteBO();
	   clienteLista = FXCollections.observableArrayList(bo.listar());
	   tbClientes.setItems(clienteLista);
	   
   }
   
   // TRATAMENTO DE VINIL
   public void inserirVinil() throws InsertException {
	   DiscoVO vo = new DiscoVO();
	   vo.setTitulo(vinilTitulo.getText());
	   vo.setNomeDaBanda(vinilBanda.getText());
	   vo.setGenero(vinilEstilo.getText());
	   vo.setAnoDeLancamento(Integer.parseInt(vinilData.getText()));
	   vo.setQtdExemplares(Integer.parseInt(vinilQuantidade.getText()));
	   vo.setValorDoAlulguel(Double.parseDouble(vinilValor.getText()));
	   
	   discoBO.inserir(vo);
	   vinilTitulo.setText("");
	   vinilBanda.setText("");
	   vinilEstilo.setText("");
	   vinilData.setText("");
	   vinilQuantidade.setText("");
	   vinilValor.setText("");
	   
   }
   
   public void iniciarTabelaVinil() throws Exception {
	   
	   tbDiscoCod.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
	   tbDiscoTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
	   tbDiscoBanda.setCellValueFactory(new PropertyValueFactory<>("nomeDaBanda"));
	   tbDiscoGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
	   tbDiscoLanc.setCellValueFactory(new PropertyValueFactory<>("anoDeLancamento"));
	   tbDiscoQuant.setCellValueFactory(new PropertyValueFactory<>("qtdExemplares"));
	   tbDiscoValor.setCellValueFactory(new PropertyValueFactory<>("valorDoAluguel"));
	   
	   DiscoBO bo = new DiscoBO();
	   discoLista = FXCollections.observableList(bo.listar());
	   tbDiscos.setItems(discoLista);
	  
   }
   
   @Override
   public void initialize(URL url, ResourceBundle rb) {
	   try {
		iniciarTabelaLivro();
		tbLivros.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<LivroVO>() {
			@Override
			public void changed(ObservableValue<? extends LivroVO> observable, LivroVO oldValue, LivroVO newValue) {
				livroSelecionado = newValue;
			}});
	} catch (Exception e) {}
	   try {
		iniciarTabelaVinil();
		tbDiscos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DiscoVO>() {

			@Override
			public void changed(ObservableValue<? extends DiscoVO> observable, DiscoVO oldValue, DiscoVO newValue) {
				discoSelecionado = newValue;
			}});
	} catch (Exception e) {}
   	
	   try {
			iniciarTabelaCliente();
			tbClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
				@Override
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					clienteSelecionado = (ClienteVO)newValue;
					System.out.println(clienteSelecionado);
					
				}});
		} catch (Exception e) {}
	   
	  
	   	
   }
   
   public void deletaLivro(ActionEvent event) throws InsertException {
	   livroBO.remover(livroSelecionado);
   }
   
   public void deletaVinil(ActionEvent event) throws InsertException {
	   discoBO.remover(discoSelecionado);
   }
   
   public void deletaCliente(ActionEvent event) throws InsertException {
	   cliBO.remover(clienteSelecionado);
   }
   
   public void campoPesquisaLivro(ActionEvent event)throws Exception{
	   tbLivros.setItems(buscarLivro());
   }
   
   public void campoPesquisaDisco(ActionEvent event)throws Exception{
	   tbDiscos.setItems(buscarDiscos());
   }
   public void campoPesquisaCliente(ActionEvent event)throws Exception{
	   tbClientes.setItems(buscarCliente());
   }
   
   public void iniciarAlterarDisco() {
	
   }
   
   



   public void alterarVinil(ActionEvent event) throws Exception{
	   Telas.alterarVinil();
   }
   
   public void telaInserirVinil(ActionEvent event) throws Exception {
	   Telas.cadastroVinil();
   }
   
   public void telaInicialVinil(ActionEvent event) throws Exception{
	   Telas.inicialVinil();
   }
   
   public void telaInicialLivros(ActionEvent event) throws Exception {
	   Telas.telaInicial();
   }
   
   public void telaIncluirLivros(ActionEvent event) throws Exception{
	   Telas.cadastroLivros();
   }
   
   public void telaAlterarLivros(ActionEvent event) throws Exception{
	   Telas.alterarLivros();
   }
   
   public void telaClientes(ActionEvent event) throws Exception {
	   Telas.telaClientes();
   }
   
   public void telaIncluirClientes(ActionEvent event) throws Exception {
	   Telas.telaIncluirClientes();
   }
   
   public void telaLocacao(ActionEvent event) throws Exception{
	   Telas.telaLocacao();
   }
   
  //TRATAMENTO DE LIVROS
   
   public void iniciarTabelaLivro() throws Exception {
	   
	   tbLivroCod.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
	   tbLivroTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
	   tbLivroAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
	   tbLivroGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
	   tbLivroLanc.setCellValueFactory(new PropertyValueFactory<>("anoDeLancamento"));
	   tbLivroQuant.setCellValueFactory(new PropertyValueFactory<>("qtdExemplares"));
	   tbLivroPagina.setCellValueFactory(new PropertyValueFactory<>("qtdPaginas"));
	   tbLivroValor.setCellValueFactory(new PropertyValueFactory<>("valorDoAluguel"));
	   
	   LivroBO bo = new LivroBO();
	   livroLista = FXCollections.observableList(bo.listar());
	   tbLivros.setItems(livroLista);
	   
	   
   }
   
   public void inserirLivro() throws InsertException{
	   LivroVO vo = new LivroVO();
	   
	   vo.setAutor(livroAutor.getText());
	   vo.setTitulo(livroTitulo.getText());
	   vo.setGenero(livroGenero.getText());
	   vo.setAnoDeLancamento(Integer.parseInt(livroLancamento.getText()));
	   vo.setQtdExemplares(Integer.parseInt(livroQuant.getText()));
	   vo.setQtdPaginas(Integer.parseInt(livroPaginas.getText()));
	   vo.setValorDoAlulguel(Double.parseDouble(livroValor.getText()));
	   
	   livroBO.inserir(vo);
	   
	   livroTitulo.setText("");
	   livroAutor.setText("");
	   livroGenero.setText("");
	   livroLancamento.setText("");
	   livroQuant.setText("");
	   livroValor.setText("");
	   livroPaginas.setText("");
   }
   
   public void alterarLivro() throws InsertException{
	   LivroVO alt = new LivroVO();
	   
	   alt.setAutor(livroAutor.getText());
	   alt.setTitulo(livroTitulo.getText());
	   alt.setGenero(livroGenero.getText());
	   alt.setAnoDeLancamento(Integer.parseInt(livroLancamento.getText()));
	   alt.setQtdExemplares(Integer.parseInt(livroQuant.getText()));
	   alt.setValorDoAlulguel(Double.parseDouble(livroValor.getText()));
	   
	   livroBO.alterarQuantidade(alt);
	   livroBO.alterarValor(alt);
	   
	   livroTitulo.setText("");
	   livroAutor.setText("");
	   livroGenero.setText("");
	   livroLancamento.setText("");
	   livroQuant.setText("");
	   livroValor.setText("");
   }
   
   public ObservableList<LivroVO> buscarLivro() {
	   ObservableList<LivroVO> livroPesquisa = FXCollections.observableArrayList();
	   for(int x = 0 ; x < livroLista.size(); x++) {
		   if(livroLista.get(x).getTitulo().contains(txtPesquisa.getText())) {
			   livroPesquisa.add(livroLista.get(x));
		   }
	   }
	return livroPesquisa;
	   
   }
   
   private ObservableList<DiscoVO> buscarDiscos() {
	   ObservableList<DiscoVO> discoPesquisa = FXCollections.observableArrayList();
	   for(int x = 0 ; x < discoLista.size(); x++) {
		   if(discoLista.get(x).getTitulo().contains(txtPesquisa.getText())) {
			   discoPesquisa.add(discoLista.get(x));
		   }
	   }
	return discoPesquisa;
	}
   
   private ObservableList<ClienteVO> buscarCliente() {
	   ObservableList<ClienteVO> clientePesquisa = FXCollections.observableArrayList();
	   for(int x = 0 ; x < clienteLista.size(); x++) {
		   if(clienteLista.get(x).getNome().contains(txtPesquisa.getText())) {
			   clientePesquisa.add(clienteLista.get(x));
		   }
	   }
	return clientePesquisa;
	}

   
   //TELA DE LOGIN
   
   public void btnCadastro(ActionEvent event) throws Exception {
	   Telas.telaCadastro();
   }
   
   public void logout(ActionEvent event) throws Exception{
	   Telas.telaLogin();
   }




   
}