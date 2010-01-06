/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kesinek.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import kesinek.businesslayer.entities.Category;
import kesinek.businesslayer.session.CategoryBeanLocal;

/**
 *
 * @author Admin
 */
public class CategoryBean {
    // Init
    @EJB
    private CategoryBeanLocal categoryBean;
    private Category category = new Category();
    private int id;

    // Actions
    public void newCategory() {
        categoryBean.addCategory(category);
        FacesContext.getCurrentInstance().addMessage("newCategory", new FacesMessage("Category " + category.getName() + " created." ));
        this.category = new Category();
    }

    public void editCategorySetup() {
        category = categoryBean.findCategoryByID(id);
    }

    public void editCategory() {
        System.out.println(category.getCategoryID() +" " + category.getDescription()  + " " + category.getName());
        categoryBean.updateCategory(category);
        FacesContext.getCurrentInstance().addMessage("newCategory", new FacesMessage("Category " + category.getName() + " edited." ));
        this.category = new Category();
    }

    public void deleteCategory() {
        category = categoryBean.findCategoryByID(id);
        categoryBean.removeCategory(category);
        FacesContext.getCurrentInstance().addMessage("categoryList", new FacesMessage("Category " + category.getName() + " deleted." ));
        this.category = new Category();
    }
    // Getters
    public Category getCategory() {
        return category;
    }

    public List<Category> getAllCategory() {
        return categoryBean.findAllCategory();
    }

    public int getId() {
        return id;
    }

    // Setters
    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }


}
