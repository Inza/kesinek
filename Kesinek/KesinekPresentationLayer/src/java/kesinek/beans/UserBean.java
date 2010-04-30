/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kesinek.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.session.UserBeanLocal;

/**
 *
 * @author Admin
 */
public class UserBean {
    // Init

    @EJB
    private UserBeanLocal userBean;
    private User user = new User();
    private ArrayList<SelectItem> roles = new ArrayList<SelectItem>();
    private int id;

    // Actions
//    public void newUser() {
//        userBean.addUser(user);
//        FacesContext.getCurrentInstance().addMessage("newUser", new FacesMessage("User " + user.getUsername() + " created."));
//        this.user = new User();
//    }
    public void editUserSetup() {
        user = userBean.findUserByID(id);
    }

    public void editUser() {
        userBean.updateUser(user);
        FacesContext.getCurrentInstance().addMessage("newUser", new FacesMessage("User " + user.getUsername() + " edited."));
        this.user = new User();
    }

    public void deleteUser() {
        user = userBean.findUserByID(id);
        userBean.removeUser(user);
        FacesContext.getCurrentInstance().addMessage("userList", new FacesMessage("User " + user.getUsername() + " deleted."));
        this.user = new User();
    }
    // Getters

    public User getUser() {
        return user;
    }

    public List<User> getAllUser() {
        return (List<User>) userBean.getAllUsers();
    }

    public List<SelectItem> getAllRoles() {
        // todo
        return new ArrayList<SelectItem>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<SelectItem> getRoles() {
        return roles;
    }

    // Setters
    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoles(ArrayList<SelectItem> roles) {
        this.roles = roles;
    }
}
