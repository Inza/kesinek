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
 * PurchaseOrder entity class
 *
 * - reviewed: 4. 1. 2010, 12:30
 * - finalized: 4. 1. 2010, 12:32
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "PurchaseOrder", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "PurchaseOrder.findAll", query = "SELECT p FROM PurchaseOrder p"),
    @NamedQuery(name = "PurchaseOrder.findByPurchaseOrderID", query = "SELECT p FROM PurchaseOrder p WHERE p.purchaseOrderID = :purchaseOrderID"),
    @NamedQuery(name = "PurchaseOrder.findByUserID", query = "SELECT p FROM PurchaseOrder p WHERE p.userID = :userID")})
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchaseOrderID", nullable = false)
    private Integer purchaseOrderID;
    @Basic(optional = false)
    @Column(name = "userID", nullable = false)
    private int userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderID", fetch = FetchType.LAZY)
    private Collection<IsInPurchaseOrder> isInPurchaseOrderCollection;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public PurchaseOrder(Integer purchaseOrderID, int userID) {
        this.purchaseOrderID = purchaseOrderID;
        this.userID = userID;
    }

    public Integer getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(Integer purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Collection<IsInPurchaseOrder> getIsInPurchaseOrderCollection() {
        return isInPurchaseOrderCollection;
    }

    public void setIsInPurchaseOrderCollection(Collection<IsInPurchaseOrder> isInPurchaseOrderCollection) {
        this.isInPurchaseOrderCollection = isInPurchaseOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderID != null ? purchaseOrderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.purchaseOrderID == null && other.purchaseOrderID != null) || (this.purchaseOrderID != null && !this.purchaseOrderID.equals(other.purchaseOrderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.PurchaseOrder[purchaseOrderID=" + purchaseOrderID + "]";
    }

}
