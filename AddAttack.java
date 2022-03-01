package Dungeon.Item;

import Dungeon.role.Mercenary;

import java.util.Random;

public class AddAttack extends Item{
    private String name = "狂热药剂";
    private int time;
    private int num;

    public AddAttack() {

    }

    public String describe(){
        return ":为你的城镇带来更狂热的收入!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJudge() {
        return 0;
    }


    public void use(Mercenary mer){
        Random k = new Random();
        mer.setAttack(mer.getAttack()+k.nextInt(5)+1);
        System.out.println("佣兵的攻击力上升了!");
        this.setNum(this.getNum()-1);
    }
}
