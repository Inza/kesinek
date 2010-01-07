package kesinek.businesslayer.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * IsInWishlist - Wishlist and ProductItem relation entity class
 *
 * - reviewed: 4. 1. 2010, 13:17
 * - finalized: 4. 1. 2010, 13:17
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "isInWishlist", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "IsInWishlist.findAll", query = "SELECT i FROM IsInWishlist i"),
    @NamedQuery(name = "IsInWishlist.findByIsInWishlistID", query = "SELECT i FROM IsInWishlist i WHERE i.isInWishlistID = :isInWishlistID")})
public class IsInWishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "isInWishlistID", nullable = false)
    private Integer isInWishlistID;
    @JoinColumn(name = "productItemID", referencedColumnName = "productItemID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductItem productItemID;
    @JoinColumn(name = "wishlistID", referencedColumnName = "wishlistID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Wishlist wishlistID;

    public IsInWishlist() {
    }

    public IsInWishlist(Integer isInWishlistID) {
        this.isInWishlistID = isInWishlistID;
    }

    public Integer getIsInWishlistID() {
        return isInWishlistID;
    }

    public void setIsInWishlistID(Integer isInWishlistID) {
        this.isInWishlistID = isInWishlistID;
    }

    public ProductItem getProductItemID() {
        return productItemID;
    }

    public void setProductItemID(ProductItem productItemID) {
        this.productItemID = productItemID;
    }

    public Wishlist getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(Wishlist wishlistID) {
        this.wishlistID = wishlistID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isInWishlistID != null ? isInWishlistID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IsInWishlist)) {
            return false;
        }
        IsInWishlist other = (IsInWishlist) object;
        if ((this.isInWishlistID == null && other.isInWishlistID != null) || (this.isInWishlistID != null && !this.isInWishlistID.equals(other.isInWishlistID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.IsInWishlist[isInWishlistID=" + isInWishlistID + "]";
    }

}
