package locadora.Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ConectarBDinter<VO> {
	public void inserir(VO entity) throws SQLException;

	public void alterar(VO entity) throws SQLException;

	public ResultSet buscar(VO entity) throws SQLException;

	public ResultSet listar() throws SQLException;
}
