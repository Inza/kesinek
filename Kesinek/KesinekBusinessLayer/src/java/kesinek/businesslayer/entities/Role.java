package kesinek.businesslayer.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Role entity class
 *
 * - reviewed: 4. 1. 2010, 12:30
 * - finalized: 4. 1. 2010, 12:32
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "Role", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name"),
    @NamedQuery(name = "Role.findByRoleID", query = "SELECT r FROM Role r WHERE r.roleID = :roleID"),
    @NamedQuery(name = "Role.findByUsername", query = "SELECT r FROM Role r WHERE r.username = :username")})
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roleID", nullable = false)
    private Integer roleID;
    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    public Role() {
    }

    public Role(Integer roleID) {
        this.roleID = roleID;
    }

    public Role(Integer roleID, String name, String username) {
        this.roleID = roleID;
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.Role[roleID=" + roleID + "]";
    }

}
