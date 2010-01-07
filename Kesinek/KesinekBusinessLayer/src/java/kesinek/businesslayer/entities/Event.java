package kesinek.businesslayer.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Event entity class
 *
 * - reviewed: 5. 1. 2010, 10:17
 * - finalized: 5. 1. 2010, 10:17
 *
 * @author Tomáš Jukin
 */
@Entity
@Table(name = "Event", catalog = "kesinek", schema = "")
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByUserID", query = "SELECT e FROM Event e WHERE e.userID = :userID"),
    @NamedQuery(name = "Event.findByDate", query = "SELECT e FROM Event e WHERE e.date = :date"),
    @NamedQuery(name = "Event.findByText", query = "SELECT e FROM Event e WHERE e.text = :text"),
    @NamedQuery(name = "Event.findByEventID", query = "SELECT e FROM Event e WHERE e.eventID = :eventID")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "dateTS", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "text", nullable = false, length = 50)
    private String text;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eventID", nullable = false)
    private Integer eventID;
    @JoinColumn(name = "userID", referencedColumnName = "userID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userID;

    public Event() {
    }

    public Event(Integer eventID) {
        this.eventID = eventID;
    }

    public Event(Integer eventID, Date date, String text) {
        this.eventID = eventID;
        this.date = date;
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventID != null ? eventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventID == null && other.eventID != null) || (this.eventID != null && !this.eventID.equals(other.eventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kesinek.businesslayer.entities.Event[eventID=" + eventID + "]";
    }

}
