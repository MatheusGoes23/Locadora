package locadora.Model.BO;

import locadora.Model.VO.ClienteVO;
import locadora.exception.InsertException;
import locadora.exception.NotFoundException;

public interface ClienteInterBO<VO extends ClienteVO> extends ConectarBDinterBO<VO> {
	public void removerByCPF(VO vo) throws InsertException;

	public void alterar(VO vo) throws InsertException;

	public void buscar(VO vo) throws NotFoundException;
}
