/*
 * This file describes User management session bean local interface.
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Local;
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
@Local
public interface UserBeanLocal {

    /**
     * Will an user to the system
     *
     * @param user
     */
    public void addUser(User user);

    /**
     * Will remove desired user from the system
     *
     * @param user
     */
    public void removeUser(User user);

    /**
     * Will update desired user in the system
     *
     * @param user
     */
    public void updateUser(User user);

    /**
     * Will load all users in the system
     *
     * @return Collection<User>
     */
    public Collection<User> getAllUsers();

    /**
     * Will find an user in the system
     *
     * @param id
     * @return User
     */
    public User findUserByID(int id);

    /**
     * Will find an user in the system by it's name
     *
     * @param name
     * @return User
     */
    public User findUserByName(String name);

    /**
     * Will add desired user to desired role
     *
     * @param user
     * @param role
     */
    public void addUserToRole(User user, String role);

    /**
     * Will remove desired user from desired role
     *
     * @param user
     * @param role
     */
    public void removeUserFromRole(User user, String role);

    /**
     * Will load all roles in the system
     *
     * @return Collection<User>
     */
    public Collection<Role> getAllRoles();
}
