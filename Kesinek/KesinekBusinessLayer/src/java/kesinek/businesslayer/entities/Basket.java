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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Basket entity class
 *
 * - reviewed: 4. 1. 2010, 13:17
 * - finalized: 4. 1. 2010, 13:17
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "Basket", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "Basket.update", query = "UPDATE Basket SET userID = ':userID' WHERE basketID = ':basketID'"),
    @NamedQuery(name = "Basket.findAll", query = "SELECT b FROM Basket b"),
    @NamedQuery(name = "Basket.findByBasketID", query = "SELECT b FROM Basket b WHERE b.basketID = :basketID")})
public class Basket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "basketID", nullable = false)
    private Integer basketID;
    @JoinColumn(name = "userID", referencedColumnName = "userID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "basketID", fetch = FetchType.LAZY)
    private Collection<IsInBasket> isInBasketCollection;

    public Basket() {
    }

    public Basket(Integer basketID) {
        this.basketID = basketID;
    }

    public Integer getBasketID() {
        return basketID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param basketID
     * @return Basket
     */
    public Basket setBasketID(Integer basketID) {
        this.basketID = basketID;
        return this;
    }

    public User getUserID() {
        return userID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param userID 
     * @return Basket
     */
    public Basket setUserID(User userID) {
        this.userID = userID;
        return this;
    }

    public Collection<IsInBasket> getIsInBasketCollection() {
        return isInBasketCollection;
    }

    public Basket setIsInBasketCollection(Collection<IsInBasket> isInBasketCollection) {
        this.isInBasketCollection = isInBasketCollection;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (basketID != null ? basketID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Basket)) {
            return false;
        }
        Basket other = (Basket) object;
        if ((this.basketID == null && other.basketID != null) || (this.basketID != null && !this.basketID.equals(other.basketID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.Basket[basketID=" + basketID + "]";
    }

}
