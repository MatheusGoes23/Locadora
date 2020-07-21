package locadora.Model.DAO;

import java.sql.SQLException;

import locadora.Model.VO.UsuarioVO;

public interface UsuarioInterDAO<VO extends UsuarioVO> extends ConectarBDinterDAO<VO> {
	public void alterar(VO vo) throws SQLException;
}
