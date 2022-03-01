package Dungeon.skills;

import Dungeon.role.Mercenary;
import Dungeon.role.Monster;

import java.util.Random;

public class SincereComplaint extends Skill {

    public void use(Mercenary mer, Monster mon) {
        int ju,at;
        Random k = new Random();
        ju = k.nextInt(2);
        at = (k.nextInt(5)+1)*((ju==0)?1:-1)+mer.getAttack()/2*3-mon.getDefense()/5;
        if(k.nextInt(100)<= mer.getCritical()){
            System.out.println(mer.getName()+"打出了暴击!");
        }
        if(at <= 0) System.out.println(mon.getRace()+" miss了"+mer.getName()+"的攻击!");
        else{
            at = at/2;
            mon.setHp(mon.getHp()-at);int f = k.nextInt(5)+1;
            mon.setAttack(mon.getAttack()-f);
            if(mon.getAttack() == 0)mon.setAttack(1);
            System.out.println(mon.getRace()+"损失了"+at+"点血量并且攻击力降低了");
        }
    }

    public String describe(){
        return " :{骑士无畏的信仰让邪秽无处遁形}";
    }

    public SincereComplaint(String name){
        super(name);
    }
}
