package fuction.BD;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/*Aqui se localizar os metodos e atributos necessarios para o funcionamento do usuario */
public class User{
    private static int id,pass6;
    private static String nome,telefone,mail,cpf,password,pix;
    private static double saldo,saque,trans;
    private static Date date;
    
    public User(){
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
    public double getTrans() {
        return trans;
    }
    public  void setTrans(double trans) {
        User.trans = trans;
    }   
     public  String getPix() {
        return pix;
    }
    public  void setPix(String pix) {
        User.pix = pix;
    }
    public void setPass6(int pass){
        this.pass6 = pass;
    }
    public int getPass6(){
        return pass6;
    }
}
