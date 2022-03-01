package Dungeon.Item;

import Dungeon.role.Mercenary;

public class AddSpeed extends Item{

    private String name = "神速药剂";
    private int time;
    private int num;

    public AddSpeed() {

    }

    public String describe(){
        return ":快速将敌人劫掠一空!";
    }

    public String getName(){
        return name;
    }

    public int getJudge() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void use(Mercenary mer){
        mer.setSpeed(mer.getSpeed()+1);
        if(mer.getSpeed()>=10)mer.setSpeed(9);
        System.out.println("佣兵的速度上升了!");
        this.setNum(this.getNum()-1);
    }
}
