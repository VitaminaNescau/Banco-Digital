package fuction.BD;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class user {
    private static int id;
    private static String nome,telefone,mail,cpf,password;
    private static double saldo,saque;
    private static Date date;
    public user(){
        setDate();
    }
    public  int getId(){
        return id;
    }
    public  void setId(int id){
        this.id=id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone=telefone;
    }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail=mail;
    }
    public double getSaldo(){

        return saldo;
    }
    public void setSaldo(double saldo){
        
        this.saldo=getSaldo()+saldo;
    }
    public String getCPF(){
        return cpf;
    }
    public void setCPF(String cpf){
        this.cpf=cpf;
    }
    public String getPass(){
        return password;
    }
    public void setPass(String password){
        this.password=password;
    }
    public void setDate(){
        this.date = new Date(System.currentTimeMillis());
    }
    public String getDate(){
        DateFormat dF = new SimpleDateFormat("yyyy/MM/dd");
        return dF.format(date);
    }
    public double getSaque(){
        return saque;
    }
    public void setSaque(double saque){
        this.saque = saque;

    }
}
