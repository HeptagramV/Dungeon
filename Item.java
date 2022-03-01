package Dungeon.Item;

import Dungeon.role.Mercenary;

public class Item {
    private String name;
    private int num;
    private int value;

    public Item(String name,int num){
        this.name = name;
        this.num = 1;
    }

    public String describe(){
        return "0";
    }

    public Item(){
        num = 1;
    }

    public void use(Mercenary mer){

    }

    public int getJudge(){
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
