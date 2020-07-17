package locadora.Model.VO;


public class DiscoVO extends ProdutoVO {

    //Variáveis
    private String nomeDaBanda;


    public String getNomeDaBanda() {
        return nomeDaBanda;
    }

    public void setNomeDaBanda(String nomeDaBanda) {
        if (nomeDaBanda == null)
            nomeDaBanda = "";
            if (nomeDaBanda.equals("")) {
                System.out.println("Disco sem nome da banda!");
                this.nomeDaBanda = "Disco sem nome da banda";
            } else
                this.nomeDaBanda = nomeDaBanda;
    }
    
    //Métodos Especiais - Construtor
    public DiscoVO() {//Construtor default
    }
    
    //Métodos Especiais - toString
    @Override //Polimorfismo de Sobrescrita
    public String toString() {
        String saida;
        saida = super.toString();
        saida = saida + "\nBanda: " + nomeDaBanda + "\n";
        return saida;
    }
}
