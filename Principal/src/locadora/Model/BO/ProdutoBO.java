package locadora.Model.BO;

import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.Model.VO.ProdutoVO;


public abstract class ProdutoBO {
    public ProdutoVO[]listarProdutos(){
        LivroVO livro = new LivroVO();
        DiscoVO disco = new DiscoVO();
        
        ProdutoVO produtos[] = new ProdutoVO[3];
        ProdutoVO produto = new DiscoVO();
        livro.setTitulo("O nome da rosa");
        disco.setTitulo("The Best of");
        produto.setTitulo("titulo do Produto");
        produtos[0] = livro;
        produtos[1] = disco;
        produtos[2] = produto;
        return produtos;
    }

    //Métodos
    public abstract void incluir(ProdutoVO produto); 
    
    public abstract void alterar(ProdutoVO produto); 
        
    public abstract void remover(ProdutoVO produto); 
      
    public abstract ProdutoVO imprimirFicha(ProdutoVO produto); 
    
    public abstract ProdutoVO [] pesquisarTitulo(String titulo);
    
    public abstract ProdutoVO [] pesquisarAno(int ano);
    
    public abstract ProdutoVO [] pesquisarGenero(String genero);
    
    public abstract void imprimirLista();
}