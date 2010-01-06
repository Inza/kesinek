/*
 * This file describes Category management session bean class.
 *
 * - reviewed: 4. 1. 2010, 12:34
 * - finalized: 4. 1. 2010, 12:34
 *
 * @author Tomáš Jukin
 */
package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.Category;
import kesinek.businesslayer.entities.CategoryAttribute;

@Stateless
public class CategoryBean implements CategoryBeanLocal {

    @PersistenceContext
    private EntityManager em;

    public void addCategory(Category category) {
        em.persist(category);
    }

    public void removeCategory(Category category) {
        category = em.merge(category);
        em.remove(category);
    }

    public void updateCategory(Category category) {
        em.createNamedQuery("Category.update")
                .setParameter("name", category.getName())
                .setParameter("description", category.getDescription())
                .setParameter("categoryID", category.getCategoryID())
        .executeUpdate();
        em.merge(category);
    }

    @SuppressWarnings("unchecked")
    public List<Category> findAllCategory() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    public Category findCategoryByID(int id) {
        return em.getReference(Category.class, id);
    }

    public void addCategoryAttribute(CategoryAttribute attribute) {
        em.persist(attribute);
    }

    public void addCategoryAttribute(Category category, CategoryAttribute attribute) {
        attribute.setCategoryID(category);
        em.persist(attribute);
    }

    public void removeCategoryAttribute(Category category, CategoryAttribute attribute) {
        attribute.setCategoryID(category);
        attribute = em.merge(attribute);
        em.remove(attribute);
    }

    public void removeCategoryAttribute(CategoryAttribute attribute) {
        attribute = em.merge(attribute);
        em.remove(attribute);
    }

    public void updateCategoryAttribute(CategoryAttribute attribute) {
        em.createNamedQuery("CategoryAttribute.update")
                .setParameter("name", attribute.getName())
                .setParameter("description", attribute.getDescription())
                .setParameter("categoryID", attribute.getCategoryID())
                .setParameter("categoryAttributeID", attribute.getCategoryAttributeID())
        .executeUpdate();
        em.merge(attribute);
    }

    @SuppressWarnings("unchecked")
    public List<CategoryAttribute> findAllCategoryAttributes(int categoryId) {
        return em.createNamedQuery("Category.findAllAttributes").setParameter("categoryID", categoryId).getResultList();
    }
}
