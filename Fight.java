package Dungeon;

import Dungeon.Item.Item;
import Dungeon.role.Mercenary;
import Dungeon.role.Monster;
import Dungeon.skills.Skill;

import java.util.Random;
import java.util.Scanner;

public class Fight {
    public boolean RoundMer(Mercenary mer, Monster mon){
        Scanner in = new Scanner(System.in);
        System.out.println("轮到"+mer.getMajor()+mer.getName()+"的回合!");
        System.out.println("[0] 行动");
        System.out.println("[1] 道具");
        int js = in.nextInt();int ju;
        if(js == 1){
            if(mer.getBag().isEmpty()){
                System.out.println("你未拥有任何道具!,本回合将执行进攻");
                new Scanner(System.in).nextLine();
                js = 0;
            }
            else{
                System.out.println("以下是你拥有的道具:");int num = -1;
                for (Item s:mer.getBag()) System.out.println("["+(++num)+"] "+s.getName()+"*"+s.getNum()+s.describe());
                int use = in.nextInt();
               //0 mer.using.add(mer.bag)
                if(mer.getBag().size()<use){
                    System.out.println("不存在的道具");
                }
                else{
                    mer.getBag().get(use).use(mer);
                    if(mer.getBag().get(use).getNum() <= 0)mer.getBag().remove(use);
                }
            }
        }
        Random k = new Random();
        if(js == 0){
            System.out.println("选择一项技能使用:");int num = -1;
            for (Skill s:mer.getSkills())System.out.println("["+(++num)+"] "+s.getName()+s.describe());
            int use = in.nextInt();
            mer.getSkills().get(use).use(mer,mon);
        }
        if(!mon.IsLive()) {
            System.out.println(mon.getRace()+"倒下了!");
            int item = k.nextInt(100);
            Drop judge = new Drop();
            Item s = judge.judge();
            int num = 0,flag = 0;
            if(s.getJudge() == 0){
                for (Item ss:mer.getBag()){
                    if(ss.getName().equals(s.getName())){flag = 1;break;}
                    num++;
                }
                if(flag == 0)mer.getBag().add(s);
                else mer.getBag().get(num).setNum(mer.getBag().get(num).getNum()+1);
                System.out.println("掉落了"+s.getName());
            }
            else if(s.getJudge() == 1){
                for (Item ss:mer.getWallet()){
                    if(ss.getName().equals(s.getName())){flag = 1;break;}
                    num++;
                }
                if(flag == 0)mer.getWallet().add(s);
                else mer.getWallet().get(num).setNum(mer.getWallet().get(num).getNum()+1);
                System.out.println("掉落了"+s.getName());
            }
            mer.setExp(mer.getExp()+mon.getExp());
            new Scanner(System.in).nextLine();
            return false;
        }
        System.out.println(mer.toString() + "\t\t \t"  + mon.toString());
        new Scanner(System.in).nextLine();
        return true;
    }
    public boolean RoundMon(Mercenary mer,Monster mon){
        System.out.println("轮到"+mon.getRace()+"的回合!");
        Scanner in = new Scanner(System.in);
        int ju,at;
        Random k = new Random();
        ju = k.nextInt(2);
        at = (k.nextInt(5)+1)*((ju==0)?1:-1)+mon.getAttack()/2- mer.getDefense()/5;
        if(k.nextInt(100)<= mon.getCritical()){
            at += at/2;
            System.out.println(mon.getRace()+"打出了暴击!");
        }
        if(at <= 0) System.out.println(mer.getName()+" miss了"+mon.getRace()+"的攻击!");
        else{
            mer.setHp(mer.getHp()-at);
            System.out.println(mer.getMajor()+mer.getName()+"被"+mon.getRace()+"击中并损失了"+at+"点血量");
        }
        mon.setHp(mon.getHp()-at);
        if(!mer.IsLive()) {
            System.out.println(mer.getName()+"死去了!");
            new Scanner(System.in).nextLine();
            return false;
        };
        System.out.println(mer.toString() + "\t \t \t" + mon.toString());
        new Scanner(System.in).nextLine();
        return true;
    }

    public Boolean Fight(Mercenary mer,Shop shop) {
        Random k = new Random();
        Scanner in = new Scanner(System.in);
        int ju,at,time1,time2,flag = 0;
        while(true){
            Monster mon = new Monster();
            System.out.println(mer.getName()+"遇到了"+mon.toString()+"!");
            System.out.println("请问是否应战？");
            System.out.println("[0] 应战");
            System.out.println("[1] 逃跑");
            if(in.nextInt() == 1){
                if(k.nextInt(100)<80){
                    int kk = k.nextInt(2);
                    if(kk == 0) System.out.println("死里逃生...");
                    else System.out.println("逃过一劫...");
                    continue;
                }
                else{
                    int kk = k.nextInt(2);
                    if(kk == 0)System.out.println("怪物封死了所谓的退路...");
                    else System.out.println("怪物已在瞬间攻了过来...");
                    flag = 1;
                }
            }
            time1 = time2 = 10;
            while (true){
                if(flag == 1){
                    flag = 0;
                    if(!RoundMon(mer,mon))break;
                }
                time1 -= mer.getSpeed();
                time2 -= mon.getSpeed();
                if(time1<=0 && time2<=0){
                    time1 = 10;time2 = 10;
                    if(mer.getSpeed()>=mon.getSpeed()){
                        if(!RoundMer(mer,mon))break;
                        if(!RoundMon(mer,mon))break;
                    }
                    else{
                        if(!RoundMon(mer,mon))break;
                        if(!RoundMer(mer,mon))break;
                    }
                }
                else if(time1<=0){
                    time1 = 10;
                    if(!RoundMer(mer,mon))break;
                }
                else if(time2<=0){
                    time2 = 10;
                    if(!RoundMon(mer,mon))break;
                }
            }
            if(mer.IsLive()){
                System.out.println("[0] 继续战斗");
                System.out.println("[1] 原路返回");
                if(mer.getExp()>=mer.getLevel()*10){
                    System.out.println("佣兵的经验值已累积到一定程度，推荐返回城镇升级，当然您也可以让佣兵继续冒死作战:)");
                }
                int kk =in.nextInt();int money = 0;
                if(kk == 1){
                    System.out.println("以下是您此次冒险获得的战利品:");
                    for (Item s:mer.getWallet()){
                        System.out.println(s.getName()+"(价值"+s.getValue()+"$)*"+s.getNum()+":"+s.describe());
                        money += s.getValue()*s.getNum();
                    }
                    shop.setGoldNum(shop.getGoldNum()+money);
                    new Scanner(System.in).nextLine();
                    return true;
                }
                else if(kk != 0) System.out.println("请输入正确代号");
            }
            else {
                System.out.println("很遗憾，您要去雇佣新的替死鬼了");
                return false;
            }
        }
    }
}
