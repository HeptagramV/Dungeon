package Dungeon.Item;

import Dungeon.role.Mercenary;

public class AddBlood extends Item{
    private String name = "回复药剂";
    private int time;
    private int num;

    public AddBlood() {

    }

    public String describe(){
        return ":瞬间恢复10点血量!佣兵们可以为你流更多的血!";
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
        mer.setHp(mer.getHp()+10);
        if(mer.getHp()>mer.getStHp())mer.setHp(mer.getStHp());
        System.out.println("佣兵感到精神焕发!");
        this.setNum(this.getNum()-1);
    }
}
