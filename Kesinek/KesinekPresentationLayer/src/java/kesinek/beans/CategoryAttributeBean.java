/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kesinek.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import kesinek.businesslayer.entities.Category;
import kesinek.businesslayer.entities.CategoryAttribute;
import kesinek.businesslayer.session.CategoryBeanLocal;

/**
 *
 * @author Admin
 */
public class CategoryAttributeBean {

    @EJB
    private CategoryBeanLocal categoryBean;
    private CategoryAttribute categoryAttribute = new CategoryAttribute();
    private ArrayList<SelectItem> categories = new ArrayList<SelectItem>();
    private int id;
    private int categoryid;

    // Actions
    public void newCategoryAttribute() {
        categoryAttribute.setCategoryID(categoryBean.findCategoryByID(categoryid));
        categoryBean.addCategoryAttribute(categoryAttribute);
        FacesContext.getCurrentInstance().addMessage("newCategoryAttribute", new FacesMessage("CategoryAttribute " + categoryAttribute.getName() + " created."));
        this.categoryAttribute = new CategoryAttribute();
    }

    public void editCategoryAttributeSetup() {
        categoryAttribute = categoryBean.findCategoryAttributeByID(id);
    }

    public void editCategoryAttribute() {
        categoryAttribute.setCategoryID(categoryBean.findCategoryByID(categoryid));
//        System.out.println(categoryAttribute.getCategoryID());
//        System.out.println(categoryAttribute.getCategoryAttributeID());
//        System.out.println(categoryAttribute.getDescription());
//        System.out.println(categoryAttribute.getName());
        categoryBean.updateCategoryAttribute(categoryAttribute);
        FacesContext.getCurrentInstance().addMessage("newCategoryAttribute", new FacesMessage("CategoryAttribute " + categoryAttribute.getName() + " edited."));
        this.categoryAttribute = new CategoryAttribute();
    }

    public void deleteCategoryAttribute() {
        categoryAttribute = categoryBean.findCategoryAttributeByID(id);
        categoryBean.removeCategoryAttribute(categoryAttribute);
        FacesContext.getCurrentInstance().addMessage("categoryAttributeList", new FacesMessage("CategoryAttribute " + categoryAttribute.getName() + " deleted."));
        this.categoryAttribute = new CategoryAttribute();
    }
    // Getters

    public CategoryAttribute getCategoryAttribute() {
        return categoryAttribute;
    }

    public List<CategoryAttribute> getAllCategoryAttribute() {
        return categoryBean.findAllCategoryAttributes();
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

    public int getId() {
        return id;
    }

    public int getCategoryid() {
        return categoryid;
    }

    // Setters
    public void setCategoryAttribute(CategoryAttribute categoryAttribute) {
        this.categoryAttribute = categoryAttribute;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
}
