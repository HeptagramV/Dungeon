package Dungeon.skills;

import Dungeon.role.Mercenary;
import Dungeon.role.Monster;

import java.util.Random;

public class HolyPray extends Skill{

    public void use(Mercenary mer, Monster mon) {
        int ju,at;
        Random k = new Random();
        ju = k.nextInt(2);
        at = (k.nextInt(5)+1)*((ju==0)?1:-1)+mer.getAttack()/2*3-mon.getDefense()/5;
        if(k.nextInt(100)<= mer.getCritical()){
            at+=at/=2;
            System.out.println(mer.getName()+"暴击!");
        }
        mer.setHp(mer.getHp()+10);
        if(mer.getHp()>mer.getStHp())mer.setHp(mer.getStHp());
        System.out.println("勇士的伤口得到了治愈!");
    }
    public String describe(){
        return " :{圣光在地牢中依旧治愈身心}";
    }

    public HolyPray(String name){
        super(name);
    }

}
