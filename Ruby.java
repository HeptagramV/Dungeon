package Dungeon.treasure;

public class Ruby extends Treasure{
    private String name ="红宝石";
    private int value = 1250;

    public String describe(){
        return "鲜红如燃烧的色欲...";
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
