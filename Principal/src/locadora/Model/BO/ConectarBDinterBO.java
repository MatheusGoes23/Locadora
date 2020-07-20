package locadora.Model.BO;

import java.util.List;

import locadora.exception.InsertException;
import locadora.exception.NotFoundException;

public interface ConectarBDinterBO<VO> {
	public void inserir(VO vo) throws InsertException;
	public void remover(VO vo) throws InsertException;
	public List<VO> listar() throws InsertException;
}
