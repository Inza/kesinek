/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kesinek.beans;

import javax.ejb.EJB;
import kesinek.businesslayer.session.EventBeanLocal;

/**
 *
 * @author tomas
 */

public class EventFacesBean {

    @EJB
    EventBeanLocal eventBean;

    public String startTime() {
        return "admin";
    }

    public String stopTimer() {
        return "admin";
    }


    public boolean getRunning() {
        return false;
    }

}
