/*
 * This file describes Favorites management session bean class.
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
import kesinek.businesslayer.entities.Favorite;
import kesinek.businesslayer.entities.IsInFavorite;
import kesinek.businesslayer.entities.ProductItem;

@Stateless
public class FavoritesBean implements FavoritesBeanLocal {

    @PersistenceContext
    private EntityManager em;

    public void addProductToFavorites(ProductItem product, Favorite favorites) {
        em.persist(new IsInFavorite().setFavoriteID(favorites).setProductItemID(product));
    }

    public void removeProductFromFavorites(ProductItem product, Favorite favorites) {
        IsInFavorite relation = em.merge(new IsInFavorite().setFavoriteID(favorites).setProductItemID(product));
        em.remove(relation);
    }

    public void incrementProductEvaluation(ProductItem product, Favorite favorites) {
        em.createNamedQuery("IsInFavorite.updateAmount")
                .setParameter("productItemID", product.getProductItemID())
                .setParameter("favoriteID", favorites.getFavoritesID())
                .setParameter("amount", ((Integer)em.createNamedQuery("IsInFavorite.findAmount")
                    .setParameter("productItemID", product.getProductItemID())
                    .setParameter("favoriteID", favorites.getFavoritesID())
                .getSingleResult() + 1)
        )
        .executeUpdate();
    }

    public void decrementProductEvaluation(ProductItem product, Favorite favorites) {
        em.createNamedQuery("IsInFavorite.updateAmount")
                .setParameter("productItemID", product.getProductItemID())
                .setParameter("favoriteID", favorites.getFavoritesID())
                .setParameter("amount", ((Integer)em.createNamedQuery("IsInFavorite.findAmount")
                    .setParameter("productItemID", product.getProductItemID())
                    .setParameter("favoriteID", favorites.getFavoritesID())
                .getSingleResult() - 1)
        )
        .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public Collection<ProductItem> getMostFavoriteProducts(Favorite favorite, Integer number) {
        return em.createNamedQuery("Favorite.findMostFavoriteProducts")
                .setParameter("favoritesID", favorite.getFavoritesID())
                //.setParameter("limit", number)
        .getResultList();
    }

    public void addFavorite(Favorite favorites) {
        em.persist(favorites);
    }

    public void removeFavorite(Favorite favorites) {
        favorites = em.merge(favorites);
        em.remove(favorites);
    }
 
}
