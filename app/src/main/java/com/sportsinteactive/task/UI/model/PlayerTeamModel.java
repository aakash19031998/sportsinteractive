package com.sportsinteactive.task.UI.model;

import java.util.ArrayList;

public class PlayerTeamModel {


    private String teamFullName;
    private String ShortFullName;

    private ArrayList<playersDetailsModel> playerArray;


    public static class playersDetailsModel{

        String playerName;
        Boolean isKeeper = false;
        Boolean isCaptain = false;
        String battingStyle;
        String bowlingStyle;

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public Boolean getKeeper() {
            return isKeeper;
        }

        public void setKeeper(Boolean keeper) {
            isKeeper = keeper;
        }

        public Boolean getCaptain() {
            return isCaptain;
        }

        public void setCaptain(Boolean captain) {
            isCaptain = captain;
        }

        public String getBattingStyle() {
            return battingStyle;
        }

        public void setBattingStyle(String battingStyle) {
            this.battingStyle = battingStyle;
        }

        public String getBowlingStyle() {
            return bowlingStyle;
        }

        public void setBowlingStyle(String bowlingStyle) {
            this.bowlingStyle = bowlingStyle;
        }
    }

    public String getTeamFullName() {
        return teamFullName;
    }

    public void setTeamFullName(String teamFullName) {
        this.teamFullName = teamFullName;
    }

    public String getShortFullName() {
        return ShortFullName;
    }

    public void setShortFullName(String shortFullName) {
        ShortFullName = shortFullName;
    }

    public ArrayList<playersDetailsModel> getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(ArrayList<playersDetailsModel> playerArray) {
        this.playerArray = playerArray;
    }
}
