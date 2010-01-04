/*
 * This file describes Basket management session bean local interface.
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Local;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.ProductItem;

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
    void addProductToBasket(ProductItem product, Basket basket);

    /**
     * Will remove desired product from desired basket
     *
     * @param product
     * @param basket
     */
    void removeProductFromBasket(ProductItem product, Basket basket);

    /**
     * Will add desired basket to the system
     *
     * @param basket
     */
    void addBasket(Basket basket);

    /**
     * Will remove desired basket from the system
     *
     * @param basket
     */
    void removeBasket(Basket basket);

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
     * Will update desired basket in the system
     *
     * @param basket
     */
    public void updateBasket(Basket basket);
    
}
