/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kesinek.filters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import kesinek.businesslayer.entities.Category;
import kesinek.businesslayer.entities.CategoryAttribute;
import kesinek.businesslayer.session.CategoryBeanLocal;

/**
 *
 * @author Admin
 */
public class CategoryAttributeFilteringBean {

    @EJB
    private CategoryBeanLocal categoryBean;
    private String filterNameValue = "";
    private String filterDescriptionValue = "";
    private int filterCategoryValue = 0;
    private ArrayList<SelectItem> categories = new ArrayList<SelectItem>();

    public boolean filterNames(Object current) {
        CategoryAttribute currentName = (CategoryAttribute) current;
        if (filterNameValue.length() == 0) {
            return true;
        }
        if (currentName.getName().toLowerCase().contains(filterNameValue.toLowerCase())) {
            return true;
        } else {
            System.out.println("name");
            return false;
        }
    }

    public boolean filterDescriptions(Object current) {
        CategoryAttribute currentDescription = (CategoryAttribute) current;
        if (filterDescriptionValue.length() == 0) {
            return true;
        }
        if (currentDescription.getDescription().toLowerCase().contains(filterDescriptionValue.toLowerCase())) {
            return true;
        } else {
            System.out.println("desc");
            return false;
        }
    }

    public boolean filterCategories(Object current) {
        if (filterCategoryValue == 0) {
            getCategories();
            filterCategoryValue = new Integer(categories.get(0).getValue().toString());
        }
        CategoryAttribute currentCategory = (CategoryAttribute) current;
        if (currentCategory.getCategoryID().getCategoryID() == filterCategoryValue) {
            return true;
        } else {
            System.out.println(currentCategory.getCategoryID().getCategoryID() + "cate" + filterCategoryValue);
            return false;
        }
    }

    public ArrayList<SelectItem> getCategories() {
        categories.clear();
        List<Category> allCategory = categoryBean.findAllCategory();
        Iterator it = allCategory.iterator();
        while (it.hasNext()) {
            Category cat = (Category) it.next();
            SelectItem select = new SelectItem();
            select.setLabel(cat.getName());
            select.setValue(cat.getCategoryID());
            categories.add(select);
        }

        return categories;
    }

    public String getFilterDescriptionValue() {
        return filterDescriptionValue;
    }

    public String getFilterNameValue() {
        return filterNameValue;
    }

    public int getFilterCategoryValue() {
        return filterCategoryValue;
    }

    public void setFilterDescriptionValue(String filterDescriptionValue) {
        this.filterDescriptionValue = filterDescriptionValue;
    }

    public void setFilterNameValue(String filterNameValue) {
        this.filterNameValue = filterNameValue;
    }

    public void setFilterCategoryValue(int filterCategoryValue) {
        this.filterCategoryValue = filterCategoryValue;
    }
}
