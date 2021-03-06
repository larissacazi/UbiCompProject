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

    private String token;
    //User
    private AppUser appUser;
    private OwnerUser ownerUser;
    private int userType; // 1 -> appUser, 2 -> ownerUser

    //Tag
    private List<Tag> tags;

    //Event
    private EventListResponse eventListResponse;

    //Instance
    private static AppDataSingleton instance = null;

    private AppDataSingleton() {
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public EventListResponse getEventListResponse() {
        return eventListResponse;
    }

    public void setEventListResponse(EventListResponse eventListResponse) {
        this.eventListResponse = eventListResponse;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void clearInstace() {
        instance = null;
    }
}
