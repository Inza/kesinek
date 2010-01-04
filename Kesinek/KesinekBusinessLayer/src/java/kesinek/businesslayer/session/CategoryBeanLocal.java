/*
 * This file describes Category management session bean local interface.
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Local;
import kesinek.businesslayer.entities.Category;

/**
 * Handles BL for Category entity class
 *
 * This bean will perform basic I/O operations with categories (EC Category) in the system
 *
 * @author Tomáš Jukin
 */
@Local
public interface CategoryBeanLocal {

    /**
     * Will add new category to the system
     *
     * @param category
     */
    void addCategory(Category category);

    /**
     * Will remove a category from the system
     *
     * @param category
     */
    void removeCategory(Category category);

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
     * Will update a category in the system
     *
     * @param category
     */
    public void updateCategory(Category category);
    
}
