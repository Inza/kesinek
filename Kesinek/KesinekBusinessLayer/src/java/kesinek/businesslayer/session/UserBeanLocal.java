/*
 * This file describes User management session bean local interface.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Local;
import kesinek.businesslayer.entities.Role;
import kesinek.businesslayer.entities.User;

/**
 * Handles BL for User and Role entity classes
 *
 * @author Tomáš Jukin
 */
@Local
public interface UserBeanLocal {

    void saveUser(User user);

    Collection<User> getUsersByName(String name);

    Collection<User> getAllUsers();

    void addUserToRole(User user, Role role);

    void removeUserFromRole(User user, Role role);

    Collection<Role> getAllRoles();

    Collection<Role> getRolesByName(String name);
}
