/*
 * This file describes Category management session bean class.
 *
 * - reviewed: 5. 1. 2010, 10:34
 * - finalized: 5. 1. 2010, 10:34
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import kesinek.businesslayer.entities.Event;
import kesinek.businesslayer.entities.User;

@Stateless
public class EventBean implements EventBeanLocal {

    @EJB
    UserBeanLocal userBean;

    @PersistenceContext
    private EntityManager em;

    @Resource
    TimerService timerService;

    public void addEvent(Event event) {
        em.persist(event);
    }

    public void removeEvent(Event event) {
        event = em.merge(event);
        em.remove(event);
    }

    @SuppressWarnings("unchecked")
    public List<Event> findAllEvent() {
        return em.createNamedQuery("Event.findAll").getResultList();
    }

    public Event findEventByID(int id) {
        return em.getReference(Event.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Event> findEventByUser(int userID) {
        return em.createNamedQuery("Event.findAllByUserID").setParameter("userID", userID).getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findEventByDate(Date date, TemporalType type) {
        return em.createNamedQuery("Event.findAllByDate").setParameter("date", date, type).getResultList();
    }
    
    public void createTimer(long intervalDuration) {
        Timer timer = timerService.createTimer(intervalDuration,
                "Created new timer");
    }

    public void removeTimer() {
        @SuppressWarnings("unchecked")
        ArrayList<Timer> l = (ArrayList<Timer>) timerService.getTimers();

        if(!l.isEmpty()) {
            Timer t = l.get(0);
            t.cancel();
        }
    }

    public boolean isRunning() {
        @SuppressWarnings("unchecked")
        ArrayList<Timer> l = (ArrayList<Timer>) timerService.getTimers();

        return !l.isEmpty();
    }

    @Timeout
    public void timeout(Timer timer) {
        // Will add user System id it do no exist
        User usr = userBean.findUserByName("System");
        if(usr == null) {
            usr = new User();
            usr.setAddress("A binary address");
            usr.setPassword("bit");
            usr.setUsername("System");
            userBean.addUser(usr);
        }

        Event e = new Event();
        Calendar cal = Calendar.getInstance();
        e.setDate(cal.getTime());
        e.setText("It's time to die!");
        e.setUserID(usr);
        this.addEvent(e);
    }
 
}
