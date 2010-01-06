/*
 * This file describes Event management session bean local interface.
 *
 * @author Tomáš Jukin
 */

package kesinek.businesslayer.session;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.TemporalType;
import kesinek.businesslayer.entities.Event;

/**
 * Handles BL for Event entity class
 *
 * This bean will perform basic I/O operations with categories (EC Event) in the system
 *
 * - reviewed: 5. 1. 2010, 10:33
 * - finalized: 5. 1. 2010, 10:33
 *
 * @author Tomáš Jukin
 */
@Local
public interface EventBeanLocal {

    /**
     * Will an event to the system
     *
     * @param event
     */
    void addEvent(Event event);

    /**
     * Will remove desired event from the system
     *
     * @param event
     */
    void removeEvent(Event event);

    /**
     * Will find all events in the system
     *
     * @return List<Event>
     */
    public List<Event> findAllEvent();

    /**
     * Will find desired event in the system by its ID
     *
     * @param id
     * @return Event
     */
    public Event findEventByID(int id);

    /**
     * Will find events in the system by userID
     *
     * @param userID
     * @return Event
     */
    public List<Event> findEventByUser(int userID);

    /**
     * Will find events in the system by date
     *
     * @param date
     * @param type could be TemporalType.DATE, TemporalType.DATE or TemporalType.TIMESTAMP
     * @return List<Event>
     */
    public List<Event> findEventByDate(Date date, TemporalType type);

    // There is intentionally no way how to update an existing event
    // Events are created automatically and there is no need for update them
    
}
