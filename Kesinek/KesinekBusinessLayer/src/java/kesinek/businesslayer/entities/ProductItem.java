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
 * ProductItem entity class
 *
 * - reviewed: 4. 1. 2010, 12:30
 * - finalized: 4. 1. 2010, 12:32
 *
 * @author Tomáš Jukin
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productItemID", fetch = FetchType.LAZY)
    private Collection<IsInFavorite> isInFavoriteCollection;

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

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param amount   
     * @return ProductItem
     */
    public ProductItem setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getName() {
        return name;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param name    
     * @return ProductItem
     */
    public ProductItem setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param price    
     * @return ProductItem
     */
    public ProductItem setPrice(int price) {
        this.price = price;
        return this;
    }

    public Integer getProductItemID() {
        return productItemID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param productItemID    
     * @return ProductItem
     */
    public ProductItem setProductItemID(Integer productItemID) {
        this.productItemID = productItemID;
        return this;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param manufacturerID 
     * @return ProductItem
     */
    public ProductItem setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
        return this;
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param warehouseID
     * @return ProductItem
     */
    public ProductItem setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
        return this;
    }

    public Collection<IsInPurchaseOrder> getIsInPurchaseOrderCollection() {
        return isInPurchaseOrderCollection;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param isInPurchaseOrderCollection
     * @return ProductItem
     */
    public ProductItem setIsInPurchaseOrderCollection(Collection<IsInPurchaseOrder> isInPurchaseOrderCollection) {
        this.isInPurchaseOrderCollection = isInPurchaseOrderCollection;
        return this;
    }

    public Collection<IsInBasket> getIsInBasketCollection() {
        return isInBasketCollection;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param isInBasketCollection
     * @return ProductItem
     */
    public ProductItem setIsInBasketCollection(Collection<IsInBasket> isInBasketCollection) {
        this.isInBasketCollection = isInBasketCollection;
        return this;
    }

    public Collection<IsInFavorite> getIsInFavoriteCollection() {
        return isInFavoriteCollection;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param isInFavoriteCollection
     * @return ProductItem
     */
    public ProductItem setIsInFavoriteCollection(Collection<IsInFavorite> isInFavoriteCollection) {
        this.isInFavoriteCollection = isInFavoriteCollection;
        return this;
    }

    public Collection<IsInWishlist> getIsInWishlistCollection() {
        return isInWishlistCollection;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param isInWishlistCollection 
     * @return ProductItem
     */
    public ProductItem setIsInWishlistCollection(Collection<IsInWishlist> isInWishlistCollection) {
        this.isInWishlistCollection = isInWishlistCollection;
        return this;
    }

    public Collection<IsInCategory> getIsInCategoryCollection() {
        return isInCategoryCollection;
    }

    /**
     * NOTE: Provides fluent interface (means that you can chain setter calling)
     *
     * @param isInCategoryCollection    
     * @return ProductItem
     */
    public ProductItem setIsInCategoryCollection(Collection<IsInCategory> isInCategoryCollection) {
        this.isInCategoryCollection = isInCategoryCollection;
        return this;
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
