/*
 * This file describes User management session bean class.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Stateless;
import kesinek.businesslayer.entities.Role;
import kesinek.businesslayer.entities.User;

/**
 * Handles BL for User and Role entity classes
 *
 * This bean will perform basic I/O operations with users (EC User) in the system
 *
 * Every user could have many roles (EC Role), which are also managed by this bean
 *
 * @author Tomáš Jukin
 */
@Stateless
public class UserBean implements UserBeanLocal {

    /**
     * Performs basic CUD operations with users
     * 
     * For create operation a new User instance with all required fields should be passes
     * For update operation only fields which required to be changed shoul be set in passed User instance
     * For delete operation only User's id should be filled
     * 
     * @param user
     */
    public void saveUser(User user) {
    }

    public Collection<User> getUsersByName(String name) {
        return null;
    }

    public Collection<User> getAllUsers() {
        return null;
    }

    public void addUserToRole(User user, Role role) {
    }

    public void removeUserFromRole(User user, Role role) {
    }

    public Collection<Role> getAllRoles() {
        return null;
    }

    public Collection<Role> getRolesByName(String name) {
        return null;
    }
 
}
