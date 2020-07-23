package locadora.Model.BO;

import java.util.List;

import locadora.Model.VO.ClienteVO;
import locadora.exception.InsertException;

public interface ClienteInterBO<VO extends ClienteVO> extends ConectarBDinterBO<VO> {
	public void removerByCPF(VO vo) throws InsertException;

	public List<ClienteVO> listar();

	public List<ClienteVO> pesquisar(ClienteVO vo) throws InsertException;

	public void alterar(VO vo) throws InsertException;
}
