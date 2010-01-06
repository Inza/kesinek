/*
 * This file describes Basket management session bean class.
 *
 * - reviewed: 4. 1. 2010, 13:17
 * - finalized: 4. 1. 2010, 13:17
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.IsInBasket;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.User;

@Stateless
public class BasketBean implements BasketBeanLocal {

    @PersistenceContext
    private EntityManager em;
    
    public void addProductToBasket(ProductItem product, Basket basket) {
        IsInBasket relation = new IsInBasket();
        relation.setBasketID(basket);
        relation.setProductItemID(product);
        em.persist(relation);
    }
    
    public void removeProductFromBasket(ProductItem product, Basket basket) {
        IsInBasket relation = new IsInBasket();
        relation.setBasketID(basket);
        relation.setProductItemID(product);
        relation = em.merge(relation);
        em.remove(relation);
    }

    public void addBasket(Basket basket) {
        em.persist(basket);
    }

    public void removeBasket(Basket basket) {
        basket = em.merge(basket);
        em.remove(basket);
    }

    @SuppressWarnings("unchecked")
    public List<Basket> findAllBasket() {
        return em.createNamedQuery("Basket.findAll").getResultList();
    }

    public Basket findBasketByID(int id) {
        return em.getReference(Basket.class, id);
    }

    public Basket findBasketByUser(User user) {
        return (Basket) em.createNamedQuery("Basket.findByUserID").setParameter("userID", user.getUserID()).getResultList();
    }

    public void updateBasket(Basket basket) {
        em.createNamedQuery("Basket.update")
                .setParameter("userID", basket.getUserID())
                .setParameter("basketID", basket.getBasketID())
        .executeUpdate();
        em.merge(basket);
    }

    public void addProductToBasket(ProductItem product, User user) {
        Basket b = new Basket();
        if(this.findBasketByUser(user) == null) { // Will create a user's basket if it doesn't exist
            b.setUserID(user);
            this.addBasket(b);
        }
        this.addProductToBasket(product, b);
    }

    public void removeProductFromBasket(ProductItem product, User user) {
        // presumes that at least one user's basket already exists
        this.removeProductFromBasket(product, this.findBasketByUser(user));
    }
    
}
