package com.example.nestedjsonobject.network_service;


import com.example.nestedjsonobject.ui.model.MainModel;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {


    String ApiBaseUrl = "api/";  // base url live

    @GET(ApiBaseUrl+"users")
    Observable<MainModel> getInfo();


}
