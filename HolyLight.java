package Dungeon.skills;

import Dungeon.role.Mercenary;
import Dungeon.role.Monster;

import java.util.Random;

public class HolyLight extends Skill{

    public void use(Mercenary mer, Monster mon) {
        int ju,at;
        Random k = new Random();
        ju = k.nextInt(2);
        at = (k.nextInt(5)+1)*((ju==0)?1:-1)+mer.getAttack()/2*3-mon.getDefense()/5;
        if(k.nextInt(100)<= mer.getCritical()){
            at += at/3;
            System.out.println(mer.getName()+"打出了暴击!");
        }
        if(at <= 0) System.out.println(mon.getRace()+" miss了"+mer.getName()+"的攻击!");
        else{
            mon.setHp(mon.getHp()-at);
            System.out.println(mon.getRace()+"损失了"+at+"点血量");
        }
    }
    public String describe(){
        return " :{圣光将制裁邪恶的血肉}";
    }

    public HolyLight(String name){
        super(name);
    }

}
