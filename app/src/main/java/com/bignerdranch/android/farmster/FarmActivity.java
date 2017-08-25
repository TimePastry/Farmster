package com.bignerdranch.android.farmster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bignerdranch.android.farmster.PlayerModel.Player;

public class FarmActivity extends AppCompatActivity {

    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);

        mPlayer = Player.getInstance();
    }
}
