package fuction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userDAO extends conect{
    //atributo q recebe os dados para a conexão
    private Connection con = conectMysql();
    //metodo com parametro da classe user.
    public void signUP(user user){
        //varia com o comando do mysql
        String sql ="insert into user(nome,telefone,saldo) values(?,?,?)";
        try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, user.getNome());
                ps.setString(2, user.getTelefone());
                ps.setDouble(3, user.getSaldo());
                ps.execute();
                ps.close();
                System.out.println("sucesso");
        } catch (SQLException e) {
           e.printStackTrace();
        }

    }

    }
