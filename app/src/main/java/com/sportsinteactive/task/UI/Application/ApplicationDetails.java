package com.sportsinteactive.task.UI.Application;

import android.app.Application;

import com.sportsinteactive.task.UI.model.PlayerTeamModel;

import java.util.ArrayList;

public class ApplicationDetails extends Application {

    ArrayList<PlayerTeamModel> playerTeamModels = new ArrayList<>();
    private static ApplicationDetails instance = null;

    public static ApplicationDetails getInstance()   {
        return instance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public ArrayList<PlayerTeamModel> getPlayerTeamModels() {
        return playerTeamModels;
    }

    public void setPlayerTeamModels(ArrayList<PlayerTeamModel> playerTeamModels) {
        this.playerTeamModels = playerTeamModels;
    }
}
