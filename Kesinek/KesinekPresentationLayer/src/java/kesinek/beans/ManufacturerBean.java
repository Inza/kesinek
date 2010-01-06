/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kesinek.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import kesinek.businesslayer.entities.Manufacturer;
import kesinek.businesslayer.session.ProductBeanLocal;

/**
 *
 * @author Admin
 */
public class ManufacturerBean {
    // Init

    @EJB
    private ProductBeanLocal manufacturerBean;
    private Manufacturer manufacturer = new Manufacturer();
    private int id;
    private String currentNameFilterValue;

    // Actions
    public void newManufacturer() {
        manufacturerBean.addManufacturer(manufacturer);
        FacesContext.getCurrentInstance().addMessage("newManufacturer", new FacesMessage("Manufacturer " + manufacturer.getName() + " created."));
        this.manufacturer = new Manufacturer();
    }

    public void editManufacturerSetup() {
        manufacturer = manufacturerBean.findManufacturerByID(id);
    }

    public void editManufacturer() {
        manufacturerBean.updateManufacturer(manufacturer);
        FacesContext.getCurrentInstance().addMessage("newManufacturer", new FacesMessage("Manufacturer " + manufacturer.getName() + " edited."));
        this.manufacturer = new Manufacturer();
    }

    public void deleteManufacturer() {
        manufacturer = manufacturerBean.findManufacturerByID(id);
        manufacturerBean.removeManufacturer(manufacturer);
        FacesContext.getCurrentInstance().addMessage("manufacturerList", new FacesMessage("Manufacturer " + manufacturer.getName() + " deleted."));
        this.manufacturer = new Manufacturer();
    }
    // Getters

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public List<Manufacturer> getAllManufacturer() {
        return manufacturerBean.findAllManufacturer();
    }

    public int getId() {
        return id;
    }

    public String getCurrentNameFilterValue() {
        return currentNameFilterValue;
    }



    // Setters
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrentNameFilterValue(String currentNameFilterValue) {
        this.currentNameFilterValue = currentNameFilterValue;
    }
    
}
