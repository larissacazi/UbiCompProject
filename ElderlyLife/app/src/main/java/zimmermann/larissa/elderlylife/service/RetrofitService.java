package zimmermann.larissa.elderlylife.service;

import android.media.session.MediaSession;
import android.support.v4.media.session.MediaSessionCompat;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
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
    Call<AddressesListResponse> getAllAddress(@Header("authorization") String token);

    @POST("addresses/")
    Call<Address> createNewAddress(@Header("authorization") String token,
                                    @Body Address address);

    @GET("addresses/{id}")
    Call<AddressesListResponse> getAddressesByID(@Header("authorization") String token, @Path("id") int id);

    @PUT("addresses/{id}")
    Call<Address> editAddressByID(@Header("authorization") String token, @Path("id") int id, @Body Address address);

    @DELETE("addresses/{id}")
    Call<Address> deleteAddressByID(@Header("authorization") String token, @Path("id") int id);

//-------- Events --------//
    @GET("events/")
    Call<EventListResponse> getAllEvents(@Header("Authorization") String token);

    @GET("events/")
    Call<EventListResponse> getEventsNearMe(@Header("authorization") String token, @Query("residential") boolean residential);

    @GET("events/")
    Call<EventListResponse> getEventsNearFromPath(@Header("authorization") String token, @Query("path") boolean path);

    @GET("events/")
    Call<EventListResponse> getEventsNearCoordinate(@Header("authorization") String token, @Query("current") boolean current,
                                                    @Field("lat") double lat,
                                                    @Field("long") double longitude);

    @GET("events")
    Call<EventListResponse> getEventsByOwnerID(@Header("authorization") String token, @Query("owner") int ownerID);

    @GET("events/{id}")
    Call<Event> getEventByID(@Header("authorization") String token, @Path("id") int id);

    @PUT("events/{id}")
    Call<Event> editEventByID(@Header("authorization") String token, @Path("id") int id, @Body Event event);

    @DELETE("events/{id}")
    Call<Event> deleteEventByID(@Header("authorization") String token, @Path("id") int id);

//-------- Event Owners --------//

    @GET("event-owners")
    Call<OwnerUserListResponse> getAllOwnerUsers(@Header("authorization") String token);

    @POST("event-owners")
    Call<OwnerUser> createNewOwnerUser(@Header("authorization") String token, @Body OwnerUser ownerUser);

    @GET("event-owners/{id}")
    Call<OwnerUser> getOwnerUserByID(@Header("authorization") String token, @Path("id") int id);

    @PUT("event-owners/{id}")
    Call<OwnerUser> editOwnerUserByID(@Header("authorization") String token, @Path("id") int id, @Body OwnerUser ownerUser);

    @DELETE("event-owner/{id}")
    Call<OwnerUser> deleteOwnerUSerByID(@Header("authorization") String token, @Path("id") int id);

//-------- App Users --------//

    @GET("app-users")
    Call<AppUsersListResponse> getAllAppUsers(@Header("authorization") String token);

    @POST("app-users")
    Call<AppUser> createNewAppUser(@Header("authorization") String token, @Body AppUser appUser);

    @GET("app-users/{id}")
    Call<AppUser> getAppUserByID(@Header("authorization") String token, @Path("id") int id);

    @PUT("app-users/{id}")
    Call<AppUser> editAppUserByID(@Header("authorization") String token, @Path("id") int id, @Body AppUser appUser);

    @DELETE("app-users/{id}")
    Call<AppUser> deleteAppUserByID(@Header("authorization") String token, @Path("id") int id);

//-------- UserPath --------//

    @GET("paths")
    Call<UserPathListResponse> getAllPaths(@Header("authorization") String token);

    @POST("paths")
    Call<UserPath> createNewUserPath(@Header("authorization") String token, @Body UserPath userPath);

    @GET("paths/{id}")
    Call<UserPath> getUserPathByID(@Header("authorization") String token, @Path("id") int id);

    @PUT("paths/{id}")
    Call<UserPath> editUserPathByID(@Header("authorization") String token, @Path("id") int id, @Body UserPath userPath);

    @DELETE("paths/{id}")
    Call<UserPath> deleteUserPathByID(@Header("authorization") String token, @Path("id") int id);

//-------- Login --------//

    @POST("login/")
    @FormUrlEncoded
    Call<JsonObject> login(@Field("username") String username,
                           @Field("password") String password);

    @GET("logout/")
    Call<JsonObject> logout(@Header("Authorization") String token);


}
