/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.dto;

/**
 *
 * @author UNAM
 */
public class NewPassword {
    
    private String username;
    private String newpassword;
    private String confirmpassword;

    public NewPassword() {
    }

    public NewPassword(String username, String newpassword, String confirmpassword) {
        this.username = username;
        this.newpassword = newpassword;
        this.confirmpassword = confirmpassword;
    }
    
    public NewPassword(NewPassword np) {
        this.username = np.username;
        this.newpassword = np.newpassword;
        this.confirmpassword = np.confirmpassword;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    
    public boolean checkPassSymetic(){
    
        return this.newpassword.equals(this.confirmpassword);
    }
    
}
