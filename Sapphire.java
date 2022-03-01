package Dungeon.treasure;

public class Sapphire extends Treasure{
    private String name ="蓝宝石";
    private int value = 1000;

    public String describe(){
        return "湛蓝如扼紧的梦境...";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getJudge() {
        return 1;
    }
}
