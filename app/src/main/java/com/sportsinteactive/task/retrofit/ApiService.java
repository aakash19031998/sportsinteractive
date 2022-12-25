package com.sportsinteactive.task.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private Retrofit retrofit;

    Gson gson=new GsonBuilder().
    setLenient().
            create();
  public ApiInterface  init(){
      retrofit=new Retrofit.Builder()
              .baseUrl(Constant.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create(gson))
              .build();

      return retrofit.create(ApiInterface.class);
    }

}
