package fuction.BD;
//essa classe sera usada para login e cadastro de conta
public class login {
     user createUser = new user();
    //cadastro
    public void userSignUp(String name,String cpf,String email,String password,String cell){
       userDAO newUser = new userDAO();
        createUser.setNome(name);
        createUser.setTelefone(cell);
        createUser.setCPF(cpf);
        createUser.setMail(email);
        createUser.setPass(password);
        //corrigir valores de telefone no mysql
       if (newUser.verifyUP(createUser)) {
             newUser.signUP(createUser);
       }else{
            System.out.println("CPF já cadastrado");
       } 
    }
    //login
    public boolean userSignIn(String cpf,String password){
        createUser.setCPF(cpf);
        createUser.setPass(password);
        userDAO User = new userDAO();
        
        if (User.signIN(createUser)) {
            return true;
        } else {
            return false;
        }
        
    }
}
