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
      movi mo = new movi();
      /*  t.setDate();;
      t.setNome("teste2");
      //t.setTelefone("71987908550");
      //corrigir valores de telefone no mysql
     // t.setSaldo(3000);
      t.setCPF("123456789");
      t.setPass("1234");
      
      teste.signUP(t);*/

        login login = new login();
       /*  login.userSignUp("Davi", "10006264581", "@gmail.cxom", "davi123456", "71987908550");
        login.userSignUp("Bruno", "07466819508", "@gmail.cxom", "bruno123456", "71987908550");
        login.userSignUp("Douglas", "04016464595", "@gmail.cxom", "davi123456", "71987908550");
        */
        teste.updateINFO(t);
     //login.userSignIn("07466819508","bruno123456");
     if (login.userSignIn("04016464595","davi123456")) {
        System.out.println("sucesso");
        mo.movita(t);
     } else {
        System.out.println("depressão");
     }


}
}
