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
 * Manufacturer entity class
 *
 * - reviewed: 4. 1. 2010, 12:30
 * - finalized: 4. 1. 2010, 12:32
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "Manufacturer", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "Manufacturer.update", query = "UPDATE Manufacturer m SET m.name = :name WHERE m.manufacturerID = :manufacturerID"),
    @NamedQuery(name = "Manufacturer.findAll", query = "SELECT m FROM Manufacturer m"),
    @NamedQuery(name = "Manufacturer.findByName", query = "SELECT m FROM Manufacturer m WHERE m.name = :name"),
    @NamedQuery(name = "Manufacturer.findByManufacturerID", query = "SELECT m FROM Manufacturer m WHERE m.manufacturerID = :manufacturerID")})
public class Manufacturer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manufacturerID", nullable = false)
    private Integer manufacturerID;

    public Manufacturer() {
    }

    public Manufacturer(Integer manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public Manufacturer(Integer manufacturerID, String name) {
        this.manufacturerID = manufacturerID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(Integer manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manufacturerID != null ? manufacturerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manufacturer)) {
            return false;
        }
        Manufacturer other = (Manufacturer) object;
        if ((this.manufacturerID == null && other.manufacturerID != null) || (this.manufacturerID != null && !this.manufacturerID.equals(other.manufacturerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.Manufacturer[manufacturerID=" + manufacturerID + "]";
    }

}
