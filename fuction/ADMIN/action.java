package fuction.ADMIN;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.PreparedStatement;


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
          FileReader fileR = new FileReader("fuction/ADMIN/relatorio.txt");
          BufferedReader buffFile = new BufferedReader(fileR);
          String texto = buffFile.readLine();
          String conteudo="";
          while (texto!=null) {
            conteudo += texto;
            texto = buffFile.readLine();
          }
          System.out.println(conteudo);
           FileWriter fileW = new FileWriter("fuction/ADMIN/relatorio.txt");
           PrintWriter writerF = new PrintWriter(fileW);
           writerF.println(conteudo+"\n"+"teste3");
           writerF.close();
          } catch (Exception e) {
            // TODO: handle exception
          }
        }
      
        public void relatorio1(){}
        
        public static void main(String[] args) {
            action t = new action();
            t.relatorio();
        }
}