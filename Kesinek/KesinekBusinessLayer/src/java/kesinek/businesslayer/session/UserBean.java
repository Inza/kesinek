/*
 * This file describes User management session bean class.
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.Role;
import kesinek.businesslayer.entities.User;

@Stateless
public class UserBean implements UserBeanLocal {

    @PersistenceContext
    EntityManager em;

    public void addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeUser(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection<User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public User findUserByID(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addUserToRole(User user, Role role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeUserFromRole(User user, Role role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addRole(Role role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeRole(Role role) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection<Role> getAllRoles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateUser(User user) {
       /* em.createNamedQuery("User.update")
                .setParameter("name", category.getName())
                .setParameter("description", category.getDescription())
                .setParameter("categoryID", category.getCategoryID())
        .executeUpdate();
        em.merge(category);*/
    }


 
}
