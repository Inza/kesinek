/*
 * This file describes Wishlist management session bean class.
 *
 * - reviewed: 6. 1. 2010, 7:55
 * - finalized: 6. 1. 2010, 7:55
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.IsInWishlist;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.entities.Wishlist;

@Stateless
public class WishlistBean implements WishlistBeanLocal {

    @PersistenceContext
    private EntityManager em;

    public void addProductToWishlist(ProductItem product, Wishlist wishlist) {
        IsInWishlist relation = new IsInWishlist();
        relation.setWishlistID(wishlist);
        relation.setProductItemID(product);
        em.persist(relation);
    }

    public void removeProductFromWishlist(ProductItem product, Wishlist wishlist) {
        IsInWishlist relation = new IsInWishlist();
        relation.setWishlistID(wishlist);
        relation.setProductItemID(product);
        relation = em.merge(relation);
        em.remove(relation);
    }

    @SuppressWarnings("unchecked")
    public Collection<Wishlist> getAllWishlists() {
        return em.createNamedQuery("Wishlist.findAll").getResultList();
    }

    public Wishlist getWishlistByUser(User user) {
        return (Wishlist) em.createNamedQuery("Wishlist.findByUserID").setParameter("userID", user.getUserID()).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public Collection<ProductItem> getProductsInWishlist(Wishlist wishlist) {
        return em.createNamedQuery("Wishlist.findRelatedProducts").setParameter("wishlistID", wishlist.getWishlistID()).getResultList();
    }

    @SuppressWarnings("unchecked")
    public Collection<ProductItem> getProductsInWishlist(User user) {
        Wishlist w = this.getWishlistByUser(user);
        if(w == null) {
            return new ArrayList<ProductItem>();
        }
        return this.getProductsInWishlist(w);
    }

    public void addWishlist(Wishlist wishlist) {
        em.persist(wishlist);
    }

    public void removeWishlist(Wishlist wishlist) {
        wishlist = em.merge(wishlist);
        em.remove(wishlist);
    }

    public void addProductToWishlist(ProductItem product, User user) {
        Wishlist w = this.getWishlistByUser(user);
        if(w == null) { // Will create a user's wishlist if it doesn't exist
            w = new Wishlist();
            w.setUserID(user.getUserID());
            this.addWishlist(w);
        }
        this.addProductToWishlist(product, w);
    }

    public void removeProductFromWishlist(ProductItem product, User user) {
        // presumes that at least one user's wishlist already exists
        this.removeProductFromWishlist(product, this.getWishlistByUser(user));
    }
 
}
