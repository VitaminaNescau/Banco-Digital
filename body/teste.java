package body;
import fuction.movi;
import fuction.BD.login;
import fuction.BD.user;
import fuction.BD.userDAO;
public class teste {
    public static void main(String[] args) {
      user t = new user();
      
      userDAO teste = new userDAO();
       // teste.signIN(t);
     
      /*  t.setDate();;
      t.setNome("teste2");
      //t.setTelefone("71987908550");
      //corrigir valores de telefone no mysql
     // t.setSaldo(3000);
      t.setCPF("123456789");
      t.setPass("1234");
      
      teste.signUP(t);*/

        login login = new login();
        login.userSignUp("Vitor", "09301041536", "@gmail.cxom", "vitor123456", "71987908550");
        login.userSignUp("Bruno", "07466819508", "@gmail.cxom", "bruno123456", "71987908550");
        login.userSignUp("Douglas", "04016464595", "@gmail.cxom", "davi123456", "71987908550");
        
        //teste.updateINFO(t);
     //login.userSignIn("07466819508","bruno123456");
     if (login.userSignIn("09301041536","vitor123456")) {
        System.out.println("sucesso");
         movi mo = new movi(3935);
     } else {
        System.out.println("depressão");
     }


}
}
