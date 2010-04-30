package kesinek.facesBean;


import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import kesinek.businesslayer.entities.Category;
import kesinek.businesslayer.entities.ProductItem;
import kesinek.businesslayer.session.CategoryBeanLocal;
import kesinek.businesslayer.session.ProductBeanLocal;


/**
 *
 * @author Tomas
 */
public class CategoryFacesBean {

    @EJB
    private CategoryBeanLocal categoryBean;
    @EJB
    private ProductBeanLocal productBean;
    private DataModel categoryDataModel;
    private DataModel productDataModel;

    public DataModel getCategoryDataModel() {
        categoryDataModel = new ListDataModel(getCategories());
        return categoryDataModel;
    }

    public DataModel getProductDataModel() {
        productDataModel = new ListDataModel(getProducts());
        return productDataModel;
    }

    public List<Category> getCategories() {
        return categoryBean.findAllCategory();
    }

    public List<ProductItem> getProducts() {
        if (getCategoryID() == null)
            return productBean.findAllProducts();
        else
            return productBean.findProductsByCategory(categoryBean.findCategoryByID(new Integer(getCategoryID())));
    }

    public String showCategory()
    {
        return "showCategory";
    }

    public String showProduct()
    {
        return "showProduct";
    }

    public String getCategoryID()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestParameterMap();
        return (String) requestMap.get("categoryID");
    }
}
