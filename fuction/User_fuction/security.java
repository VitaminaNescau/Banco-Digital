package fuction.User_fuction;

import fuction.BD.User;

public class security extends User{
    public boolean VerifyPASS(int pass){
        if (getPass6()==pass) {
            return true;
                } else {
                    return false;
                }
            }
}
