package com.bignerdranch.android.farmster.PlayerModel;

public class Monster {
    protected int mMight;
    protected int mIntelligence;
    protected int mBeauty;
    protected Race mRace;

    protected Monster() {}

    public Monster(Egg egg){
        mMight = egg.mMight;
        mIntelligence = egg.mIntelligence;
        mBeauty = egg.mBeauty;
        mRace = egg.mRace;
    }

    public int getMight() {
        return mMight;
    }

    public void setMight(int might) {
        mMight = might;
    }

    public int getIntelligence() {
        return mIntelligence;
    }

    public void setIntelligence(int intelligence) {
        mIntelligence = intelligence;
    }

    public int getBeauty() {
        return mBeauty;
    }

    public void setBeauty(int beauty) {
        mBeauty = beauty;
    }
}
