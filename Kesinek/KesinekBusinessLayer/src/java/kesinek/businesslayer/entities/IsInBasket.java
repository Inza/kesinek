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
 * Basket - ProductItem relation entity class
 *
 * - reviewed: 4. 1. 2010, 13:17
 * - finalized: 4. 1. 2010, 13:17
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "isInBasket", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "IsInBasket.findAll", query = "SELECT i FROM IsInBasket i"),
    @NamedQuery(name = "IsInBasket.findByIsInBasketID", query = "SELECT i FROM IsInBasket i WHERE i.isInBasketID = :isInBasketID")})
public class IsInBasket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "isInBasketID", nullable = false)
    private Integer isInBasketID;
    @JoinColumn(name = "basketID", referencedColumnName = "basketID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Basket basketID;
    @JoinColumn(name = "productItemID", referencedColumnName = "productItemID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductItem productItemID;

    public IsInBasket() {
    }

    public IsInBasket(Integer isInBasketID) {
        this.isInBasketID = isInBasketID;
    }

    public Integer getIsInBasketID() {
        return isInBasketID;
    }

    public void setIsInBasketID(Integer isInBasketID) {
        this.isInBasketID = isInBasketID;
    }

    public Basket getBasketID() {
        return basketID;
    }

    public void setBasketID(Basket basketID) {
        this.basketID = basketID;
    }

    public ProductItem getProductItemID() {
        return productItemID;
    }

    public void setProductItemID(ProductItem productItemID) {
        this.productItemID = productItemID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isInBasketID != null ? isInBasketID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IsInBasket)) {
            return false;
        }
        IsInBasket other = (IsInBasket) object;
        if ((this.isInBasketID == null && other.isInBasketID != null) || (this.isInBasketID != null && !this.isInBasketID.equals(other.isInBasketID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.IsInBasket[isInBasketID=" + isInBasketID + "]";
    }

}
