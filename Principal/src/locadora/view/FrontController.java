package locadora.view;



import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class FrontController {
	//VARIAVEIS FXML
	@FXML private TextField login;
	@FXML private PasswordField senha;
	@FXML private Label erroAut;
	@FXML private TextField cadLogin;
	@FXML private TextField cadSenha;
	@FXML private TextField clienteNome;
	@FXML private TextField clienteTelefone;
	@FXML private TextField clienteCPF;
	@FXML private TextField clienteEnd;
	@FXML private TextField vinilTitulo;
	@FXML private TextField vinilBanda;
	@FXML private TextField vinilEstilo;
	@FXML private TextField vinilData;
	@FXML private TextField vinilQuantidade;
	@FXML private TextField vinilValor;
	@FXML private TextField livroTitulo;
	@FXML private TextField livroAutor;
	@FXML private TextField livroGenero;
	@FXML private TextField livroLancamento;
	@FXML private TextField livroPaginas;
	@FXML private TextField livroQuant;
	@FXML private TextField livroValor;
	
	//TABELA CLIENTE
	@FXML private TableColumn <ClienteBO,Integer> tbCpfCliente;
	@FXML private TableColumn <ClienteBO,String> tbNomeCliente;
	@FXML private TableColumn <ClienteBO,String> tbTelefoneCliente;
	@FXML private TableColumn <ClienteBO,String> tbEndCliente;
	@FXML private TableView <ClienteBO> tbClientes;
	
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
	
	//TABELA DISCOS
	@FXML private TableColumn <DiscoVO,Integer> tbDiscoCod;
	@FXML private TableColumn <DiscoVO,String> tbDiscoTitulo;
	@FXML private TableColumn <DiscoVO,String> tbDiscoBanda;
	@FXML private TableColumn <DiscoVO,String> tbDiscoGenero;
	@FXML private TableColumn <DiscoVO,Integer> tbDiscoLanc;
	@FXML private TableColumn <DiscoVO,Integer> tbDiscoQuant;
	@FXML private TableColumn <DiscoVO,Integer> tbDiscoValor;
	@FXML private TableView <DiscoVO> tbDiscos;
	
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
	   tbClientes.setItems(FXCollections.observableArrayList(bo.listar()));
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
	   tbDiscos.setItems(FXCollections.observableList(bo.listar()));
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
	   tbLivros.setItems(FXCollections.observableList(bo.listar()));
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
   //TELA DE LOGIN
   
   public void btnCadastro(ActionEvent event) throws Exception {
	   Telas.telaCadastro();
   }
   
   public void logout(ActionEvent event) throws Exception{
	   Telas.telaLogin();
   }
   
}