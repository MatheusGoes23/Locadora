package locadora.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ConectarBD<VO> implements ConectarBDinterDAO<VO> {
	private static Connection connection = null;
	private static final String url = "jdbc:mariadb://localhost:3303/locadora";
	private static final String user = "valdirjunior";
	private static final String senha = "123456";

	public Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		} else
			return connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public abstract void inserir(VO vo) throws SQLException;

	public abstract void remover(VO vo) throws SQLException;

	public abstract ResultSet buscar(VO vo) throws SQLException;

}
