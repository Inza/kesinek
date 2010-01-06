package kesinek.businesslayer.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Wishlist entity class
 *
 * - reviewed: 4. 1. 2010, 12:30
 * - finalized: 4. 1. 2010, 12:32
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "Wishlist", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "Wishlist.findAll", query = "SELECT w FROM Wishlist w"),
    @NamedQuery(name = "Wishlist.findByWishlistID", query = "SELECT w FROM Wishlist w WHERE w.wishlistID = :wishlistID"),
    @NamedQuery(name = "Wishlist.findByUserID", query = "SELECT w FROM Wishlist w WHERE w.userID = :userID")})
public class Wishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wishlistID", nullable = false)
    private Integer wishlistID;
    @Basic(optional = false)
    @Column(name = "userID", nullable = false)
    private int userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wishlistID", fetch = FetchType.LAZY)
    private Collection<IsInWishlist> isInWishlistCollection;

    public Wishlist() {
    }

    public Wishlist(Integer wishlistID) {
        this.wishlistID = wishlistID;
    }

    public Wishlist(Integer wishlistID, int userID) {
        this.wishlistID = wishlistID;
        this.userID = userID;
    }

    public Integer getWishlistID() {
        return wishlistID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param wishlistID 
     * @return Wishlist
     */
    public Wishlist setWishlistID(Integer wishlistID) {
        this.wishlistID = wishlistID;
        return this;
    }

    public int getUserID() {
        return userID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param userID  
     * @return Wishlist
     */
    public Wishlist setUserID(int userID) {
        this.userID = userID;
        return this;
    }

    public Collection<IsInWishlist> getIsInWishlistCollection() {
        return isInWishlistCollection;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param isInWishlistCollection  
     * @return Wishlist
     */
    public Wishlist setIsInWishlistCollection(Collection<IsInWishlist> isInWishlistCollection) {
        this.isInWishlistCollection = isInWishlistCollection;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wishlistID != null ? wishlistID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wishlist)) {
            return false;
        }
        Wishlist other = (Wishlist) object;
        if ((this.wishlistID == null && other.wishlistID != null) || (this.wishlistID != null && !this.wishlistID.equals(other.wishlistID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.Wishlist[wishlistID=" + wishlistID + "]";
    }

}
