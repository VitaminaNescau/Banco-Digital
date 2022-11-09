package fuction;

import fuction.BD.user;
import fuction.BD.userDAO;

public class movi extends userDAO{
    user teste = new user();
    /*Permitir transferências (pix)
Permitir depósitos para outros usuários. */
    public void  bcSaldo(user user){
      user.setSaldo(-1500); 
    }
    public void movita(user user){
        bcSaldo(user);
        System.out.println("entour aq");
        System.out.println(user.getCPF());
        updateINFO(user);
    }
}
