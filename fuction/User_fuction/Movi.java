package fuction.User_fuction;

import fuction.ADMIN.action;
import fuction.BD.User;
import fuction.BD.UserDAO;
import fuction.BD.User;

public class Movi{
    User user = new User();
    UserDAO DAO = new UserDAO();
    
    /*Permitir transferências (pix)
Permitir depósitos para outros usuários. */
   
    public Movi(){
        //trans(s, 1, "04016464595");
    }
    /*metodo para se realizar saques, ele recebe o valor do saque 
        e subtrai do saldo do banco de dados
    */
    public void saques(double value){
        user.setSaque(value);
            if (DAO.verifyUP( 2)) {
                 user.setSaldo(user.getSaque()*(-1));
                DAO.updateINFO();
                System.out.println("Saque efetuado");
            } else {
                System.out.println("Saque não efetuado");
            }
    }
    public void deposito(double value){
        user.setSaldo(value);
        DAO.updateINFO();

    }
    public void trans(double value, int t, String cpfANDpix){
        user.setTrans(value);
        user.setSaque( user.getTrans());
        if (DAO.verifyUP( 2) && DAO.verifyUP(cpfANDpix)) {
            
            switch (t) {
                case 1:
                System.out.println("entrou 1");
                    DAO.transfer(cpfANDpix);
                    break;
                case 2:
                System.out.println("entrou 2");
                    DAO.transfer(cpfANDpix, true);  
                    break;
                default:
                    break;
        } 
       user.setSaldo(user.getTrans()*(-1));
            DAO.updateINFO();
            user.setTrans(0);
            user.setSaque(0);
           
            
            
        }
      

    }
    public void imp(double value){
        deposito(value);
        double impVALUE = value+(value*0.3);
        action actionADM = new action();
        actionADM.relatorio(impVALUE);
    }
}
