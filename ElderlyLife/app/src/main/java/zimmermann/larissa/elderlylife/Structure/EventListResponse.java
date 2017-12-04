package zimmermann.larissa.elderlylife.Structure;

import java.util.List;

/**
 * Created by laris on 27/11/2017.
 */

public class EventListResponse {
    private List<Event> data;

    public EventListResponse(List<Event> events) {
        this.data = events;
    }

    public List<Event> getEvents() {
        return data;
    }

    public void setEvents(List<Event> events) {
        this.data = events;
    }
}
