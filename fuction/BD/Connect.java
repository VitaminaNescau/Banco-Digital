package fuction.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
    private final String USERNAME = "Vitor";
    private final String PASSWORD = "brasil";
    //login e senha de acesso ao mysql
    private final String URl_BC = "jdbc:mysql://10.147.17.67/banco_digital";
    private Connection conect;
    //metodo q cria a conexão com o myslq
        public Connection conectMysql(){
        //try para captura um erro de conexão(o erro seria se o banco de dados não existisse)
            try {
            conect = DriverManager.getConnection(URl_BC, USERNAME, PASSWORD);
            System.out.println("sucesso");

            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
            return conect;
        }

        public static void main(String[] args) {
            Connect c = new Connect();
            c.conectMysql();
        }
}
