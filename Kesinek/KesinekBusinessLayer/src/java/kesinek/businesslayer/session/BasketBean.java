/*
 * This file describes Basket management session bean class.
 *
 * - reviewed: 4. 1. 2010, 13:17
 * - finalized: 4. 1. 2010, 13:17
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.IsInBasket;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.User;

@Stateless
public class BasketBean implements BasketBeanLocal {
    @EJB
    private UserBeanLocal userBean;
    @EJB
    private ProductBeanLocal productBean;
    @EJB
    private BasketBeanLocal basketBean;

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
        try
        {
            return (Basket) em.createNamedQuery("Basket.findByUserID").setParameter("userID", user).getSingleResult();
        }
        catch(NoResultException e)
        {
            return null;
        }
    }

    public void updateBasket(Basket basket) {
        em.createNamedQuery("Basket.update")
                .setParameter("userID", basket.getUserID())
                .setParameter("basketID", basket.getBasketID())
        .executeUpdate();
        em.merge(basket);
    }

    public void addProductToBasket(ProductItem product, User user) {
        Basket b = this.findBasketByUser(user);
        if(b == null) { // Will create a user's basket if it doesn't exist
            b = new Basket();
            b.setUserID(user);
            this.addBasket(b);
        }
        this.addProductToBasket(product, b);
    }

    public void removeProductFromBasket(ProductItem product, User user) {
        // presumes that at least one user's basket already exists
        this.removeProductFromBasket(product, this.findBasketByUser(user));
    }

    @SuppressWarnings("unchecked")
    public Collection<ProductItem> findProductsInBasket(Basket basket) {
        return em.createNamedQuery("Basket.findRelatedProducts").setParameter("basketID", basket.getBasketID()).getResultList();
    }

    public void test() {
        User uu = new User();
        uu.setAddress("pokus");
        uu.setPassword("test");
        uu.setUsername("bar");
        userBean.addUser(uu);

        ProductItem pp1 = new ProductItem();
        pp1.setName("pokus");
        pp1.setPrice(400);
        pp1.setManufacturerID(1);
        pp1.setWarehouseID(1);
        ProductItem pp2 = new ProductItem();
        pp2.setName("pokus1");
        pp2.setPrice(400);
        pp2.setManufacturerID(1);
        pp2.setWarehouseID(1);
        ProductItem pp3 = new ProductItem();
        pp3.setName("pokus2");
        pp3.setPrice(400);
        pp3.setManufacturerID(1);
        pp3.setWarehouseID(1);
        productBean.addProduct(pp1);
        productBean.addProduct(pp2);
        productBean.addProduct(pp3);

        productBean.removeProduct(pp2);

        Basket bb = new Basket(10);
        bb.setUserID(uu);
        basketBean.addBasket(bb);

        //basketBean.addProductToBasket(pp1, uu);
        //basketBean.addProductToBasket(pp3, uu);
        //basketBean.removeProductFromBasket(pp3, uu);

        List<ProductItem> l = (List<ProductItem>) basketBean.findProductsInBasket(basketBean.findBasketByUser(uu));

        basketBean.removeProductFromBasket(l.get(0), uu);
    }
    
}
