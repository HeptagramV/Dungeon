package Dungeon.treasure;

public class Citrine extends Treasure{
    private String name ="黄水晶";
    private int value = 250;

    public String describe(){
        return "杏黄如消逝的希望...";
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
