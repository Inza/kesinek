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
 * IsInCategory - Category and ProductItem relation entity class
 *
 * - reviewed: 4. 1. 2010, 13:17
 * - finalized: 4. 1. 2010, 13:17
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "isInCategory", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "IsInCategory.findAll", query = "SELECT i FROM IsInCategory i"),
    @NamedQuery(name = "IsInCategory.findByIsInCategoryID", query = "SELECT i FROM IsInCategory i WHERE i.isInCategoryID = :isInCategoryID")})
public class IsInCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "isInCategoryID", nullable = false)
    private Integer isInCategoryID;
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category categoryID;
    @JoinColumn(name = "productItemID", referencedColumnName = "productItemID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductItem productItemID;

    public IsInCategory() {
    }

    public IsInCategory(Integer isInCategoryID) {
        this.isInCategoryID = isInCategoryID;
    }

    public Integer getIsInCategoryID() {
        return isInCategoryID;
    }

    public void setIsInCategoryID(Integer isInCategoryID) {
        this.isInCategoryID = isInCategoryID;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
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
        hash += (isInCategoryID != null ? isInCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IsInCategory)) {
            return false;
        }
        IsInCategory other = (IsInCategory) object;
        if ((this.isInCategoryID == null && other.isInCategoryID != null) || (this.isInCategoryID != null && !this.isInCategoryID.equals(other.isInCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.IsInCategory[isInCategoryID=" + isInCategoryID + "]";
    }

}
