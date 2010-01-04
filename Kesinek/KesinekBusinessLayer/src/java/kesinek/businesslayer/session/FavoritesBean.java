/*
 * This file describes Favorites management session bean class.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Stateless;
import kesinek.businesslayer.entities.Favorite;
import kesinek.businesslayer.entities.ProductItem;

/**
 * Handles BL for Favorites and ProductItem entity classes
 *
 * This bean will perform basic I/O operations with product (EC ProductItem) in the favorite lists (EC Favorite)
 *
 * Favorite lists are kind of system wide stats mechanism
 *
 * @author Tomáš Jukin
 */
@Stateless
public class FavoritesBean implements FavoritesBeanLocal {

    public void addProductToFavorites(ProductItem product, Favorite favorites) {
    }

    public void removeProductFromFavorites(ProductItem product, Favorite favorites) {
    }

    /**
     * Will increment desired product evaluation in desired favorite list
     * 
     * @param product
     * @param favorites
     */
    public void incrementProductEvaluation(ProductItem product, Favorite favorites) {
    }

    public void decrementProductEvaluation(ProductItem product, Favorite favorites) {
    }

    public Collection<ProductItem> getMostFavoriteProducts(Favorite favorite) {
        return null;
    }
 
}
