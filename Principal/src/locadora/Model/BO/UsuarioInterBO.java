package locadora.Model.BO;

import java.util.List;

import locadora.Model.VO.UsuarioVO;
import locadora.exception.AutenticationException;
import locadora.exception.InsertException;

public interface UsuarioInterBO<VO extends UsuarioVO> extends ConectarBDinterBO<VO> {
	public void alterar(VO vo) throws InsertException;

	public UsuarioVO autenticar(VO vo) throws AutenticationException;
	public UsuarioVO buscarUsuario(String login) throws AutenticationException;
}
