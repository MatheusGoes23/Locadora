package locadora.view;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
	
	
	UsuarioInterBO<UsuarioVO> usuBO = new UsuarioBO();
	ClienteInterBO<ClienteVO> cliBO = new ClienteBO();
	DiscoInterBO<DiscoVO> discoBO = new DiscoBO();
	LivroInterBO<LivroVO> livroBO = new LivroBO();
	LocacaoInterBO<LocacaoVO> locaBO = new LocacaoBO();
	
	//TRATAMENTO DE USUARIOS
	public void autenticar(ActionEvent event) {
		UsuarioVO vo = new UsuarioVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());
		
		
			try {
				erroAut.setVisible(false);
				usuBO.autenticar(vo);
				
				
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
   
  //TRATAMENTO DE LIVROS
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
	   livroValor.setText("");
	   
   }
}
