package goit.finalproject.rest.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="events")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated event ID")
    private Long id;

    @Column(name="type")
    @ApiModelProperty(notes = "Type of event")
    private String type;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
//    @ApiModelProperty(notes = "List of event with date")
//    private List<DateEvent> dateEvents;

    public Event() {
    }



    public Event(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public List<DateEvent> getDateEvents() {
//        return dateEvents;
//    }
//
//    public void setDateEvents(List<DateEvent> dateEvents) {
//        this.dateEvents = dateEvents;
//    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        return type != null ? type.equals(event.type) : event.type == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
