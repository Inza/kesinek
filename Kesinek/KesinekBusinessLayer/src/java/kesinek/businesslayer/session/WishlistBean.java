/*
 * This file describes Wishlist management session bean class.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Stateless;
import kesinek.businesslayer.entities.ProductAttribute;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.entities.Wishlist;

/**
 * Handles BL for ProductAttribute and Wishlist entity classes
 *
 * This bean will perform basic I/O operations with wishlists (EC Wishlist) in the system
 *
 * Every wishlist could have many product on it and this relation is also managed by this bean
 *
 * @author Tomáš Jukin
 */
@Stateless
public class WishlistBean implements WishlistBeanLocal {

    public void addProductToWishlist(ProductAttribute product, Wishlist wishlist) {
    }

    /**
     * Performs basic CUD operations with wishlists
     * 
     * For create operation a new Wishlist instance with all required fields should be passes
     * For update operation only fields which required to be changed shoul be set in passed Wishlist instance
     * For delete operation only Wishlist's id should be filled
     * 
     * @param wishlist
     */
    public void saveWishlist(Wishlist wishlist) {
    }

    public void removeProductFromWishlist(ProductItem product, Wishlist wishlist) {
    }

    public Collection<Wishlist> getAllWishlists() {
        return null;
    }

    public Wishlist getWishlistByUser(User user) {
        return null;
    }
 
}
