/*
 * This file describes Wishlist management session bean local interface.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Local;
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
 * - reviewed: 6. 1. 2010, 7:55
 * - finalized: 6. 1. 2010, 7:55
 *
 * @author Tomáš Jukin
 */
@Local
public interface WishlistBeanLocal {

    /**
     * Will a wishlist to the system
     *
     * @param wishlist
     */
    public void addWishlist(Wishlist wishlist);

    /**
     * Will remove desired wishlist from the system
     *
     * @param wishlist
     */
    public void removeWishlist(Wishlist wishlist);

    /**
     * Will add desired product to desired wishlist
     *
     * @param product
     * @param wishlist
     */
    public void addProductToWishlist(ProductItem product, Wishlist wishlist);
    
    /**
     * Will remove desired product from desired wishlist
     *
     * @param product
     * @param wishlist
     */
    public void removeProductFromWishlist(ProductItem product, Wishlist wishlist);

    /**
     * Will add desired product to desired user's wishlist
     *
     * @param product
     * @param user
     */
    public void addProductToWishlist(ProductItem product, User user);

    /**
     * Will remove desired product from desired user's wishlist
     *
     * @param product
     * @param user
     */
    public void removeProductFromWishlist(ProductItem product, User user);

    /**
     * Will load all wishlist from the system
     *
     * @return Collection<Wishlist>
     */
    public Collection<Wishlist> getAllWishlists();

    /**
     * Will a wishlist of desired user
     *
     * @param user
     * @return Wishlist
     */
    public Wishlist getWishlistByUser(User user);
    
}
