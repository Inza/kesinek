/*
 * This file describes PurchaseOrder management session bean class.
 */

package kesinek.businesslayer.session;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.IsInPurchaseOrder;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.PurchaseOrder;
import kesinek.businesslayer.entities.User;

@TransactionManagement(value=TransactionManagementType.CONTAINER)

/**
 * Handles BL for PurchaseOrder and ProductItem entity classes
 *
 * This bean will perform basic I/O operations with purchase orders (EC PurchaseOrder) in the system
 *
 * Also products (EC ProductItem) could be added to them or removed from them through this bean.
 *
 * @author Tomáš Jukin
 */
@Stateful
public class PurchaseOrderBean implements PurchaseOrderBeanLocal {

    @PersistenceContext
    EntityManager em;

    private User targetUser;
    private PurchaseOrder source;
    private orderState state = orderState.NOT_PAID;

    public void setTargetUser(User user) {
        this.targetUser = user;
    }

    public void fetchFromPurchaseOrder(PurchaseOrder order) {
        this.targetUser = new UserBean().findUserByID(order.getUserID());
        this.source = order;
    }

    public void init() {
        this.source = new PurchaseOrder();
        this.state = orderState.NOT_PAID;
        em.persist(this.source);
        em.merge(this.source);
    }

    public void fetchFromBasket(Basket basket) {
        this.targetUser = basket.getUserID();
        this.save();

        ArrayList<ProductItem> products = (ArrayList<ProductItem>) new BasketBean().findProductsInBasket(basket);

        for(ProductItem p : products) {
            IsInPurchaseOrder r = new IsInPurchaseOrder();
            r.setProductItemID(p);
            r.setPurchaseOrderID(source);
            em.persist(r);

            new BasketBean().removeProductFromBasket(p, basket);
        }
    }

    @SuppressWarnings("unchecked")
    public Collection<ProductItem> getProducts() {
        return em.createNamedQuery("PurchaseOrder.findRelatedProducts").setParameter("purchaseOrderID", this.source.getPurchaseOrderID()).getResultList();  
    }

    public orderState getState() {
        return this.state;
    }

    public void changeState(orderState newState) {
        this.state = newState;
    }

    public void save() {
        this.source.setUserID(this.targetUser.getUserID());
        this.source.setState(this.state == orderState.PAID?"paid":"not paid");
        em.persist(this.source);
    }

    public void add(PurchaseOrder order) {
        em.persist(order);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(PurchaseOrder order) {
        order = em.merge(order);
        em.remove(order);
    }

    @SuppressWarnings("unchecked")
    public Collection<PurchaseOrder> getAllPurchaseOrders() {
        return em.createNamedQuery("PurchaseOrder.findAll").getResultList();
    }

    @SuppressWarnings("unchecked")
    public Collection<PurchaseOrder> findPurchaseOrdersByUser(User user) {
        return em.createNamedQuery("PurchaseOrder.findByUserID").setParameter("userID", user.getUserID()).getResultList();
    }

    public PurchaseOrder findPurchaseOrderByID(int id) {
        return em.getReference(PurchaseOrder.class, id);
    }

    public enum orderState {PAID, NOT_PAID};
 
}
