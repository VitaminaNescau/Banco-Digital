package fuction.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO extends Connect{
    String sql;  
    boolean status;
    //atributo q recebe os dados para a conexão
    private Connection con = conectMysql();
    //metodo com parametro da classe user.
    //criando conta no banco de dados
    public void signUP(User user){
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
    //verificando se a conta existe no banco de dados, caso exista recebera os dados delas
    public boolean signIN(User user){
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
                            user.setId(r.getInt("id_user"));
                            user.setNome(r.getString("name"));
                            user.setSaldo(r.getDouble("balance"));
                            user.setPix(r.getString("pix"));
                            user.setPass6(r.getInt("password6"));
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
    //verificar as informações da conta
    public boolean verifyUP(User user, int t){
        try {
            switch (t) {
                //verifica se o cpf existe para criar a conta
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
                //verifica o saldo da conta para que ocorra o saque ou transferencia
                case 2:
                    sql ="select balance from user where id_user=?";
                    PreparedStatement stB = con.prepareStatement(sql);
                    stB.setInt(1, user.getId());
                    ResultSet reB = stB.executeQuery();     
                    while (reB.next()) {
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
    public boolean verifyUP(String CPFandPIX){
        //verificar se cpf ou pix existe para efetuar transferencia 
        sql ="select cpf,pix from user";
            try{   
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet re = st.executeQuery();
                    while (re.next()) {
                        if (re.getString("cpf").equals(CPFandPIX) || re.getString("pix").equals(CPFandPIX)) {
                        status = true;
                            break;
                        } else {
                        status = false;
                        }
                     } 
                    }catch(Exception e){
                        System.out.println(e);
                    }  
        
        return status;
    }
    //faz atualização dos  dados da conta, atualmente sendo utilizado para fazer depositos e atualizar o saldo do usuario
    public void updateINFO(User user){
        sql = "update user set balance = ? where id_user = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, user.getSaldo());
            ps.setInt(2, user.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
           
            e.printStackTrace();
        } 

    }
    //atualizar o saldo receptor da transferencia
    public void transfer(User user,String cpf){
            sql = "update user set balance = balance + ? where cpf =?";
                  try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setDouble(1,user.getTrans());
                    ps.setString(2, cpf);
                    ps.execute();
                    ps.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }  
            }
    public void transfer(User user,String pix,boolean t){
        sql = "update user set balance = balance + ? where pix =?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDouble(1,user.getTrans());
                ps.setString(2, pix);
                ps.execute();
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            }
    // verificar a senha para transferencia
     public boolean VerifyPASS(User user,int pass){
        if (user.getPass6()==pass) {
            return true;
                } else {
                    return false;
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

    
