/*
 * This file describes Category management session bean local interface.
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Local;
import kesinek.businesslayer.entities.Category;
import kesinek.businesslayer.entities.CategoryAttribute;
import kesinek.businesslayer.entities.ProductAttribute;

/**
 * Handles BL for Category entity class
 *
 * This bean will perform basic I/O operations with categories (EC Category) in the system
 *
 * - reviewed: 4. 1. 2010, 12:33
 * - finalized: 4. 1. 2010, 12:33
 *
 * @author Tomáš Jukin
 */
@Local
public interface CategoryBeanLocal {

    /**
     * Will add new category attribute to the system
     * 
     * @param attribute
     */
    public void addCategoryAttribute(CategoryAttribute attribute);

    /**
     * Will add new category attribute to the given category
     *
     * @param category
     * @param attribute
     */
    public void addCategoryAttribute(Category category, CategoryAttribute attribute);

    /**
     * Will remove a category attribute from given category
     *
     * @param category
     * @param attribute
     */
    public void removeCategoryAttribute(Category category, CategoryAttribute attribute);

    /**
     * Will remove a category attribute from the system
     *
     * @param attribute
     */
    public void removeCategoryAttribute(CategoryAttribute attribute);

    /**
     * Will add new category to the system
     *
     * @param category
     */
    public void addCategory(Category category);

    /**
     * Will remove a category from the system
     *
     * @param category
     */
    public void removeCategory(Category category);

    /**
     * Will find all a categories in the system
     *
     * @return List<Category>
     */
    public List<Category> findAllCategory();

    /**
     * Will find a category in the system
     *
     * @param id
     * @return Category
     */
    public Category findCategoryByID(int id);

    /**
     * Will find a category in the system
     *
     * @param id
     * @return CategoryAttribute
     */
    public CategoryAttribute findCategoryAttributeByID(int id);

    /**
     * Will update a category in the system
     *
     * @param category
     */
    public void updateCategory(Category category);

    /**
     * Will find all attributes of given category
     *
     * @param categoryId
     * @return List<CategoryAttribute>
     */
    public List<CategoryAttribute> findAllCategoryAttributes(int categoryId);

    /**
     * Will find all product attributes of given category attribute
     *
     * @param categoryAttributeId
     * @return List<ProductAttribute>
     */
    public List<ProductAttribute> findAllProductAttributes(int categoryAttributeId);
    
}
