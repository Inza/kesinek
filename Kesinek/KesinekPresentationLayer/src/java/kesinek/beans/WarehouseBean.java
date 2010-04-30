/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kesinek.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import kesinek.businesslayer.entities.Warehouse;
import kesinek.businesslayer.session.ProductBeanLocal;

/**
 *
 * @author Admin
 */
public class WarehouseBean {

    @EJB
    private ProductBeanLocal warehouseBean;
    private Warehouse warehouse = new Warehouse();
    private int id;
    private String currentNameFilterValue;

    // Actions
    public void newWarehouse() {
        warehouseBean.addWarehouse(warehouse);
        FacesContext.getCurrentInstance().addMessage("newWarehouse", new FacesMessage("Warehouse " + warehouse.getDescription() + " created."));
        this.warehouse = new Warehouse();
    }

    public void editWarehouseSetup() {
        warehouse = warehouseBean.findWarehouseByID(id);
    }

    public void editWarehouse() {
        warehouseBean.updateWarehouse(warehouse);
        FacesContext.getCurrentInstance().addMessage("newWarehouse", new FacesMessage("Warehouse " + warehouse.getDescription() + " edited."));
        this.warehouse = new Warehouse();
    }

    public void deleteWarehouse() {
        warehouse = warehouseBean.findWarehouseByID(id);
        warehouseBean.removeWarehouse(warehouse);
        FacesContext.getCurrentInstance().addMessage("warehouseList", new FacesMessage("Warehouse " + warehouse.getDescription() + " deleted."));
        this.warehouse = new Warehouse();
    }
    // Getters

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public List<Warehouse> getAllWarehouse() {
        return warehouseBean.findAllWarehouses();
    }

    public int getId() {
        return id;
    }

    public String getCurrentNameFilterValue() {
        return currentNameFilterValue;
    }

    // Setters
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrentNameFilterValue(String currentNameFilterValue) {
        this.currentNameFilterValue = currentNameFilterValue;
    }
}
