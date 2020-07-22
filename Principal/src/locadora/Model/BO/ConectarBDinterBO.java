package locadora.Model.BO;

import java.util.List;

import locadora.Model.VO.ClienteVO;
import locadora.Model.VO.LivroVO;
import locadora.exception.InsertException;

public interface ConectarBDinterBO<VO> {
	public void inserir(VO vo) throws InsertException;

	public void remover(VO vo) throws InsertException;

	public List<LivroVO> listar() throws InsertException;
}
