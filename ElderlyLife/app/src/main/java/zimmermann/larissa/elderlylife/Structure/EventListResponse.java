package zimmermann.larissa.elderlylife.Structure;

import java.util.List;

/**
 * Created by laris on 27/11/2017.
 */

public class EventListResponse {
    private List<Event> events;

    public EventListResponse(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
