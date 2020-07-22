package locadora.Model.BO;

import java.util.List;

import locadora.Model.VO.DiscoVO;
import locadora.Model.VO.LivroVO;
import locadora.exception.InsertException;

public interface LivroInterBO<VO extends LivroVO> extends ConectarBDinterBO<VO> {
	public void alterarValor(VO vo) throws InsertException;

	public List<LivroVO> pesquisar(LivroVO vo) throws InsertException;
	
	public void alterarQuantidade(VO vo) throws InsertException;
}