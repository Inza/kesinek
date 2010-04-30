/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kesinek.facesBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.session.UserBeanLocal;

/**
 *
 * @author Tomas
 */

public class UserFacesBean {

    @EJB
    UserBeanLocal userBean;
    User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String logout() {
        ((HttpSession) FacesContext.getCurrentInstance().
                getExternalContext().getSession(false)).invalidate();
        return "home";
    }

    public String register() {
        userBean.addUser(user);
        userBean.addUserToRole(user, "user");
        user = new User();
        FacesContext.getCurrentInstance().addMessage("userRegistered", new FacesMessage("User was registered." ));
        return "home";
    }
}
