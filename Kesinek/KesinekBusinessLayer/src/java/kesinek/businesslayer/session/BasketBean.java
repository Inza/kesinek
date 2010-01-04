/*
 * This file describes Basket management session bean class.
 */

package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.ProductItem;

/**
 * Handles BL for ProductItem and Basket entity classes
 *
 * This bean will perform basic I/O operations with products (EC ProductItem) in the product baskets (EC Basket)
 *
 * @author Tomáš Jukin
 */
@Stateless
public class BasketBean implements BasketBeanLocal {

    @PersistenceContext
    private EntityManager em;

    /**
     * Will add desired product to desired basket
     *
     * @param product
     * @param basket
     */
    public void addProductToBasket(ProductItem product, Basket basket) {
    }

    
    public void removeProductFromBasket(ProductItem product, Basket basket) {
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

    public void updateBasket(Basket basket) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
