package com.sportsinteactive.task.UI.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sportsinteactive.task.R;
import com.sportsinteactive.task.UI.Application.ApplicationDetails;
import com.sportsinteactive.task.UI.PassArrayList;
import com.sportsinteactive.task.UI.activity.PlayerDetailsActivity;
import com.sportsinteactive.task.UI.model.MatchDetailsModel;
import com.sportsinteactive.task.UI.model.PlayerTeamModel;
import com.sportsinteactive.task.databinding.HomeRowBinding;


import java.io.Serializable;
import java.util.ArrayList;

public class MatchDetailsAdapter extends RecyclerView.Adapter<MatchDetailsAdapter.MatchDetailsHolder> {


    private Context context;
    private ArrayList<MatchDetailsModel.MatchDetailsData> list;
    private ArrayList<PlayerTeamModel> playerTeamModels;


    public MatchDetailsAdapter(Context context, ArrayList<MatchDetailsModel.MatchDetailsData> list, ArrayList<PlayerTeamModel> playerTeamModels) {
        this.context = context;
        this.list = list;
        this.playerTeamModels = playerTeamModels;
    }

    public void dataNotifyChanged(ArrayList<MatchDetailsModel.MatchDetailsData> list){
        this.list=list;
        notifyDataSetChanged();
    }

    public void dataNotifyChangedPlayer(ArrayList<PlayerTeamModel> playerTeamModel){
        this.playerTeamModels=playerTeamModel;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MatchDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HomeRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.home_row, parent, false);

        return new MatchDetailsHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchDetailsHolder holder, int position) {

        MatchDetailsModel.MatchDetailsData matchDetailsDataModel = list.get(position);
        PlayerTeamModel playerTeamModel = playerTeamModels.get(position);

        holder.homeRowBinding.matchTitle.setText(playerTeamModels.get(0).getTeamFullName().toUpperCase() + " vs " + playerTeamModels.get(1).getTeamFullName().toUpperCase());
        holder.homeRowBinding.timeDate.setText("Date:- "+matchDetailsDataModel.getMatchData().getDate() +" Time:- "+ matchDetailsDataModel.getMatchData().getTime());
        holder.homeRowBinding.venue.setText(matchDetailsDataModel.getVenueDatailsData().getName());

        holder.homeRowBinding.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplicationDetails.getInstance().setPlayerTeamModels(playerTeamModels);
                Intent intent = new Intent(context, PlayerDetailsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MatchDetailsHolder extends RecyclerView.ViewHolder{


        private HomeRowBinding homeRowBinding;

        public MatchDetailsHolder(HomeRowBinding homeRowBinding) {
            super(homeRowBinding.getRoot());
            this.homeRowBinding = homeRowBinding;
        }
    }
}
