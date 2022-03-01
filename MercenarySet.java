package Dungeon;

import Dungeon.Interface.Frame;
import Dungeon.role.Mercenary;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MercenarySet {
    List<Mercenary>team = new ArrayList<>();
    private Shop shop = new Shop();

    public void GetMer(){
        Mercenary s = new Mercenary();
        s.GetSkill();
        team.add(s);
    }

    public Boolean PreFight() {
        if(team.isEmpty()){
            System.out.println("您没有任何可以出战的英雄!");
            return false;
        }
        System.out.println("请输入要出战英雄的名字：");
        Scanner in = new Scanner(System.in);
        String f = in.next();int k = 0;
        for(Mercenary s : team){
            if(s.getName().equals(f)){
                System.out.println("请问是否要派这位佣兵出战？(Y/N)");
                System.out.println(s.toString());
                if(in.next().equals("Y")){
                    System.out.println(s.getName()+"出战了！");
                    if(shop.getGoldNum()>=400){
                        System.out.println("为你的战士购买补给!");
                        shop.shop(s);
                    }
                    else{
                        System.out.println("你的贫穷让你的战士只能空手出发...");
                        new Scanner(System.in).nextLine();
                    }
                    Fight fight = new Fight();
                    fight.Fight(s,shop);
                    s.getWallet().clear();
                    return true;
                }
                else System.out.println("这位佣兵在等待下一次出战的机会");
                new Scanner(System.in).nextLine();
            }
        }
        System.out.println("没有找到您指定的英雄，或许他的名字能在墓碑上找到");
        new Scanner(System.in).nextLine();
        return false;
    }
    public void Show(){
        Scanner in = new Scanner(System.in);
        if(team.isEmpty()){
            System.out.println("您还没有任何佣兵！");
            return;
        }
        System.out.println("在此可以查看您的所有佣兵");
        System.out.println("输入0按等级排序，输入1按血量排序，输入2按攻击力排序");
        int k = in.nextInt();
        if(k == 0){
            team.sort(new Comparator<Mercenary>() {
                @Override
                public int compare(Mercenary o1, Mercenary o2) {
                    return Integer.compare(o2.getLevel(), o1.getLevel());
                }
            });
            int tot = 0;
            for(Mercenary s : team)tot+=s.getLevel();
            tot/=team.size();
            System.out.println("英雄平均等级："+tot);

        }
        if(k == 1){
            team.sort(new Comparator<Mercenary>() {
                @Override
                public int compare(Mercenary o1, Mercenary o2) {
                    return Integer.compare(o2.getHp(), o1.getHp());
                }
            });
            int tot = 0;
            for(Mercenary s : team)tot+=s.getHp();
            tot/=team.size();
            System.out.println("英雄平均血量："+tot);
        }
        if(k == 2){
            team.sort(new Comparator<Mercenary>() {
                @Override
                public int compare(Mercenary o1, Mercenary o2) {
                    return Integer.compare(o2.getAttack(), o1.getAttack());
                }
            });
            int tot = 0;
            for(Mercenary s : team)tot+=s.getAttack();
            tot/=team.size();
            System.out.println("英雄平均攻击力："+tot);
        }
        for(Mercenary s:team) System.out.println(s.toString());
    }

    public void Fire(){
        System.out.println("请输入要解雇英雄的名字：");
        List<Integer>fire = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String f = in.next();int k = 0;
        for(Mercenary s : team){
            if(s.getName().equals(f)){
                System.out.println("请问是否要解雇这位佣兵？(Y/N)");
                System.out.println(s.toString());
                if(in.next().equals("Y")){
                    System.out.println("显然，不是每一位佣兵都有可取之处");
                    new Scanner(System.in).nextLine();
                    fire.add(k);
                }
                else System.out.println("这位佣兵将继续为你而战");
            }
            k++;
        }
        if(fire.isEmpty()) System.out.println("没有找到你指定的英雄，他可能在你放弃他之前就进入了坟墓");
        int fi = 0;
        if(!fire.isEmpty())
            for (Integer fires : fire){
                team.remove(fires-fi);
                fi++;
            }
    }

    public void Dead(){
        List<Integer>fire = new ArrayList<>();
        Scanner in = new Scanner(System.in);int k = 0;
        for(Mercenary s : team){
            if(!s.IsLive())fire.add(k);
            k++;
        }
        List<Integer>fir = fire;
        int fi = 0;
        if(!fire.isEmpty())
            for (Integer fires : fire){
                team.remove(fires-fi);
                fi++;
            }
    }

    public void Settlement(){
        Scanner in = new Scanner(System.in);
        for(Mercenary s : team){
            while(s.getExp()>=s.getLevel()*10){
                s.setExp(s.getExp()-s.getLevel()*10);
                s.setLevel(s.getLevel()+1);
                System.out.println("您的"+s.getMajor()+s.getName()+"升到了"+s.getLevel()+"级!");
                System.out.println("请选择一项大幅提升(其他项微幅提高)");
                System.out.println("[0] 血量");
                System.out.println("[1] 攻击力");
                System.out.println("[2] 防御力");
                System.out.println("[3] 暴击率");
                int k = in.nextInt();
                if(k == 0)s.setStHp(s.getStHp()+10);
                if(k == 1)s.setAttack(s.getAttack()+7);
                if(k == 2)s.setDefense(s.getDefense()+10);
                if(k == 3)s.setCritical(s.getCritical()+5);
                System.out.println("佣兵感觉还能再战一场!");
            }
            s.setHp(s.getStHp());
        }
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
