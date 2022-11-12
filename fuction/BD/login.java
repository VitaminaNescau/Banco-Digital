package fuction.BD;
//essa classe sera usada para login e cadastro de conta
public class Login {
     User createUser = new User();
    //cadastro
    public void userSignUp(String name,String cpf,String email,String password,String cell){
       UserDAO newUser = new UserDAO();
        createUser.setNome(name);
        createUser.setTelefone(cell);
        createUser.setCPF(cpf);
        createUser.setMail(email);
        createUser.setPass(password);
        //verifica se o cpf já existe no banco de dados
        if (newUser.verifyUP(createUser,1)) {
             newUser.signUP(createUser);
       }else{
            System.out.println("CPF já cadastrado");
       } 
    }
    //login
    public boolean userSignIn(String cpf,String password){
        createUser.setCPF(cpf);
        createUser.setPass(password);
        UserDAO User = new UserDAO();
        if (User.signIN(createUser)) {
            return true;
        } else {
            return false;
        }
        
    }
}
