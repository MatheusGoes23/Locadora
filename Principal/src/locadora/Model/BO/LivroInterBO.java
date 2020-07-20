package locadora.Model.BO;

import locadora.Model.VO.LivroVO;
import locadora.exception.InsertException;

public interface LivroInterBO <VO extends LivroVO> extends ConectarBDinterBO<VO>{
	public void alterarValor(VO vo) throws InsertException;
	public void alterarQuantidade(VO vo) throws InsertException;
}
