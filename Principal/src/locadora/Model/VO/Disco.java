package locadora.Model.VO;


public class Disco extends Produto{

    //Vari�veis
    private String nomeDaBanda;
    
    //M�todos
    public void incluirDisco() {
        //toDo
    }
    
    public void alterarDisco() {
        //toDo
    }
    
    public void removerDisco(){
        //toDo
    }
    
    public void pesquisarDisco() {
        //Pesquisa por T�tulo, Nome da banda, estilo...
        //toDo
    }

    public void imprimirListaDiscos() {
        //Imprime listagem de discos com C�digo, T�tulo, QtdExemplares...
        //toDo
    }
    
    //M�todos especiais - Getters e Setters

    public String getNomeDaBanda() {
        return nomeDaBanda;
    }

    public void setNomeDaBanda(String nomeDaBanda) {
        if(nomeDaBanda != null)
            if(nomeDaBanda.equals("")){
                System.out.println("Disco sem nome da banda!");
                this.nomeDaBanda = "Sem nome da banda";
            }else
        this.nomeDaBanda = nomeDaBanda;
    }
}