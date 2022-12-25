package com.sportsinteactive.task.UI.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonObject;
import com.sportsinteactive.task.UI.model.MatchDetailsModel;
import com.sportsinteactive.task.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchViewModel extends ViewModel {

    private static final String TAG = "MatchViewModel";
    private MutableLiveData<MatchDetailsModel.MatchDetailsData> matchLiveData=new MutableLiveData<>();
    private MutableLiveData<JsonObject> teamsJsonData = new MutableLiveData<>();


    public void getMatchDetails(Context context){

        new ApiService().init().getMatchDetails().enqueue(new Callback<MatchDetailsModel>() {
            @Override
            public void onResponse(Call<MatchDetailsModel> call, Response<MatchDetailsModel> response) {
                Log.d("Response",response.body().getMatchDetail().toString());

                if (response!=null){
                    try {
                        if (response.body().getMatchDetail()!=null){
                            matchLiveData.postValue(response.body().getMatchDetail());
                            teamsJsonData.postValue(response.body().getTeams());

                            Log.d(TAG, "Api: "+response.raw().request().url());
                            Log.d(TAG, "onResponse: "+response);
                        }else {
                            MatchDetailsModel.MatchDetailsData matchDetailsData = new MatchDetailsModel.MatchDetailsData();
                            matchLiveData.postValue(matchDetailsData);
                            teamsJsonData.postValue(new JsonObject());
                            Toast.makeText(context, "No Data found", Toast.LENGTH_SHORT).show();
                        }

                    }catch (Exception e){
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                }
            }

            @Override
            public void onFailure(Call<MatchDetailsModel> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public MutableLiveData<MatchDetailsModel.MatchDetailsData> getMatchLiveData() {
        return matchLiveData;
    }

    public MutableLiveData<JsonObject> getTeamsJsonData() {
        return teamsJsonData;
    }
}
