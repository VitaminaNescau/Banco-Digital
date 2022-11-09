package fuction;

import fuction.BD.user;

public class movi {
    user teste = new user();
    /*Permitir transferências (pix)
Permitir depósitos para outros usuários. */
    public double bcSaldo(user user){
       user.setSaldo(1500);

        return 0; 
    }
    public void movita(user user){
        //bcSaldo(teste);
        System.out.println("entour aq");
        System.out.println(user.getCPF());
    }
}
