package com.sportsinteactive.task.UI.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sportsinteactive.task.R;
import com.sportsinteactive.task.UI.model.PlayerTeamModel;
import com.sportsinteactive.task.databinding.HomeRowBinding;
import com.sportsinteactive.task.databinding.ItemPlayerListBinding;

import java.util.ArrayList;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.PlayerListHolder> {

    private Context context;
    ArrayList<PlayerTeamModel.playersDetailsModel> playerList = new ArrayList<>();

    public PlayerListAdapter(Context context, ArrayList<PlayerTeamModel.playersDetailsModel> playerList) {
        this.context = context;
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public PlayerListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPlayerListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_player_list, parent, false);

        return new PlayerListHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerListHolder holder, int position) {

        PlayerTeamModel.playersDetailsModel playersDetailsModel = playerList.get(position);

        holder.itemPlayerListBinding.playername.setText(playersDetailsModel.getPlayerName());
        String status = "";
        if (playersDetailsModel.getCaptain()){
            if (status.isEmpty()) {
                status = "c";
            }else {
                status = status + "&" + "c";
            }
        }

        if (playersDetailsModel.getKeeper()){
            if (status.isEmpty()) {
                status = "wk";
            }else {
                status = status + "&" + "wk";
            }
        }

        if (!status.isEmpty()) {
            holder.itemPlayerListBinding.playername.setText(playersDetailsModel.getPlayerName() + " (" + status + ")");
        }else {
            holder.itemPlayerListBinding.playername.setText(playersDetailsModel.getPlayerName());
        }

        holder.itemPlayerListBinding.playername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(context)
                        .setTitle("Player Details")
                        .setMessage("Batting Style :- "+playersDetailsModel.getBattingStyle()+" Bowling Style :- " +playersDetailsModel.getBowlingStyle())
                        .setCancelable(false)

                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class PlayerListHolder extends RecyclerView.ViewHolder{


        private ItemPlayerListBinding itemPlayerListBinding;


        public PlayerListHolder(ItemPlayerListBinding itemPlayerListBinding) {
            super(itemPlayerListBinding.getRoot());
            this.itemPlayerListBinding = itemPlayerListBinding;
        }
    }

}
