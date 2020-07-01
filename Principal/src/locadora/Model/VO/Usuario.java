package locadora.Model.VO;

public class Usuario {
    //Atributos
    private int idUsuario;
    private String login;
    private String senha;
    private int perfil; //1 - Proprietário; 2 - Funcionario; 3 - Admin;
    
    //Métodos
    public void incluirUsuario() {
        //toDo
    }
    
    public void alterarUsuario() {
        //toDo
    }
    
    public void removerUsuario(){
        //toDo
    }

    //Métodos Especiais Getters e Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        if(perfil>0 && perfil<=3)
        this.perfil = perfil;
        else System.out.println("Valor não aceitável.");
    }

    //Métodos Especiais - Construtor
    public Usuario(){}; //Construtor default
    public Usuario(int idUsuario, String login, String senha, int perfil) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    //Métodos Especiais - toString
    @Override
    public String toString() {
        return "Usuario{" + "\nId: " + idUsuario + "\nLogin: " + login +
               "\nSenha=" + senha + "\nPerfil=" + perfil + "\n" + '}';
    }    
}
