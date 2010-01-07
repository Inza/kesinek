/*
 * This file describes PurchaseOrder management session bean local interface.
 */

package kesinek.businesslayer.session;

import java.util.Collection;
import javax.ejb.Local;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.PurchaseOrder;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.session.PurchaseOrderBean.orderState;

/**
 * Handles BL for PurchaseOrder and ProductItem entity classes
 *
 * @author Tomáš Jukin
 */
@Local
public interface PurchaseOrderBeanLocal {

    // for frontend

    public void setTargetUser(User user);

    public void fetchFromPurchaseOrder(PurchaseOrder order);

    public void fetchFromBasket(Basket basket);

    public Collection<ProductItem> getProducts();

    public void changeState(PurchaseOrderBean.orderState newState);

    public orderState getState();

    public void save();

    // for backend

    public void add(PurchaseOrder order);

    public void remove(PurchaseOrder order);

    public Collection<PurchaseOrder> getAllPurchaseOrders();

    public Collection<PurchaseOrder> findPurchaseOrdersByUser(User user);
    
    public PurchaseOrder findPurchaseOrderByID(int id);
    
}
