package fuction.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conect {
    private final String USERNAME = "root";
    private final String PASSWORD = "brasil";
    //login e senha de acesso ao mysql
    private final String URl_BC = "jdbc:mysql://localhost:3306/banco_digital";
    private Connection conect;
    //metodo q cria a conexão com o myslq
        public Connection conectMysql(){
        //try para captura um erro de conexão(o erro seria se o banco de dados não existisse)
            try {
            conect = DriverManager.getConnection(URl_BC, USERNAME, PASSWORD);

            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
            return conect;
        }
}
