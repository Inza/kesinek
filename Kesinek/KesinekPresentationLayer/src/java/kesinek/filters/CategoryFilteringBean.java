/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kesinek.filters;

import kesinek.businesslayer.entities.Category;

/**
 *
 * @author Admin
 */
public class CategoryFilteringBean {
    // Init

    private String filterNameValue = "";
    private String filterDescriptionValue = "";

    // Actions
    public boolean filterNames(Object current) {
        Category currentName = (Category) current;
        if (filterNameValue.length() == 0) {
            return true;
        }
        if (currentName.getName().toLowerCase().contains(filterNameValue.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean filterDescriptions(Object current) {
        Category currentDescription = (Category) current;
        if (filterDescriptionValue.length() == 0) {
            return true;
        }
        if (currentDescription.getDescription().toLowerCase().contains(filterDescriptionValue.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    // Getters
    public String getFilterDescriptionValue() {
        return filterDescriptionValue;
    }

    public String getFilterNameValue() {
        return filterNameValue;
    }

    // Setters
    public void setFilterDescriptionValue(String filterDescriptionValue) {
        this.filterDescriptionValue = filterDescriptionValue;
    }

    public void setFilterNameValue(String filterNameValue) {
        this.filterNameValue = filterNameValue;
    }
}
