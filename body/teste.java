
import fuction.Movi;
import fuction.BD.Login;
import fuction.BD.User;
import fuction.BD.UserDAO;
import fuction.BD.User;
public class teste {
    public static void main(String[] args) {
      User t = new User();
      
      UserDAO teste = new UserDAO();
       // teste.signIN(t);
     
      /*  t.setDate();;
      t.setNome("teste2");
      //t.setTelefone("71987908550");
      //corrigir valores de telefone no mysql
     // t.setSaldo(3000);
      t.setCPF("123456789");
      t.setPass("1234");
      
      teste.signUP(t);*/

        Login login = new Login();
        login.userSignUp("Vitor", "09301041536", "@gmail.cxom", "vitor123456", "71987908550");
        login.userSignUp("Bruno", "07466819508", "@gmail.cxom", "bruno123456", "71987908550");
        login.userSignUp("Douglas", "04016464595", "@gmail.cxom", "davi123456", "71987908550");
        
        //teste.updateINFO(t);
     //login.userSignIn("07466819508","bruno123456");
     if (login.userSignIn("07466819508","bruno123456")) {
        System.out.println("sucesso");
         Movi mo = new Movi(1000);
     } else {
        System.out.println("depressão");
     }


}
}
