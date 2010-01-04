/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
 *
 * @author inza
 */
@Entity
@Table(name = "ProductAttribute", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProductAttribute.findAll", query = "SELECT p FROM ProductAttribute p"),
    @NamedQuery(name = "ProductAttribute.findByAttributeValue", query = "SELECT p FROM ProductAttribute p WHERE p.attributeValue = :attributeValue"),
    @NamedQuery(name = "ProductAttribute.findByProductAttributeID", query = "SELECT p FROM ProductAttribute p WHERE p.productAttributeID = :productAttributeID"),
    @NamedQuery(name = "ProductAttribute.findByProductItemID", query = "SELECT p FROM ProductAttribute p WHERE p.productItemID = :productItemID"),
    @NamedQuery(name = "ProductAttribute.findByCategoryAttributeID", query = "SELECT p FROM ProductAttribute p WHERE p.categoryAttributeID = :categoryAttributeID")})
public class ProductAttribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "attributeValue", nullable = false, length = 50)
    private String attributeValue;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productAttributeID", nullable = false)
    private Integer productAttributeID;
    @Basic(optional = false)
    @Column(name = "productItemID", nullable = false)
    private int productItemID;
    @Basic(optional = false)
    @Column(name = "categoryAttributeID", nullable = false)
    private int categoryAttributeID;

    public ProductAttribute() {
    }

    public ProductAttribute(Integer productAttributeID) {
        this.productAttributeID = productAttributeID;
    }

    public ProductAttribute(Integer productAttributeID, String attributeValue, int productItemID, int categoryAttributeID) {
        this.productAttributeID = productAttributeID;
        this.attributeValue = attributeValue;
        this.productItemID = productItemID;
        this.categoryAttributeID = categoryAttributeID;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Integer getProductAttributeID() {
        return productAttributeID;
    }

    public void setProductAttributeID(Integer productAttributeID) {
        this.productAttributeID = productAttributeID;
    }

    public int getProductItemID() {
        return productItemID;
    }

    public void setProductItemID(int productItemID) {
        this.productItemID = productItemID;
    }

    public int getCategoryAttributeID() {
        return categoryAttributeID;
    }

    public void setCategoryAttributeID(int categoryAttributeID) {
        this.categoryAttributeID = categoryAttributeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productAttributeID != null ? productAttributeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductAttribute)) {
            return false;
        }
        ProductAttribute other = (ProductAttribute) object;
        if ((this.productAttributeID == null && other.productAttributeID != null) || (this.productAttributeID != null && !this.productAttributeID.equals(other.productAttributeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.ProductAttribute[productAttributeID=" + productAttributeID + "]";
    }

}
