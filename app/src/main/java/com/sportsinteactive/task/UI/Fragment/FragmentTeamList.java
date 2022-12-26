package com.sportsinteactive.task.UI.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sportsinteactive.task.UI.adapter.PlayerListAdapter;
import com.sportsinteactive.task.UI.model.PlayerTeamModel;
import com.sportsinteactive.task.databinding.FragmentTeamListBinding;

import java.util.ArrayList;

public class FragmentTeamList extends Fragment {

    FragmentTeamListBinding binding;
    private ArrayList<PlayerTeamModel.playersDetailsModel> playerTeamModels = new ArrayList<>();
    Context context;
    private  PlayerListAdapter playerListAdapter;

    public static FragmentTeamList newInstance(Context mContext, ArrayList<PlayerTeamModel.playersDetailsModel> list) {
        FragmentTeamList fragment = new FragmentTeamList();
        fragment.playerTeamModels = list;
        fragment.context = mContext;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         binding = FragmentTeamListBinding.inflate(inflater, container, false);
        //set variables in Binding

        return binding.getRoot();

    }

    @Override
    public void onResume() {
        super.onResume();
        binding.recyclerviewTeamList.setLayoutManager(new LinearLayoutManager(context));
        playerListAdapter = new PlayerListAdapter(context,playerTeamModels);
        binding.recyclerviewTeamList.setAdapter(playerListAdapter);
    }
}
