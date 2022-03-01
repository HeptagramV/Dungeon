package Dungeon.treasure;

public class Agate extends Treasure{
    private String name ="玛瑙";
    private int value = 500;

    public String describe(){
        return "漆黑如无尽的黑夜...";
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
