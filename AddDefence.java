package Dungeon.Item;

import Dungeon.role.Mercenary;

import java.util.Random;

public class AddDefence extends Item{

    private String name = "坚定药剂";
    private int time;
    private int num;

    public AddDefence() {

    }

    public String describe(){
        return ":为金币带来更坚硬的保障!";
    }

    public String getName() {
        return name;
    }

    public int getJudge() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void use(Mercenary mer){
        Random k = new Random();
        mer.setDefense(mer.getDefense()+k.nextInt(5)+1);
        System.out.println("佣兵的防御力上升了!");
        this.setNum(this.getNum()-1);
    }
}
