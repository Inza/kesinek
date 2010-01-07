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
 * IsInPurchaseOrder entity class
 *
 * - reviewed: 6. 1. 2010, 7:55
 * - finalized: 6. 1. 2010, 7:55
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "isInPurchaseOrder", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "IsInPurchaseOrder.findAll", query = "SELECT i FROM IsInPurchaseOrder i"),
    @NamedQuery(name = "IsInPurchaseOrder.findByIsInPurchaseOrderID", query = "SELECT i FROM IsInPurchaseOrder i WHERE i.isInPurchaseOrderID = :isInPurchaseOrderID")})
public class IsInPurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "isInPurchaseOrderID", nullable = false)
    private Integer isInPurchaseOrderID;
    @JoinColumn(name = "purchaseOrderID", referencedColumnName = "purchaseOrderID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PurchaseOrder purchaseOrderID;
    @JoinColumn(name = "productItemID", referencedColumnName = "productItemID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductItem productItemID;

    public IsInPurchaseOrder() {
    }

    public IsInPurchaseOrder(Integer isInPurchaseOrderID) {
        this.isInPurchaseOrderID = isInPurchaseOrderID;
    }

    public Integer getIsInPurchaseOrderID() {
        return isInPurchaseOrderID;
    }

    public void setIsInPurchaseOrderID(Integer isInPurchaseOrderID) {
        this.isInPurchaseOrderID = isInPurchaseOrderID;
    }

    public PurchaseOrder getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(PurchaseOrder purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
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
        hash += (isInPurchaseOrderID != null ? isInPurchaseOrderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IsInPurchaseOrder)) {
            return false;
        }
        IsInPurchaseOrder other = (IsInPurchaseOrder) object;
        if ((this.isInPurchaseOrderID == null && other.isInPurchaseOrderID != null) || (this.isInPurchaseOrderID != null && !this.isInPurchaseOrderID.equals(other.isInPurchaseOrderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.IsInPurchaseOrder[isInPurchaseOrderID=" + isInPurchaseOrderID + "]";
    }

}
