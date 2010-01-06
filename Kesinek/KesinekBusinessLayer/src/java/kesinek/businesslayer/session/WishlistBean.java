/*
 * This file describes Wishlist management session bean class.
 *
 * - reviewed: 6. 1. 2010, 7:55
 * - finalized: 6. 1. 2010, 7:55
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

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
        em.persist(new IsInWishlist().setWishlistID(wishlist).setProductItemID(product));
    }

    public void removeProductFromWishlist(ProductItem product, Wishlist wishlist) {
        IsInWishlist relation = em.merge(new IsInWishlist().setWishlistID(wishlist).setProductItemID(product));
        em.remove(relation);
    }

    @SuppressWarnings("unchecked")
    public Collection<Wishlist> getAllWishlists() {
        return em.createNamedQuery("Wishlist.findAll").getResultList();
    }

    public Wishlist getWishlistByUser(User user) {
        return (Wishlist) em.createNamedQuery("Wishlist.findByUserID").setParameter("userID", user.getUserID()).getSingleResult();
    }

    public void addWishlist(Wishlist wishlist) {
        em.persist(wishlist);
    }

    public void removeWishlist(Wishlist wishlist) {
        wishlist = em.merge(wishlist);
        em.remove(wishlist);
    }
 
}
