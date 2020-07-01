package locadora.Model.VO;


public class Cliente {
    //Variáveis
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    
    //Métodos
    public void incluirCliente() {
        //toDo
    }
    
    public void alterarCliente() {
        //toDo
    }
    
    public void removerCliente() {
        //toDo
    }
    
    public void pesquisarCliente() {
        //Pesquisar cliente por Nome ou CPF
        //toDo
    }
    
    public void imprimirListaClientes() {
        //Imprime um lista de Clientes com CPF, Nome, Telefone...
        //toDo
    }
    
    public void imprimirFichaCliente() {
        //Imprime ficha completa do Cliente
        //toDo
    }
    
    //Métodos Especiais - Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null)
            if(nome.equals("")){
                System.out.println("Cliente sem nome!");
                this.nome = "Cliente sem nome";
            }else
        this.nome = nome; 
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco != null)
            if(endereco.equals("")){
                System.out.println("Cliente sem endereço!");
                this.endereco = "Cliente sem endereço";
            }else
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone != null)
            if(telefone.equals("")){
                System.out.println("Cliente sem Telefone!");
                this.nome = "Cliente sem telefone";
            }else
        this.telefone = telefone; 
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf != null)
            if(cpf.equals("")){
                System.out.println("Cliente sem CPF!");
                this.cpf = "Cliente sem cpf";
            }else
        this.cpf = cpf;
    }
    
    //Métodos Especiais - Construtor
    public Cliente(){}; //Construtor default
    public Cliente(String nome, String endereco, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    //Métodos Especiais - toString
    @Override
    public String toString() {
        return "Cliente{\n" + "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nCPF: " + cpf + "\n" + '}';
    }
}