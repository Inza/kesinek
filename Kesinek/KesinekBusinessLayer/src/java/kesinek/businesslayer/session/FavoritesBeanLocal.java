/*
 * This file describes Favorites management session bean local interface.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Local;
import kesinek.businesslayer.entities.Favorite;
import kesinek.businesslayer.entities.ProductItem;

/**
 * Handles BL for Favorites and ProductItem entity classes
 *
 * @author Tomáš Jukin
 */
@Local
public interface FavoritesBeanLocal {

    void addProductToFavorites(ProductItem product, Favorite favorites);

    void removeProductFromFavorites(ProductItem product, Favorite favorites);

    void incrementProductEvaluation(ProductItem product, Favorite favorites);

    void decrementProductEvaluation(ProductItem product, Favorite favorites);

    Collection<ProductItem> getMostFavoriteProducts(Favorite favorite);
    
}
