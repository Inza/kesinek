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
        em.persist(user);
    }

    public void removeUser(User user) {
        user = em.merge(user);
        em.remove(user);
    }

    @SuppressWarnings("unchecked")
    public Collection<User> getAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    public User findUserByID(int id) {
        return em.getReference(User.class, id);
    }

    public void addUserToRole(User user, String role) {
        Role r = new Role();
        r.setName(role);
        r.setUsername(user.getUsername());
        em.persist(r);
    }

    public void removeUserFromRole(User user, String role) {
        Role r = new Role();
        r.setName(role);
        r.setUsername(user.getUsername());
        r = em.merge(r);
        em.remove(r);
    }

    @SuppressWarnings("unchecked")
    public Collection<Role> getAllRoles() {
        return em.createNamedQuery("Role.findAll").getResultList();
    }

    public void updateUser(User user) {
        em.createNamedQuery("User.update")
                .setParameter("address", user.getAddress())
                .setParameter("password", user.getPassword())
                .setParameter("userID", user.getUserID())
        .executeUpdate();
        em.merge(user);
    }

    public User findUserByName(String name) {
        return (User) em.createNamedQuery("User.findByUsername").getSingleResult();
    }
 
}
