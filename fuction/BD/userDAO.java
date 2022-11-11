package fuction.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDAO extends conect {
    String sql;  
    boolean status;
    //atributo q recebe os dados para a conexão
    private Connection con = conectMysql();
    //metodo com parametro da classe user.
    public void signUP(user user){
        //variavel com o comando do mysql
        sql ="insert into user(name,cpf,password,date_create,email) values(?,?,?,?,?)";
        try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, user.getNome());
                //ps.setString(2, user.getTelefone());
               // ps.setDouble(3, user.getSaldo());
                ps.setString(2, user.getCPF());
                ps.setString(3, user.getPass());
                ps.setString(4, user.getDate());
                ps.setString(5, user.getMail());
                ps.execute();//executando o insert; vitor da uma olhada melhor nessa biblioteca
                ps.close();
                System.out.println("sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro, tente novamente");
        }
    }
    public boolean signIN(user user){
       //sql ="select cpf from user where cpf = 987654321";
        //sql = "select  from user where cpf = ?;";
        sql = "select * from user;";
        
        try {
            Statement ps = con.createStatement();
            ResultSet r = ps.executeQuery(sql);
            //oq result faz? oq executeQuery faz?
            while(r.next()) {
                if (user.getCPF().equals(r.getString("cpf"))) {
                  if (r.getString("password").equals(user.getPass())) {
                         System.out.println("encontrou"+" " + r.getString(3)+" "+r.getString(4));
                            user.setId((r.getInt("id_user")) );
                            user.setNome(r.getString("name"));
                            user.setSaldo((r.getDouble("balance")));
                         //System.out.println(user.getSaldo());//isso ta quebrando o codigo
                        status = true;
                        break;
                }else{
                    System.out.println("Senha errada");
                    status = false;
                    break;
                }
                }else{
                    status = false;
                }
                
                //System.out.println("entrou no while");
              // 
               
            }
        } catch (Exception e) {
        
        }
        System.out.println(status +" signIN");//teste
        return status;
    }
    public boolean verifyUP(user user, int t){
        //boolean status=false;
        try {
            switch (t) {
                case 1:sql ="select cpf from user";
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet re = st.executeQuery();
                    while (re.next()) {
                        if (re.getString("cpf").equals(user.getCPF())) {
                        status = false;
                            break;
                        } else {
                        status = true;
                        }
                     } 
                break;
                case 2:
                    sql ="select balance from user where id_user=?";
                    PreparedStatement stB = con.prepareStatement(sql);
                    stB.setInt(1, user.getId());
                    ResultSet reB = stB.executeQuery();     
                    while (reB.next()) {
                        System.out.println(reB.getDouble("balance")+" " +user.getSaque());
                        if (user.getSaque()<=reB.getDouble("balance") && reB.getDouble("balance") > 0) {
                                status = true; 
                                
                                break;
                            } else {
                            status = false;
                            }
                        }
                break;
                default:
                    break;
            }
            
          
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        return status;
    }
    public void updateINFO(user user){
        sql = "update user set balance = ? where id_user = ? ";
        try {
            System.out.println(user.getId()+" update");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, user.getSaldo());
            ps.setInt(2, user.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
           
            e.printStackTrace();
        } 

    }
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //testando outro forma 
    /*public void signIN2(user user){
        //sql ="select cpf from user where cpf = 987654321";
         //sql = "select cpf from user where cpf = ?;";
         sql = "select cpf,password from user where id_user = ?" ;
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, 9);
             ResultSet r = ps.executeQuery();
             //oq result faz? oq executeQuery faz?
             System.out.println("entrou aq");
             while(r.next()) {
                 int cont=0;
                 if (user.getCPF().equals(r.getString("cpf"))) {
                     System.out.println(cont);
                     if (r.getString("password").equals(user.getPass())) {
                         System.out.println(cont);
                      System.out.println("encontrou"+" " + r.getString("cpf")+" "+r.getString("password"));
                      break;
 
                 }else{
                     System.out.println("Conta não encontra ou não existe");
                 }
                 }
                 
                 System.out.println("entrou no while");
               // 
                
             }
         } catch (Exception e) {
           
         }
     }*/

    
