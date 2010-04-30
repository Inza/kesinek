package kesinek.facesBean;

import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.PurchaseOrder;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.session.BasketBeanLocal;
import kesinek.businesslayer.session.PurchaseOrderBean;
import kesinek.businesslayer.session.PurchaseOrderBeanLocal;
import kesinek.businesslayer.session.UserBeanLocal;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomas
 */

public class OrderFacesBean {

    @EJB
    private PurchaseOrderBeanLocal orderBean;
    @EJB
    private BasketBeanLocal basketBean;
    @EJB
    private UserBeanLocal userBean;

    public DataModel getOrderDataModel() {
        DataModel productDataModel = new ListDataModel(getOrders());
        return productDataModel;
    }

    public List<PurchaseOrder> getOrders() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        User user = userBean.findUserByName(username);
        return (List<PurchaseOrder>) orderBean.findPurchaseOrdersByUser(user);
    }

    public String makeOrder() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        User user = userBean.findUserByName(username);
        Basket b = basketBean.findBasketByUser(user);
        if (b.getIsInBasketCollection().size() == 0)
            return "basket";
        orderBean.fetchFromBasket(b);
        // set order id
        orderBean = new PurchaseOrderBean(); // or how? 
        return "order";
    }

    public String getOrderID()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        return (String) requestMap.get("orderID");
    }

    public PurchaseOrder getOrder()
    {
        return orderBean.findPurchaseOrderByID(new Integer(getOrderID()));
    }
}
