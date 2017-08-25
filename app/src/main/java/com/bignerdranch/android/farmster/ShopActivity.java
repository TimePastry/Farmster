package com.bignerdranch.android.farmster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.farmster.PlayerModel.Egg;
import com.bignerdranch.android.farmster.PlayerModel.Player;
import com.bignerdranch.android.farmster.PlayerModel.Race;

import java.util.Random;

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

        Button purchaseButton = (Button) findViewById(R.id.shop_purchase_button);
        Button backButton = (Button) findViewById(R.id.shop_back_button);
        mCoinsView = (TextView) findViewById(R.id.shop_coins_view);
        mEggsView = (TextView) findViewById(R.id.shop_eggs_view);
        updateMenuText();

        purchaseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                if (mPlayer.getCoins() < 10){
                    Toast.makeText(ShopActivity.this, R.string.shop_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                mPlayer.setCoins(mPlayer.getCoins() - EGG_COST);
                mPlayer.addEgg(createEgg());
                updateMenuText();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                //startActivity(new Intent(ShopActivity.this, FarmActivity.class));
            }
        });

    }

    private Egg createEgg() {
        Random random = new Random();
        int newMight = random.nextInt(5);
        int newIntelligence = random.nextInt(5);
        int newBeauty = random.nextInt(5);
        return new Egg(newMight, newIntelligence, newBeauty, Race.BEAR);
    }

    private void updateMenuText(){
        mCoinsView.setText(getString(R.string.menu_coins) + " " + mPlayer.getCoins());
        mEggsView.setText(getString(R.string.menu_eggs) + " " + mPlayer.getEggCount());
    }

}
