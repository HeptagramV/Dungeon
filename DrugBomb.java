package Dungeon.skills;

import Dungeon.role.Mercenary;
import Dungeon.role.Monster;

import java.util.Random;

public class DrugBomb extends Skill{

    public void use(Mercenary mer, Monster mon) {
        int ju,at;
        Random k = new Random();
        ju = k.nextInt(2);
        at = (k.nextInt(5)+1)*((ju==0)?1:-1)+mer.getAttack()/2*3-mon.getDefense()/5;
        if(k.nextInt(100)<= mer.getCritical()){
            at/=2;
            System.out.println(mer.getName()+"打出了暴击!");
        }
        if(at <= 0) System.out.println(mon.getRace()+" miss了"+mer.getName()+"的攻击!");
        else{
            at/=3;
            mon.setHp(mon.getHp()-at);
            mon.setDefense(mon.getDefense()-k.nextInt(7)-1);
            if(mon.getDefense() == 0)mon.setDefense(0);
            System.out.println(mon.getRace()+"损失了"+at+"点血量并被瘟毒腐蚀了装甲");
        }
    }
    public String describe(){
        return " :{制作毒药的医生才能在这地牢中满载而归}";
    }

    public DrugBomb(String name){
        super(name);
    }

}
