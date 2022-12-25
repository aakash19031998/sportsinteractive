package com.sportsinteactive.task.UI.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;

import com.sportsinteactive.task.R;
import com.sportsinteactive.task.UI.Application.ApplicationDetails;
import com.sportsinteactive.task.UI.Fragment.FragmentTeam1List;
import com.sportsinteactive.task.UI.adapter.TabViewPagerAdapter;
import com.sportsinteactive.task.UI.model.PlayerTeamModel;
import com.sportsinteactive.task.databinding.ActivityPlayerDetailsBinding;

import java.util.ArrayList;

public class PlayerDetailsActivity extends AppCompatActivity {

    ArrayList<PlayerTeamModel> playerList = new ArrayList<>();
    ArrayList<PlayerTeamModel.playersDetailsModel> team1 = new ArrayList<>();
    ArrayList<PlayerTeamModel.playersDetailsModel> team2 = new ArrayList<>();
    ActivityPlayerDetailsBinding binding;
    private Context mContext;
    FragmentTeam1List fragmentTeamList;
    FragmentTeam1List fragmentTeamList2;
    ArrayList<Fragment> listOfFragment = new ArrayList<>();
    TabViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        //setting binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player_details);

        playerList = ApplicationDetails.getInstance().getPlayerTeamModels();

        team1 = playerList.get(0).getPlayerArray();
        team2 = playerList.get(1).getPlayerArray();

        fragmentTeamList = FragmentTeam1List.newInstance(mContext,team1);
        fragmentTeamList2 = FragmentTeam1List.newInstance(mContext,team2);

        listOfFragment.add(fragmentTeamList);
        listOfFragment.add(fragmentTeamList2);

        viewPagerAdapter = new TabViewPagerAdapter(PlayerDetailsActivity.this, getSupportFragmentManager(), listOfFragment,playerList.get(0).getTeamFullName(),playerList.get(1).getTeamFullName());
        binding.container.setAdapter(viewPagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.container);


    }

}