package Dungeon.treasure;

import Dungeon.Item.Item;

public abstract class Treasure extends Item{
    private int value;

    public abstract String describe();

    public abstract int getJudge();

    public Treasure(){

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
