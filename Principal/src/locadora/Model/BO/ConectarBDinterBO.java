package locadora.Model.BO;

import java.util.List;

import locadora.Model.VO.ClienteVO;
import locadora.Model.VO.LivroVO;
import locadora.exception.InsertException;

public interface ConectarBDinterBO<VO> {
	public void inserir(VO vo) throws InsertException;

	public void remover(VO vo) throws InsertException;

<<<<<<< HEAD
	public List<LivroVO> listar() throws InsertException;
=======
	public List<VO> listar();
>>>>>>> 95daf41baa49d78f11c633fd0a9f91b8d1ee9e2e
}
