package locadora.Model.VO;

import java.util.Scanner;

import locadora.Model.BO.ClienteBO;

public class ClienteVO extends ClienteBO{
    Scanner leitura = new Scanner(System.in);
    //Vari�veis
    private String nome;
    private String endereco;
    private String telefone;
    private String cpf;
    private Long idCliente;

    //M�todos Especiais - Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null)
            nome = "";
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
        if(endereco == null)
            endereco = "";
            if(endereco.equals("")){
                System.out.println("Cliente sem endere�o!");
                this.endereco = "Cliente sem endere�o";
            }else
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone == null)
            telefone = "";
            if(telefone.equals("")){
                System.out.println("Cliente sem Telefone!");
                this.telefone = "Cliente sem telefone";
            }else
        this.telefone = telefone; 
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf == null)
                cpf = "";
        if(cpf.equals("")){
                System.out.println("Cliente sem CPF!");// isso n�o dar� certo porque o cpf ser� chave estrangeira em locacao
                this.cpf = "Cliente sem CPF";
        }
        else{
                this.cpf = cpf;
        }
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    //M�todos Especiais - Construtor
    public ClienteVO(){}; //Construtor default
    public ClienteVO(String nome, String endereco, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    //M�todos Especiais - toString
    @Override
    public String toString() {
        return "Cliente{\n" + "Nome: " + nome + "\nEndere�o: " + endereco + "\nTelefone: " + telefone + "\nCPF: " + cpf + "\n" + '}';
    }
}
