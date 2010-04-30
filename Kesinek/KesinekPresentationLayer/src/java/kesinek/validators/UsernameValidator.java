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
 * @author TomasLinhart
 */
public class UsernameValidator implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String val = (String) value;
        if (val.length() < 2 || val.length() > 32) {
            throw new ValidatorException(new FacesMessage("Username should be longer than 2 and shorter than 32 letters."));
        }
    }

}
