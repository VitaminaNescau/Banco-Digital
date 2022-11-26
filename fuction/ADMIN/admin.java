package fuction.ADMIN;

public class admin {
   
    private int id;
    private String mail;
    private String cpf;
    private String password;
    private String nome;
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
    public String getPass(){
        return password;
    }
    public void setPass(String password){
        this.password=password;
    }
}
