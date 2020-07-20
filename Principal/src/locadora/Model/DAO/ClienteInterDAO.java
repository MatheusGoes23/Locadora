package locadora.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import locadora.Model.VO.ClienteVO;

public interface ClienteInterDAO<VO extends ClienteVO> extends ConectarBDinterDAO<VO> {
	public void alterar(VO vo) throws SQLException;

	public ResultSet buscarByCPF(VO vo) throws SQLException;

	public void removerByCPF(VO vo) throws SQLException;

}
