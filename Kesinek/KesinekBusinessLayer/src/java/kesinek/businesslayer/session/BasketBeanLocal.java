/*
 * This file describes Basket management session bean local interface.
 */

package kesinek.businesslayer.session;

import java.util.List;
import javax.ejb.Local;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.ProductItem;

/**
 * Handles BL for ProductItem and Basket entity classes
 *
 * @author Tomáš Jukin
 */
@Local
public interface BasketBeanLocal {

    void addProductToBasket(ProductItem product, Basket basket);

    void removeProductFromBasket(ProductItem product, Basket basket);

    void addBasket(Basket basket);

    void removeBasket(Basket basket);

    public List<Basket> findAllBasket();

    public Basket findBasketByID(int id);

    public void updateBasket(Basket basket);
    
}
