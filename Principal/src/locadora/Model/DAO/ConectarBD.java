package locadora.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD {
        Connection connection = null;
        String url = "jdbc:mariadb://localhost:3303/locadora";
        String user = "Giovanni";
        String senha = "Giggio51";

        public Connection getConnection() {
            if(connection==null){
                try{
                    connection = DriverManager.getConnection(url,user,senha);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            return connection;
            }
        else
            return connection;
        }
    }
