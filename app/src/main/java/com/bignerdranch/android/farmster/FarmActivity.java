package com.bignerdranch.android.farmster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.farmster.PlayerModel.Player;

public class FarmActivity extends AppCompatActivity {

    private Player mPlayer;
    private TextView mEggView;
    private TextView mCoinView;
    private TextView mMonsterView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);

        mPlayer = Player.getInstance();

        Button hatchButton = (Button) findViewById(R.id.farm_hatch_button);
        Button checkButton = (Button) findViewById(R.id.farm_check_button);
        Button shopButton = (Button) findViewById(R.id.farm_shop_button);

        mEggView = (TextView) findViewById(R.id.farm_eggs_view);
        mCoinView = (TextView) findViewById(R.id.farm_coins_view);
        mMonsterView = (TextView) findViewById(R.id.farm_monsters_view);
        updateMenuText();

        hatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPlayer.getEggCount() < 1){
                    Toast.makeText(FarmActivity.this, R.string.farm_hatch_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                mPlayer.hatchEgg();
                updateMenuText();
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FarmActivity.this, "Still in development", Toast.LENGTH_SHORT).show();
            }
        });

        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FarmActivity.this, ShopActivity.class));
            }
        });
    }

    private void updateMenuText(){
        mCoinView.setText(getString(R.string.menu_coins) + " " + mPlayer.getCoins());
        mEggView.setText(getString(R.string.menu_eggs) + " " + mPlayer.getEggCount());
        mMonsterView.setText(getString(R.string.menu_monsters) + " " + mPlayer.getMonsterCount());
    }
}
