/*
 * This file describes Category management session bean class.
 *
 * @author Tomáš Jukin
 */
package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.Category;

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
        em.createNamedQuery("Employee.update")
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
}
