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
 * Category entity class
 *
 * - reviewed: 4. 1. 2010, 12:30
 * - finalized: 4. 1. 2010, 12:32
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "Category", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "Category.findAllAttributes", query = "SELECT c FROM CategoryAttribute c WHERE c.categoryID = :categoryID"),
    @NamedQuery(name = "Category.update", query = "UPDATE Category c SET c.name = ':name', c.description = ':description' WHERE c.categoryID = ':categoryID'"),
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByDescription", query = "SELECT c FROM Category c WHERE c.description = :description"),
    @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name"),
    @NamedQuery(name = "Category.findByCategoryID", query = "SELECT c FROM Category c WHERE c.categoryID = :categoryID")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "description", length = 50)
    private String description;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categoryID", nullable = false)
    private Integer categoryID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryID", fetch = FetchType.LAZY)
    private Collection<CategoryAttribute> categoryAttributeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryID", fetch = FetchType.LAZY)
    private Collection<IsInCategory> isInCategoryCollection;

    public Category() {
    }

    public Category(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Category(Integer categoryID, String name) {
        this.categoryID = categoryID;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Collection<CategoryAttribute> getCategoryAttributeCollection() {
        return categoryAttributeCollection;
    }

    public void setCategoryAttributeCollection(Collection<CategoryAttribute> categoryAttributeCollection) {
        this.categoryAttributeCollection = categoryAttributeCollection;
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
        hash += (categoryID != null ? categoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryID == null && other.categoryID != null) || (this.categoryID != null && !this.categoryID.equals(other.categoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.Category[categoryID=" + categoryID + "]";
    }

}
