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
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.session.UserBeanLocal;
import kesinek.businesslayer.session.WishlistBeanLocal;

/**
 *
 * @author Tomas
 */

public class WishlistFacesBean {

    @EJB
    UserBeanLocal userBean;
    @EJB
    WishlistBeanLocal wishBean;
    
    public DataModel getProductDataModel() {
        DataModel productDataModel = new ListDataModel(getProducts());
        return productDataModel;
    }

    public List<ProductItem> getProducts() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        User user = userBean.findUserByName(username);
        return (List<ProductItem>) wishBean.getProductsInWishlist(user);
    }

}
