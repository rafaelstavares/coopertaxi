/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Usuario;

/**
 *
 * @author COOPERATIVA
 */
public class UserSession {

    private static UserSession instance;

    private Usuario user;

    private String userName;

    private UserSession() {
    }

    public static UserSession getInstace() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void cleanUserSession() {
        userName = "";// or null
    }

    @Override
    public String toString() {
        return "UserSession{" + "userName=" + userName + '}';
    }

}
