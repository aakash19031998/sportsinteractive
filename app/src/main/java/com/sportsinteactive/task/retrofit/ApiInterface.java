package com.sportsinteactive.task.retrofit;


import com.sportsinteactive.task.UI.model.MatchDetailsModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("nzin01312019187360.json")
    Call<MatchDetailsModel> getMatchDetails();
}
