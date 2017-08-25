package com.bignerdranch.android.farmster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.farmster.PlayerModel.Egg;
import com.bignerdranch.android.farmster.PlayerModel.Player;

public class ShopActivity extends AppCompatActivity {

    private Player mPlayer;
    private TextView mCoinsView;
    private TextView mEggsView;
    private final int EGG_COST = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mPlayer = Player.getInstance();

        Button purchaseButton = (Button) findViewById(R.id.purchase_button);
        mCoinsView = (TextView) findViewById(R.id.coins_view);
        mEggsView = (TextView) findViewById(R.id.eggs_view);
        updateCounts();

        purchaseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                if (mPlayer.getCoins() < 10){
                    Toast.makeText(ShopActivity.this, R.string.shop_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                mPlayer.setCoins(mPlayer.getCoins() - EGG_COST);
                mPlayer.addEgg(createEgg());
                updateCounts();
            }
        });

        //todo set listener to go to farm
    }

    private Egg createEgg() {
        //todo make a random egg
        return null;
    }

    private void updateCounts(){
        mCoinsView.setText(getString(R.string.menu_coins) + " " + mPlayer.getCoins());
        mEggsView.setText(getString(R.string.menu_eggs) + " " + mPlayer.getEggCount());
    }

}
