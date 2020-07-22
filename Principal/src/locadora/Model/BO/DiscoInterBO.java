package locadora.Model.BO;

import java.util.List;

import locadora.Model.VO.ClienteVO;
import locadora.Model.VO.DiscoVO;
import locadora.exception.InsertException;

public interface DiscoInterBO<VO extends DiscoVO> extends ConectarBDinterBO<VO> {
	public void alterarValor(VO vo) throws InsertException;

	public List<DiscoVO> pesquisar(DiscoVO vo) throws InsertException;
	
	public void alterarQuantidade(VO vo) throws InsertException;
}