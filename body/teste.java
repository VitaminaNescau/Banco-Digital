package body;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import fuction.*;
public class teste {
    public static void main(String[] args) {
      user t = new user();
      
      userDAO teste = new userDAO();
        teste.signIN(t);

      /*  t.setDate();;
      t.setNome("teste2");
      //t.setTelefone("71987908550");
      //corrigir valores de telefone no mysql
     // t.setSaldo(3000);
      t.setCPF("123456789");
      t.setPass("1234");
      
      teste.signUP(t);*/

        login login = new login();
        login.userSignUp("Davi", "10006264581", "@gmail.cxom", "davi123456", "71987908550");
        login.userSignUp("Bruno", "07466819508", "@gmail.cxom", "bruno123456", "71987908550");
        login.userSignUp("Douglas", "04016464595", "@gmail.cxom", "davi123456", "71987908550");

     // login.userSignIn("07466819508","bruno123456");


}
}
