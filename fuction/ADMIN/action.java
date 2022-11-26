package fuction.ADMIN;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.PreparableStatement;

import fuction.BD.Connect;

public class action extends admin{
    Connect co = new Connect();
    /*private Connection con = co.conectMysql();
    String sql;
        public void deletCont(String cpf){
            sql ="Delete from user where cpf = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,cpf);
                ps.execute();
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }*/

        public void relatorio(){
            try {
                FileWriter file = new FileWriter("fuction/ADMIN/relatorio.txt");
                PrintWriter fileWRI = new PrintWriter(file);
                fileWRI.println("teste5");
                System.out.println(2);
                file.close();
            
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        public static void main(String[] args) {
            action t = new action();
            t.relatorio();
        }
}