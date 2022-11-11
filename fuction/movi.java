package fuction;

import java.util.Scanner;

import fuction.BD.user;
import fuction.BD.userDAO;

public class movi {
    user user = new user();
    userDAO DAO = new userDAO();
    /*Permitir transferências (pix)
Permitir depósitos para outros usuários. */
    public void  bcSaldo(user user){
      user.setSaldo(10000.0); 
    }

    /*metodo para se realizar saques, ele recebe o valor do saque 
        e subtrai do saldo do banco de dados
    */
    public void saques(double value){
        user.setSaque(value);
            if (DAO.verifyUP(user, 2)) {
                 user.setSaldo(user.getSaque()*(-1));
                DAO.updateINFO(user);
                System.out.println("Saque efetuado");
            } else {
                System.out.println("Saque não efetuado");
            }
    }

}
