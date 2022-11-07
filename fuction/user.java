package fuction;

public class user {
    private int id;
    private String nome,telefone,mail,cpf,password;
    private double saldo;

    public int getId(){
        return id;
    }
    public void setId(int id){
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
        this.saldo=saldo;
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
}
