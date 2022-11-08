package fuction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class userDAO extends conect{
    String sql; 
    //atributo q recebe os dados para a conexão
    private Connection con = conectMysql();
    //metodo com parametro da classe user.
    public void signUP(user user){
        //varia com o comando do mysql
        sql ="insert into user(name,cpf,password,date_create) values(?,?,?,?)";
        try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, user.getNome());
                //ps.setString(2, user.getTelefone());
               // ps.setDouble(3, user.getSaldo());
                ps.setString(2, user.getCPF());
                ps.setString(3, user.getPass());
                ps.setString(4, user.getDate());
                ps.execute();
                ps.close();
                System.out.println("sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro, tente novamente");
        }

    }
    public void signIN(user user){
       //sql ="select cpf from user where cpf = 987654321";
        //sql = "select cpf from user where cpf = ?;";
        sql = "select * from user;";
       try {
            Statement ps = con.createStatement();
            ResultSet r = ps.executeQuery(sql);
            //oq result faz? oq executeQuery faz?
            while(r.next()) {
                int cont=0;
                if (user.getCPF().equals(r.getString(3))) {
                    cont++;
                    System.out.println(cont);
                    if (r.getString(4).equals(user.getPass())) {
                        System.out.println(cont);
                     System.out.println("encontrou"+" " + r.getString(3)+" "+r.getString(4));
                     break;
                     
                }else{
                    System.out.println("Conta não encontra ou não existe");
                }
                }
                
                System.out.println("entrou no while");
              // 
               
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    }
