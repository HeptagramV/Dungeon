package Dungeon.treasure;

public class Beryl extends Treasure{
    private String name ="绿宝石";
    private int value = 750;

    public String describe(){
        return "翠绿如熔化的妒忌...";
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
