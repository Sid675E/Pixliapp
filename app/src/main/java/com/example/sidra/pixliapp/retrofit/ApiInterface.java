package com.example.sidra.pixliapp.retrofit;

import com.example.sidra.pixliapp.CustomViewEventList;
import com.example.sidra.pixliapp.CustomViewHolder;
import com.example.sidra.pixliapp.CustomViewPhotosHolder;
import com.example.sidra.pixliapp.CustomViewPhotosResponse;
import com.example.sidra.pixliapp.CustomViewResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by sidra on 21-10-2016.
 */

public interface ApiInterface {

    @POST("/users/{username}/{email_id}")
    Call<Void> createUsers(@Path("username") String usrname,@Path("email_id") String emai_id);

    //@Header(Authorization) This url returns a token in exchange for login/logup details
    @GET("/token")
    Call<ResponseBody> getToken();

    //Gets the the list of hosyed and guest events of a user
    @GET("/pixget/{email_id}/elist")
    Call<CustomViewEventList> getEventList(@Path("email_id") String email_Id);

    //Checks if the event code(unique) provided exits
    @GET("/pixget/{event_id}/event")
    Call<ResponseBody> getEventsExits(@Path("event_id") String eventId);

    //Creates a new event
    @POST("/pixpost/events/{email_id}")
    Call<CustomViewResponse> createEvent(@Body CustomViewHolder task,@Path("email_id") String email_Id);

    //Gets the count of photos (no. of) linked to given event unique code.
    @GET("/pixget/photos/{event_id}/count")
    Call<ResponseBody> getCountOfPhotos(@Path("event_id") String eventId);

    //Gets the photo names linked to given event unique code.
    @GET("/pixpost/photos/{event_id}")
    Call<CustomViewPhotosResponse> getPhotosOfEvent(@Path("event_id") String eventId);

    //Stores the details related to a photo in the database
    @POST("/pixpost/photos/{event_id}")
    Call<CustomViewPhotosResponse> createPhotos(@Path("event_id") String eventId,@Body CustomViewPhotosHolder task);

}
