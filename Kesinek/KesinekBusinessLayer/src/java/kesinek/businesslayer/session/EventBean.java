/*
 * This file describes Category management session bean class.
 *
 * - reviewed: 5. 1. 2010, 10:34
 * - finalized: 5. 1. 2010, 10:34
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import kesinek.businesslayer.entities.Event;

@Stateless
public class EventBean implements EventBeanLocal {

    @PersistenceContext
    private EntityManager em;

    public void addEvent(Event event) {
        em.persist(event);
    }

    public void removeBasket(Event event) {
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
 
}
