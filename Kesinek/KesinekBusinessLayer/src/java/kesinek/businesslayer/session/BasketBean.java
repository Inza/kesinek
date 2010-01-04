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

@Stateless
public class BasketBean implements BasketBeanLocal {

    @PersistenceContext
    private EntityManager em;
    
    public void addProductToBasket(ProductItem product, Basket basket) {
        em.persist(new IsInBasket().setBasketID(basket).setProductItemID(product));
    }
    
    public void removeProductFromBasket(ProductItem product, Basket basket) {
        IsInBasket relation = em.merge(
                new IsInBasket()
                    .setBasketID(basket)
                    .setProductItemID(product)
        );
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

    public void updateBasket(Basket basket) {
        em.createNamedQuery("Basket.update")
                .setParameter("userID", basket.getUserID())
                .setParameter("basketID", basket.getBasketID())
        .executeUpdate();
        em.merge(basket);
    }
    
}
