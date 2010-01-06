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
 * isInFavorite entity class
 *
 * - reviewed: 6. 1. 2010, 7:55
 * - finalized: 6. 1. 2010, 7:55
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "isInFavorite", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "IsInFavorite.findAmount", query = "SELECT i.amount FROM IsInFavorite i WHERE i.productItemID = :productItemID AND i.favoriteID = :favoriteID"),
    @NamedQuery(name = "IsInFavorite.updateAmount", query = "UPDATE IsInFavorite i SET i.amount = :amount WHERE i.productItemID = :productItemID AND i.favoriteID = :favoriteID"),
    @NamedQuery(name = "IsInFavorite.findAll", query = "SELECT i FROM IsInFavorite i"),
    @NamedQuery(name = "IsInFavorite.findByIsInFavoriteID", query = "SELECT i FROM IsInFavorite i WHERE i.isInFavoriteID = :IsInFavoriteID")})
public class IsInFavorite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "isInFavoriteID", nullable = false)
    private Integer isInFavoriteID;
    @JoinColumn(name = "productItemID", referencedColumnName = "productItemID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductItem productItemID;
    @JoinColumn(name = "favoriteID", referencedColumnName = "favoriteID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Favorite favoriteID;
    @Basic(optional = false)
    @Column(name = "amount", nullable = false)
    private Integer amount;

    public IsInFavorite() {
    }

    public IsInFavorite(Integer isInFavoriteID) {
        this.isInFavoriteID = isInFavoriteID;
    }

    public Integer getIsInFavoriteID() {
        return isInFavoriteID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param isInFavoriteID 
     * @return IsInFavorite
     */
    public IsInFavorite setIsInFavoriteID(Integer isInFavoriteID) {
        this.isInFavoriteID = isInFavoriteID;
        return this;
    }

    public ProductItem getProductItemID() {
        return productItemID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param productItemID 
     * @return IsInFavorite
     */
    public IsInFavorite setProductItemID(ProductItem productItemID) {
        this.productItemID = productItemID;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param amount 
     * @return IsInFavorite
     */
    public IsInFavorite setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public Favorite getFavoriteID() {
        return favoriteID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param favoriteID 
     * @return IsInFavorite
     */
    public IsInFavorite setFavoriteID(Favorite favoriteID) {
        this.favoriteID = favoriteID;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isInFavoriteID != null ? isInFavoriteID.hashCode() : 0);
        hash += (amount != null ? amount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IsInFavorite)) {
            return false;
        }
        IsInFavorite other = (IsInFavorite) object;
        if ((this.isInFavoriteID == null && other.isInFavoriteID != null) || (this.isInFavoriteID != null && !this.isInFavoriteID.equals(other.isInFavoriteID))) {
            return false;
        }
        if ((this.amount == null && other.amount != null) || (this.amount != null && !this.amount.equals(other.isInFavoriteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.IsInFavorite[isInFavoriteID=" + isInFavoriteID + ", amount=" + amount + "]";
    }

}
