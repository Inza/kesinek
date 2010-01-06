/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kesinek.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Admin
 */
public class CategoryNameValidator implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String val = (String) value;
        if (val.length() < 2 || val.length() > 50) {
            throw new ValidatorException(new FacesMessage("Category name should be longer than 2 and shorter than 50 letters."));
        }
        
    }

}
