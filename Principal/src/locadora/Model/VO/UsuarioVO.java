package locadora.Model.VO;

public class UsuarioVO {
	// Atributos
	private Long idUsuario;
	private String login;
	private String senha;
	private int perfil; // 1 - Proprietário; 2 - Funcionario; 3 - Admin;

//Métodos Especiais - Getters e Setters
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public int getPerfil() {
		return perfil;
	}

	// Métodos Especiais - Construtor
	public UsuarioVO() {
	}; // Construtor default

	public UsuarioVO(Long idUsuario, String login, String senha, int perfil) {
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}

	// Métodos Especiais - toString
	@Override
	public String toString() {
		return "Usuario{" + "\nId: " + idUsuario + "\nLogin: " + login + "\nSenha=" + senha + "\nPerfil=" + perfil
				+ "\n" + '}';
	}
}
