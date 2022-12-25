package com.sportsinteactive.task.UI.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class MatchDetailsModel {

    @SerializedName("Matchdetail")
    public MatchDetailsData matchDetail;

    @SerializedName("Teams")
    private JsonObject teams;

    private String teamFullName;
    private String teamsShortName;

    private String playerName;
    private Boolean isKeeper;
    private String battingStyle;
    private String bowlingStyle;
    private Boolean isCaptain;

    public static class MatchDetailsData{

        @SerializedName("Match")
        MatchData matchData;

        @SerializedName("Venue")
        VenueDatailsData venueDatailsData;

        public MatchData getMatchData() {
            return matchData;
        }

        public void setMatchData(MatchData matchData) {
            this.matchData = matchData;
        }

        public VenueDatailsData getVenueDatailsData() {
            return venueDatailsData;
        }

        public void setVenueDatailsData(VenueDatailsData venueDatailsData) {
            this.venueDatailsData = venueDatailsData;
        }
    }

    public class MatchData{

        private String Type;
        private String Date;
        private String Time;

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            Date = date;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String time) {
            Time = time;
        }
    }

    public class VenueDatailsData{

        private String Id;
        private String Name;

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }
    }

    public MatchDetailsData getMatchDetail() {
        return matchDetail;
    }

    public void setMatchDetail(MatchDetailsData matchDetail) {
        this.matchDetail = matchDetail;
    }

    public JsonObject getTeams() {
        return teams;
    }

    public void setTeams(JsonObject teams) {
        this.teams = teams;
    }

    public String getTeamFullName() {
        return teamFullName;
    }

    public void setTeamFullName(String teamFullName) {
        this.teamFullName = teamFullName;
    }

    public String getTeamsShortName() {
        return teamsShortName;
    }

    public void setTeamsShortName(String teamsShortName) {
        this.teamsShortName = teamsShortName;
    }

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

    public Boolean getCaptain() {
        return isCaptain;
    }

    public void setCaptain(Boolean captain) {
        isCaptain = captain;
    }
}
