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
 * CategoryAttribute entity class
 *
 * - reviewed: 4. 1. 2010, 13:30
 * - finalized: 4. 1. 2010, 13:32
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "CategoryAttribute", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "CategoryAttribute.update", query = "UPDATE CategoryAttribute c SET c.name = ':name', c.description = ':description', c.categoryID = ':categoryID' WHERE c.categoryAttributeID = ':categoryAttributeID'"),
    @NamedQuery(name = "CategoryAttribute.findAll", query = "SELECT c FROM CategoryAttribute c"),
    @NamedQuery(name = "CategoryAttribute.findByDescription", query = "SELECT c FROM CategoryAttribute c WHERE c.description = :description"),
    @NamedQuery(name = "CategoryAttribute.findByName", query = "SELECT c FROM CategoryAttribute c WHERE c.name = :name"),
    @NamedQuery(name = "CategoryAttribute.findByCategoryAttributeID", query = "SELECT c FROM CategoryAttribute c WHERE c.categoryAttributeID = :categoryAttributeID")})
public class CategoryAttribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "description", length = 50)
    private String description;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categoryAttributeID", nullable = false)
    private Integer categoryAttributeID;
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category categoryID;

    public CategoryAttribute() {
    }

    public CategoryAttribute(Integer categoryAttributeID) {
        this.categoryAttributeID = categoryAttributeID;
    }

    public CategoryAttribute(Integer categoryAttributeID, String name) {
        this.categoryAttributeID = categoryAttributeID;
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

    public Integer getCategoryAttributeID() {
        return categoryAttributeID;
    }

    public void setCategoryAttributeID(Integer categoryAttributeID) {
        this.categoryAttributeID = categoryAttributeID;
    }

    public Category getCategoryID() {
        return categoryID;
    }
    
    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryAttributeID != null ? categoryAttributeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryAttribute)) {
            return false;
        }
        CategoryAttribute other = (CategoryAttribute) object;
        if ((this.categoryAttributeID == null && other.categoryAttributeID != null) || (this.categoryAttributeID != null && !this.categoryAttributeID.equals(other.categoryAttributeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.CategoryAttribute[categoryAttributeID=" + categoryAttributeID + "]";
    }

}
