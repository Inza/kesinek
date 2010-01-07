/*
 * This file describes Basket management session bean local interface.
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import java.util.List;
import javax.ejb.Local;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.User;

/**
 * Handles BL for ProductItem and Basket entity classes
 *
 * This bean will perform basic I/O operations with products (EC ProductItem) in the product baskets (EC Basket)
 *
 * - reviewed: 4. 1. 2010, 13:17
 * - finalized: 4. 1. 2010, 13:17
 *
 * @author Tomáš Jukin
 */
@Local
public interface BasketBeanLocal {

    /**
     * Will add desired product to desired basket
     *
     * @param product
     * @param basket
     */
    public void addProductToBasket(ProductItem product, Basket basket);

    /**
     * Will remove desired product from desired basket
     *
     * @param product
     * @param basket
     */
    public void removeProductFromBasket(ProductItem product, Basket basket);

    /**
     * Will add desired product to desired user's basket
     *
     * @param product
     * @param user
     */
    public void addProductToBasket(ProductItem product, User user);

    /**
     * Will remove desired product from desired user's basket
     *
     * @param product
     * @param user
     */
    public void removeProductFromBasket(ProductItem product, User user);

    /**
     * Will add desired basket to the system
     *
     * @param basket
     */
    public void addBasket(Basket basket);

    /**
     * Will remove desired basket from the system
     *
     * @param basket
     */
    public void removeBasket(Basket basket);

    /**
     * Will find all baskets in the system
     *
     * @return List<Basket>
     */
    public List<Basket> findAllBasket();

    /**
     * Will find desired basket in the system by its ID
     *
     * @param id
     * @return Basket
     */
    public Basket findBasketByID(int id);

    /**
     * Will find desired basket in the system by its owner
     *
     * @param user
     * @return Basket
     */
    public Basket findBasketByUser(User user);

    /**
     * Will find all products in desired basket
     *
     * @param basket
     * @return Collection<ProductItem>
     */
    public Collection<ProductItem> findProductsInBasket(Basket basket);

    /**
     * Will update desired basket in the system
     *
     * @param basket
     */
    public void updateBasket(Basket basket);
    
}
