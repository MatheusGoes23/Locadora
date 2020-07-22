package locadora.Model.BO;

import java.util.List;

import locadora.Model.VO.ClienteVO;
import locadora.exception.InsertException;

public interface ClienteInterBO<VO extends ClienteVO> extends ConectarBDinterBO<VO> {
	public void removerByCPF(VO vo) throws InsertException;

	public List<ClienteVO> pesquisar(ClienteVO vo) throws InsertException;
	
	public void alterar(VO vo) throws InsertException;
<<<<<<< HEAD
}
=======
}
>>>>>>> 95daf41baa49d78f11c633fd0a9f91b8d1ee9e2e
