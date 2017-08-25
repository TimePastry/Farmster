package com.bignerdranch.android.farmster.PlayerModel;

import java.util.LinkedList;
import java.util.List;

public class Player {
    private static Player sPlayer;

    public static Player getInstance() {
        if (sPlayer == null){
            sPlayer = new Player();
        }
        return sPlayer;
    }

    private int mCoins;
    private List<Egg> mEggs;
    private List<Monster> mMonsters;

    private Player(){
        mCoins = 100;
        mEggs = new LinkedList<>();
        mMonsters = new LinkedList<>();
    }

    public int getCoins() {
        return mCoins;
    }

    public void setCoins(int coins) {
        mCoins = coins;
    }

    public int getEggCount(){
        return mEggs.size();
    }

    public int getMonsterCount(){
        return mMonsters.size();
    }

    public void addEgg(Egg egg){
        mEggs.add(egg);
    }

    private void addMonster(Monster monster){
        mMonsters.add(monster);
    }

    public List<Egg> getEggs() {
        return mEggs;
    }

    public void setEggs(List<Egg> eggs) {
        mEggs = eggs;
    }

    public List<Monster> getMonsters() {
        return mMonsters;
    }

    public void setMonsters(List<Monster> monsters) {
        mMonsters = monsters;
    }

    public void hatchEgg() {
        if (getEggCount() <= 0){
            return;
        }
        Egg egg = mEggs.remove(0);
        addMonster(new Monster(egg));
    }
}
