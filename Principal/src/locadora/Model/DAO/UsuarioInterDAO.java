package locadora.Model.DAO;

import java.sql.SQLException;
import java.util.List;

import locadora.Model.VO.UsuarioVO;

public interface UsuarioInterDAO<VO extends UsuarioVO> extends ConectarBDinterDAO<VO> {
	public void alterar(VO vo) throws SQLException;

	public List<UsuarioVO> listar() throws SQLException;

	public void autenticar(VO vo) throws SQLException;
}
