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
 * Favorite entity class
 *
 * - reviewed: 6. 1. 2010, 7:55
 * - finalized: 6. 1. 2010, 7:55
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "Favorite", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "Favorite.findAll", query = "SELECT f FROM Favorite f"),
    @NamedQuery(name = "Favorite.findByFavoritesID", query = "SELECT f FROM Favorite f WHERE f.favoritesID = :favoritesID"),
    @NamedQuery(name = "Favorite.findByFavoritesName", query = "SELECT f FROM Favorite f WHERE f.favoritesName = :favoritesName")})
public class Favorite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "favoritesID", nullable = false)
    private Integer favoritesID;
    @Basic(optional = false)
    @Column(name = "favoritesName", nullable = false, length = 50)
    private String favoritesName;

    public Favorite() {
    }

    public Favorite(Integer favoritesID) {
        this.favoritesID = favoritesID;
    }

    public Favorite(Integer favoritesID, String favoritesName) {
        this.favoritesID = favoritesID;
        this.favoritesName = favoritesName;
    }

    public Integer getFavoritesID() {
        return favoritesID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param favoritesID
     * @return Favorite
     */
    public Favorite setFavoritesID(Integer favoritesID) {
        this.favoritesID = favoritesID;
        return this;
    }

    public String getFavoritesName() {
        return favoritesName;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param favoritesName 
     * @return Favorite
     */
    public Favorite setFavoritesName(String favoritesName) {
        this.favoritesName = favoritesName;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favoritesID != null ? favoritesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favorite)) {
            return false;
        }
        Favorite other = (Favorite) object;
        if ((this.favoritesID == null && other.favoritesID != null) || (this.favoritesID != null && !this.favoritesID.equals(other.favoritesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.Favorite[favoritesID=" + favoritesID + "]";
    }

}
