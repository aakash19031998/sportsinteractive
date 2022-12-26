package com.sportsinteactive.task.UI.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.sportsinteactive.task.R;
import com.sportsinteactive.task.UI.adapter.MatchDetailsAdapter;
import com.sportsinteactive.task.UI.model.MatchDetailsModel;
import com.sportsinteactive.task.UI.model.PlayerTeamModel;
import com.sportsinteactive.task.UI.viewmodel.MatchViewModel;
import com.sportsinteactive.task.databinding.ActivityMainBinding;
import com.sportsinteactive.task.utils.Utility;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext;
    ActivityMainBinding binding;
    private MatchViewModel viewModel;
    private MatchDetailsAdapter adapter;
    private ArrayList<MatchDetailsModel.MatchDetailsData> homeDataList = new ArrayList<>();
    private JsonObject teamsDataObject = new JsonObject();
    ArrayList<PlayerTeamModel> newModelData = new ArrayList<>();
    ArrayList<PlayerTeamModel.playersDetailsModel> playersDetailsModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        //setting binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerviewMatchList.setLayoutManager(new LinearLayoutManager(mContext));

        viewModel = new ViewModelProvider(MainActivity.this).get(MatchViewModel.class);
        if (Utility.getInstance().checkInternetConnection(mContext)) {
            viewModel.getMatchDetails(mContext);
        }else {
            Toast.makeText(mContext,"No Internt Connection",Toast.LENGTH_SHORT).show();
        }


        adapter = new MatchDetailsAdapter(mContext, homeDataList, newModelData);
        binding.recyclerviewMatchList.setAdapter(adapter);



        viewModel.getMatchLiveData().observe(this, new Observer<MatchDetailsModel.MatchDetailsData>() {
            @Override
            public void onChanged(MatchDetailsModel.MatchDetailsData matchDetailsData) {
                if (matchDetailsData != null) {
                    homeDataList.add(matchDetailsData);
                    adapter.dataNotifyChanged(homeDataList);
                } else {
                    homeDataList.clear();
                    adapter.dataNotifyChanged(homeDataList);

                }
            }
        });

        viewModel.getTeamsJsonData().observe(this, new Observer<JsonObject>() {
            @Override
            public void onChanged(JsonObject jsonObject) {

                teamsDataObject = jsonObject;
                if (teamsDataObject != null) {
                    Iterator<String> keysString = teamsDataObject.keySet().iterator();
                    while (keysString.hasNext()) {
                        PlayerTeamModel models = new PlayerTeamModel();
                        JsonObject panel = teamsDataObject.getAsJsonObject(keysString.next()); // get key from list
                        String fullname = String.valueOf(panel.get("Name_Full")).replace("\"", "");
                        String shortName = String.valueOf(panel.get("Name_Short")).replace("\"", "");
                        models.setTeamFullName(fullname);
                        models.setShortFullName(shortName);
                        playersDetailsModel.clear();
                        JsonObject playersJsonObject = panel.getAsJsonObject("Players");
                        Iterator<String> playersKey = playersJsonObject.keySet().iterator();
                        while (playersKey.hasNext()) {
                            PlayerTeamModel.playersDetailsModel playersDetailsModels = new PlayerTeamModel.playersDetailsModel();
                            JsonObject playersObject = playersJsonObject.getAsJsonObject(playersKey.next());
                            String Name_Full = String.valueOf(playersObject.get("Name_Full")).replace("\"", "");
                            playersDetailsModels.setPlayerName(Name_Full);
                            if (playersObject.has("Iskeeper")) {
                                Boolean isKeeper = Boolean.parseBoolean(playersObject.get("Iskeeper").toString());
                                playersDetailsModels.setKeeper(isKeeper);
                            }
                            if (playersObject.has("Iscaptain")) {
                                Boolean isKeeper = Boolean.parseBoolean(playersObject.get("Iscaptain").toString());
                                playersDetailsModels.setCaptain(isKeeper);
                            }

                            JsonObject battingJson = playersObject.getAsJsonObject("Batting");
                            JsonObject bowlingJson = playersObject.getAsJsonObject("Bowling");
                            String battingStyle = String.valueOf(battingJson.get("Style")).replace("\"", "");
                            String bowlingStyle = String.valueOf(bowlingJson.get("Style")).replace("\"", "");
                            playersDetailsModels.setBattingStyle(battingStyle);
                            playersDetailsModels.setBowlingStyle(bowlingStyle);
                            playersDetailsModel.add(playersDetailsModels);

                        }
                        models.setPlayerArray(playersDetailsModel);
                        newModelData.add(models);
                        playersDetailsModel = new ArrayList<>();
                        Log.d("JSON", newModelData.toString());
                    }
                }


            }
        });


    }
}