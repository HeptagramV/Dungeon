package Dungeon.treasure;

public class Emerald extends Treasure{
    private String name ="翡翠";
    private int value = 375;

    public String describe(){
        return "暗绿如腐败的肉体...";
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
