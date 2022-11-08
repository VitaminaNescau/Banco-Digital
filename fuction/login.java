package fuction;
//essa classe sera usada para login e cadastro de conta
public class login {
     user createUser = new user();
    //cadastro
    public void userSignUp(String name,String cpf,String email,String password,String cell){
       
        createUser.setNome(name);
        createUser.setTelefone(cell);
        createUser.setCPF(cpf);
        createUser.setMail(email);
        createUser.setPass(password);
        
        //corrigir valores de telefone no mysql
        userDAO newUser = new userDAO();
        newUser.signUP(createUser);
    }
    //login
    public boolean userSignIn(String cpf,String password){
        
        return true;
    }
}
