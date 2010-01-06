/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kesinek.filters;

import kesinek.businesslayer.entities.Manufacturer;

/**
 *
 * @author Admin
 */
public class ManufacturerFilteringBean {

    private String filterNameValue = "";

    public boolean filterNames(Object current) {
        Manufacturer currentName = (Manufacturer) current;
        if (filterNameValue.length() == 0) {
            return true;
        }
        if (currentName.getName().toLowerCase().contains(filterNameValue.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public ManufacturerFilteringBean() {
    }

    public String getFilterNameValue() {
        return filterNameValue;
    }

    public void setFilterNameValue(String filterValue) {
        this.filterNameValue = filterValue;
    }
}
