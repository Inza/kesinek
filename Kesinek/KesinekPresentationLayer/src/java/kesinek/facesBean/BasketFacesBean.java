/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kesinek.facesBean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import kesinek.businesslayer.entities.Basket;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.session.BasketBeanLocal;
import kesinek.businesslayer.session.PurchaseOrderBean;
import kesinek.businesslayer.session.PurchaseOrderBeanLocal;
import kesinek.businesslayer.session.UserBeanLocal;

/**
 *
 * @author Tomas
 */

public class BasketFacesBean {

    @EJB
    UserBeanLocal userBean;
    @EJB
    BasketBeanLocal basketBean;
    @EJB
    PurchaseOrderBeanLocal orderBean;

    public DataModel getProductDataModel() {
        DataModel productDataModel = new ListDataModel(getProducts());
        return productDataModel;
    }

    public List<ProductItem> getProducts() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        User user = userBean.findUserByName(username);
        Basket b = basketBean.findBasketByUser(user);
        return (List<ProductItem>) basketBean.findProductsInBasket(b);
    }

    public String makeOrder() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        User user = userBean.findUserByName(username);
        Basket b = basketBean.findBasketByUser(user);
        if (b.getIsInBasketCollection().size() == 0)
            return "basket";
        orderBean.fetchFromBasket(b);
        orderBean = new PurchaseOrderBean(); // or how? 
        return "order";
    }

}
