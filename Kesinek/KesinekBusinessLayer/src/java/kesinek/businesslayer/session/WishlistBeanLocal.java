/*
 * This file describes Wishlist management session bean local interface.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Local;
import kesinek.businesslayer.entities.ProductAttribute;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.entities.Wishlist;

/**
 * Handles BL for ProductAttribute and Wishlist entity classes
 *
 * @author Tomáš Jukin
 */
@Local
public interface WishlistBeanLocal {

    void addProductToWishlist(ProductAttribute product, Wishlist wishlist);

    void saveWishlist(Wishlist wishlist);

    void removeProductFromWishlist(ProductItem product, Wishlist wishlist);

    Collection<Wishlist> getAllWishlists();

    Wishlist getWishlistByUser(User user);
    
}
