/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kesinek.filters;

import kesinek.businesslayer.entities.Warehouse;

/**
 *
 * @author Admin
 */
public class WarehouseFilteringBean {

    private String filterDescriptionValue = "";

    public boolean filterDescriptions(Object current) {
        Warehouse currentName = (Warehouse) current;
        if (filterDescriptionValue.length() == 0) {
            return true;
        }
        if (currentName.getDescription().toLowerCase().contains(filterDescriptionValue.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public WarehouseFilteringBean() {
    }

    public String getFilterDescriptionValue() {
        return filterDescriptionValue;
    }

    public void setFilterDescriptionValue(String filterValue) {
        this.filterDescriptionValue = filterValue;
    }
}
