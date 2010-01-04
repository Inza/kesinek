/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
 *
 * @author inza
 */
@Entity
@Table(name = "ProductItem", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "ProductItem.findAll", query = "SELECT p FROM ProductItem p"),
    @NamedQuery(name = "ProductItem.findByAmount", query = "SELECT p FROM ProductItem p WHERE p.amount = :amount"),
    @NamedQuery(name = "ProductItem.findByName", query = "SELECT p FROM ProductItem p WHERE p.name = :name"),
    @NamedQuery(name = "ProductItem.findByPrice", query = "SELECT p FROM ProductItem p WHERE p.price = :price"),
    @NamedQuery(name = "ProductItem.findByProductItemID", query = "SELECT p FROM ProductItem p WHERE p.productItemID = :productItemID"),
    @NamedQuery(name = "ProductItem.findByManufacturerID", query = "SELECT p FROM ProductItem p WHERE p.manufacturerID = :manufacturerID"),
    @NamedQuery(name = "ProductItem.findByWarehouseID", query = "SELECT p FROM ProductItem p WHERE p.warehouseID = :warehouseID")})
public class ProductItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "amount")
    private Integer amount;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(name = "price", nullable = false)
    private int price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productItemID", nullable = false)
    private Integer productItemID;
    @Basic(optional = false)
    @Column(name = "manufacturerID", nullable = false)
    private int manufacturerID;
    @Basic(optional = false)
    @Column(name = "warehouseID", nullable = false)
    private int warehouseID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productItemID", fetch = FetchType.LAZY)
    private Collection<IsInPurchaseOrder> isInPurchaseOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productItemID", fetch = FetchType.LAZY)
    private Collection<IsInBasket> isInBasketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productItemID", fetch = FetchType.LAZY)
    private Collection<IsInWishlist> isInWishlistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productItemID", fetch = FetchType.LAZY)
    private Collection<IsInCategory> isInCategoryCollection;

    public ProductItem() {
    }

    public ProductItem(Integer productItemID) {
        this.productItemID = productItemID;
    }

    public ProductItem(Integer productItemID, String name, int price, int manufacturerID, int warehouseID) {
        this.productItemID = productItemID;
        this.name = name;
        this.price = price;
        this.manufacturerID = manufacturerID;
        this.warehouseID = warehouseID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getProductItemID() {
        return productItemID;
    }

    public void setProductItemID(Integer productItemID) {
        this.productItemID = productItemID;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Collection<IsInPurchaseOrder> getIsInPurchaseOrderCollection() {
        return isInPurchaseOrderCollection;
    }

    public void setIsInPurchaseOrderCollection(Collection<IsInPurchaseOrder> isInPurchaseOrderCollection) {
        this.isInPurchaseOrderCollection = isInPurchaseOrderCollection;
    }

    public Collection<IsInBasket> getIsInBasketCollection() {
        return isInBasketCollection;
    }

    public void setIsInBasketCollection(Collection<IsInBasket> isInBasketCollection) {
        this.isInBasketCollection = isInBasketCollection;
    }

    public Collection<IsInWishlist> getIsInWishlistCollection() {
        return isInWishlistCollection;
    }

    public void setIsInWishlistCollection(Collection<IsInWishlist> isInWishlistCollection) {
        this.isInWishlistCollection = isInWishlistCollection;
    }

    public Collection<IsInCategory> getIsInCategoryCollection() {
        return isInCategoryCollection;
    }

    public void setIsInCategoryCollection(Collection<IsInCategory> isInCategoryCollection) {
        this.isInCategoryCollection = isInCategoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productItemID != null ? productItemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductItem)) {
            return false;
        }
        ProductItem other = (ProductItem) object;
        if ((this.productItemID == null && other.productItemID != null) || (this.productItemID != null && !this.productItemID.equals(other.productItemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.ProductItem[productItemID=" + productItemID + "]";
    }

}
