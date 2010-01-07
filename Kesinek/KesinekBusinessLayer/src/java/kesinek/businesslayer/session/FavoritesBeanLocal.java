/*
 * This file describes Favorites management session bean local interface.
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Local;
import kesinek.businesslayer.entities.Favorite;
import kesinek.businesslayer.entities.ProductItem;

/**
 * Handles BL for Favorites and ProductItem entity classes
 *
 * This bean will perform basic I/O operations with product (EC ProductItem) in the favorite lists (EC Favorite)
 *
 * Favorite lists are kind of system wide stats mechanism
 *
 * - reviewed: 6. 1. 2010, 7:55
 * - finalized: 6. 1. 2010, 7:55
 *
 * @author Tomáš Jukin
 */
@Local
public interface FavoritesBeanLocal {

    /**
     * Will a favorite to the system
     *
     * @param favorites
     */
    public void addFavorite(Favorite favorites);

    /**
     * Will remove desired favorite from the system
     *
     * @param favorites
     */
    public void removeFavorite(Favorite favorites);

    /**
     * Will add desired product to desired favorite list
     *
     * @param product
     * @param favorites
     */
    public void addProductToFavorites(ProductItem product, Favorite favorites);

    /**
     * Will add desired product to default favorite list
     *
     * @param product
     */
    public void addProductToFavorites(ProductItem product);

    /**
     * Will remove desired product from desired favorite list
     *
     * @param product
     * @param favorites
     */
    public void removeProductFromFavorites(ProductItem product, Favorite favorites);

    /**
     * Will remove desired product from default favorite list
     *
     * @param product
     */
    public void removeProductFromFavorites(ProductItem product);

    /**
     * Will increment desired product evaluation in desired favorite list
     *
     * @param product
     * @param favorites
     */
    public void incrementProductEvaluation(ProductItem product, Favorite favorites);

    /**
     * Will increment desired product evaluation in desired favorite list
     *
     * @param product
     * @param favorites
     */
    public void decrementProductEvaluation(ProductItem product, Favorite favorites);

    /**
     * Will increment desired product evaluation in default favorite list
     *
     * @param product
     */
    public void incrementProductEvaluation(ProductItem product);

    /**
     * Will increment desired product evaluation in default favorite list
     *
     * @param product
     */
    public void decrementProductEvaluation(ProductItem product);

    /**
     * Will list of most favorite products in given favorite
     *
     * @param favorite
     * @param number How many product do you want to have?
     * @return Collection<ProductItem>
     */
    public Collection<ProductItem> getMostFavoriteProducts(Favorite favorite, Integer number);

    /**
     * Will find desired favorite in the system by its ID
     *
     * @param id
     * @return Favorite
     */
    public Favorite findFavoriteByID(int id);
    
}
