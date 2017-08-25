package com.bignerdranch.android.farmster.PlayerModel;

public class Player {
    private static Player sPlayer;

    public static Player getInstance() {
        if (sPlayer == null){
            sPlayer = new Player();
        }
        return sPlayer;
    }

    private int mCoins;
    private int mEggs;

    private Player(){
        mCoins = 100;
        mEggs = 0;
    }

    public int getCoins() {
        return mCoins;
    }

    public void setCoins(int coins) {
        mCoins = coins;
    }

    public int getEggs() {
        return mEggs;
    }

    public void setEggs(int eggs) {
        mEggs = eggs;
    }
}
