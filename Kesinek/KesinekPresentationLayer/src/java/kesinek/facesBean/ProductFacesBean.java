/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kesinek.facesBean;

import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.entities.User;
import kesinek.businesslayer.session.BasketBeanLocal;
import kesinek.businesslayer.session.ProductBeanLocal;
import kesinek.businesslayer.session.UserBeanLocal;
import kesinek.businesslayer.session.WishlistBeanLocal;


/**
 *
 * @author Tomas
 */
public class ProductFacesBean {

    @EJB
    private ProductBeanLocal productBean;
    @EJB
    private BasketBeanLocal basketBean;
    @EJB
    private WishlistBeanLocal wishBean;
    @EJB
    private UserBeanLocal userBean;

    public String getProductID()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        return (String) requestMap.get("productID");
    }

    public ProductItem getProduct()
    {
        return productBean.findProductByID(new Integer(getProductID()));
    }

    public String addToBasket()
    {
        if (FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() == null)
            return "login";
        else {
            ProductItem item = productBean.findProductByID(new Integer(getProductID()));
            String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
            User user = userBean.findUserByName(username);
            basketBean.addProductToBasket(item, user);
            return "basket";
        }
    }

    public String addToWishlist()
    {
        if (FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() == null)
            return "login";
        else {
            ProductItem item = productBean.findProductByID(new Integer(getProductID()));
            String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
            User user = userBean.findUserByName(username);
            wishBean.addProductToWishlist(item, user);
            return "wishlist";
        }
    }

    public String removeFromBasket()
    {
        if (FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() == null)
            return "login";
        else {
            ProductItem item = productBean.findProductByID(new Integer(getProductID()));
            String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
            User user = userBean.findUserByName(username);
            basketBean.removeProductFromBasket(item, user);
            return "basket";
        }
    }

    public String removeFromWishlist()
    {
        if (FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() == null)
            return "login";
        else {
            ProductItem item = productBean.findProductByID(new Integer(getProductID()));
            String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
            User user = userBean.findUserByName(username);
            wishBean.removeProductFromWishlist(item, user);
            return "wishlist";
        }
    }

}
