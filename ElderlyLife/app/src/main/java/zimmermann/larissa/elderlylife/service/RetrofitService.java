package zimmermann.larissa.elderlylife.service;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import zimmermann.larissa.elderlylife.Structure.Address;
import zimmermann.larissa.elderlylife.Structure.AddressesListResponse;
import zimmermann.larissa.elderlylife.Structure.AppUser;
import zimmermann.larissa.elderlylife.Structure.AppUsersListResponse;
import zimmermann.larissa.elderlylife.Structure.Event;
import zimmermann.larissa.elderlylife.Structure.EventListResponse;
import zimmermann.larissa.elderlylife.Structure.OwnerUser;
import zimmermann.larissa.elderlylife.Structure.OwnerUserListResponse;
import zimmermann.larissa.elderlylife.Structure.UserPathListResponse;
import zimmermann.larissa.elderlylife.Structure.UserPath;

/**
 * Created by laris on 11/08/2017.
 */

public interface RetrofitService {

//-------- Address --------//
    @GET("addresses/")
    Call<AddressesListResponse> getAllAddress();

    @POST("addresses/")
    Call<Address> createNewAddress(@Body Address address);

    @GET("addresses/{id}")
    Call<AddressesListResponse> getAddressesByID(@Path("id") int id);

    @PUT("addresses/{id}")
    Call<Address> editAddressByID(@Path("id") int id, @Body Address address);

    @DELETE("addresses/{id}")
    Call<Address> deleteAddressByID(@Path("id") int id);

//-------- Events --------//
    @GET("events")
    Call<EventListResponse> getAllEvents();

    @GET("events")
    Call<EventListResponse> getEventsNearMe(@Query("residential") boolean residential);

    @GET("events")
    Call<EventListResponse> getEventsNearFromPath(@Query("path") boolean path);

    @GET("events")
    Call<EventListResponse> getEventsNearCoordinate(@Query("current") boolean current,
                                                    @Field("lat") double lat,
                                                    @Field("long") double longitude);

    @GET("events")
    Call<EventListResponse> getEventsByOwnerID(@Query("owner") int ownerID);

    @GET("events/{id}")
    Call<Event> getEventByID(@Path("id") int id);

    @PUT("events/{id}")
    Call<Event> editEventByID(@Path("id") int id, @Body Event event);

    @DELETE("events/{id}")
    Call<Event> deleteEventByID(@Path("id") int id);

//-------- Event Owners --------//

    @GET("event-owners")
    Call<OwnerUserListResponse> getAllOwnerUsers();

    @POST("event-owners")
    Call<OwnerUser> createNewOwnerUser(@Body OwnerUser ownerUser);

    @GET("event-owners/{id}")
    Call<OwnerUser> getOwnerUserByID(@Path("id") int id);

    @PUT("event-owners/{id}")
    Call<OwnerUser> editOwnerUserByID(@Path("id") int id, @Body OwnerUser ownerUser);

    @DELETE("event-owner/{id}")
    Call<OwnerUser> deleteOwnerUSerByID(@Path("id") int id);

//-------- App Users --------//

    @GET("app-users")
    Call<AppUsersListResponse> getAllAppUsers();

    @POST("app-users")
    Call<AppUser> createNewAppUser(@Body AppUser appUser);

    @GET("app-users/{id}")
    Call<AppUser> getAppUserByID(@Path("id") int id);

    @PUT("app-users/{id}")
    Call<AppUser> editAppUserByID(@Path("id") int id, @Body AppUser appUser);

    @DELETE("app-users/{id}")
    Call<AppUser> deleteAppUserByID(@Path("id") int id);

//-------- UserPath --------//

    @GET("paths")
    Call<UserPathListResponse> getAllPaths();

    @POST("paths")
    Call<UserPath> createNewUserPath(@Body UserPath userPath);

    @GET("paths/{id}")
    Call<UserPath> getUserPathByID(@Path("id") int id);

    @PUT("paths/{id}")
    Call<UserPath> editUserPathByID(@Path("id") int id, @Body UserPath userPath);

    @DELETE("paths/{id}")
    Call<UserPath> deleteUserPathByID(@Path("id") int id);

//-------- Login --------//

    @POST("paths")
    Call<JsonObject> login(@Field("username") String username,
                           @Field("password") String password); //Read Json Object


}
