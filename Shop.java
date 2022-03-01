package Dungeon;

import Dungeon.Item.*;
import Dungeon.role.Mercenary;

import java.util.Scanner;

public class Shop {
    private int goldNum=1000;

    public void shop(Mercenary mer){
        while (true){
        System.out.println("[0] 回复药剂        400$");
        System.out.println("[1] 狂热药剂        400$");
        System.out.println("[2] 坚定药剂        500$");
        System.out.println("[3] 神速药剂        500$");
        System.out.println("                      拥有金钱:"+getGoldNum());
        Scanner in = new Scanner(System.in);
        int ju = in.nextInt();
        Item s;
        if(ju == 0 && getGoldNum()>400){ s = new AddBlood();setGoldNum(getGoldNum()-400);}
        else if(ju == 1 && getGoldNum()>400){ s = new AddAttack();setGoldNum(getGoldNum()-400);}
        else if(ju == 2 && getGoldNum()>500){ s = new AddDefence();setGoldNum(getGoldNum()-500);}
        else if(ju == 3 && getGoldNum()>500){ s = new AddSpeed();setGoldNum(getGoldNum()-500);}
        else {
            System.out.println("您被赶出了商店");
            return;
        }
        int num = 0,flag = 0;
        for (Item ss:mer.getBag()){
            if(ss.getName().equals(s.getName())){flag = 1;break;}
            num++;
        }
        if(flag == 0)mer.getBag().add(s);
        else mer.getBag().get(num).setNum(mer.getBag().get(num).getNum()+1);
        System.out.println("谢谢惠顾");
        if(getGoldNum()>=400){
            System.out.println("请问还需要继续购买吗？");
            System.out.println("[0] 是");
            System.out.println("[1] 否");
            int f = in.nextInt();
            if(f == 0)continue;
            else if(f == 1) {
                System.out.println("战斗开始");
                return;
            }
            else {
                System.out.println("下次请正确输入");
                return;
            }
        }
        return;
        }
    }

    public int getGoldNum() {
        return goldNum;
    }

    public void setGoldNum(int goldNum) {
        this.goldNum = goldNum;
    }
}
