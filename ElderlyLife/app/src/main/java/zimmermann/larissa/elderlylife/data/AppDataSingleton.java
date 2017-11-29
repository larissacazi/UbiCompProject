package zimmermann.larissa.elderlylife.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import zimmermann.larissa.elderlylife.Structure.AppUser;
import zimmermann.larissa.elderlylife.Structure.Event;
import zimmermann.larissa.elderlylife.Structure.EventListResponse;
import zimmermann.larissa.elderlylife.Structure.OwnerUser;
import zimmermann.larissa.elderlylife.Structure.Tag;
import zimmermann.larissa.elderlylife.utils.Utils;

/**
 * Created by laris on 28/11/2017.
 */

public class AppDataSingleton {
    //User
    private AppUser appUser;
    private OwnerUser ownerUser;
    private int userType = Utils.OWNER_USER; // 1 -> appUser, 2 -> ownerUser

    //Tag
    private Tag tags;

    //Event
    private EventListResponse eventListResponse;

    //Instance
    private static AppDataSingleton instance = null;

    private AppDataSingleton() {
        fillEventList();
    }

    public static AppDataSingleton getInstace() {
        if(instance == null) {
            instance = new AppDataSingleton();
            return instance;
        }
        return  instance;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public OwnerUser getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(OwnerUser ownerUser) {
        this.ownerUser = ownerUser;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Tag getTags() {
        return tags;
    }

    public void setTags(Tag tags) {
        this.tags = tags;
    }

    public EventListResponse getEventListResponse() {
        return eventListResponse;
    }

    public void setEventListResponse(EventListResponse eventListResponse) {
        this.eventListResponse = eventListResponse;
    }
    
    private void fillEventList() {
        String name = "Forró de Natal";
        String date = "14/12/2017";
        String description = "Forró de Natal para a Terceira Idade. Compre seu ingresso: 20 reais para a melhor idade.";
        
        int i = 0;
        List<Event> events = new ArrayList<Event>();
        
        for(i=0; i<36; i++) {
            Event event = new Event(0, name, description, date, null, 0, null);
            events.add(event);
        }

        this.eventListResponse =  new EventListResponse(events);
    }
}
