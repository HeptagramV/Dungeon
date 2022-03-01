package Dungeon;

import Dungeon.Interface.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        MercenarySet Adm = new MercenarySet();
       /* Frame f = new Frame();
        f.setButton1(new JButton("招募佣兵"));
        f.getButton1().setBounds(100,100,100,50);
        f.setButton2(new JButton("查看佣兵"));
        f.getButton2().setBounds(100,180,100,50);
        f.setButton3(new JButton("解雇佣兵"));
        f.getButton3().setBounds(100,260,100,50);
        f.setButton4(new JButton("进入战斗"));
        f.getButton4().setBounds(100,340,100,50);
        f.getButton1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == f.getButton1()){
                    f.setText1(new JTextField("恭喜你获得了一位"));
                    f.getText1().setBounds(200,200,100,50);
                    f.getjPanel().add(f.getText1());
                    f.getFirst().repaint();
                    f.getFirst().validate();
                    f.getFirst().invalidate();
                    f.getFirst().validate();
                    f.getFirst().pack();
                    f.getText1().setVisible(false);
                    f.getText1().setVisible(true);
                    System.out.println("");
                    Adm.GetMer(f);
                }
            }
        });
        f.getButton0().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == f.getButton0()){
                    f.getFirst().getLayeredPane().remove(f.getBack());
                    f.getjPanel().remove(f.getButton0());
                    f.setBack(new JLabel(f.getBack2()));
                    f.getBack().setBounds(0,0,f.getBack2().getIconWidth(),f.getBack2().getIconHeight());
                    f.getFirst().getLayeredPane().add(f.getBack(), Integer.valueOf(Integer.MIN_VALUE));
                    f.getFirst().setBounds(170,70,f.getBack2().getIconWidth(), f.getBack2().getIconHeight());
                    f.getjPanel().add(f.getButton1());
                    f.getjPanel().add(f.getButton2());
                    f.getjPanel().add(f.getButton3());
                    f.getjPanel().add(f.getButton4());
                }
            }
        });*/
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("[0] 招募佣兵");
            System.out.println("[1] 查看佣兵");
            System.out.println("[2] 解雇佣兵");
            System.out.println("[3] 进入战斗");
            System.out.println("[4] 离开程序");
            System.out.println("                           拥有金钱:"+Adm.getShop().getGoldNum());
            int k = in.nextInt();
            if(k == 0){
                System.out.println("按任意键来获得一个佣兵(输入0结束)");
                while (!new Scanner(System.in).nextLine().equals("0")) Adm.GetMer();
                k = -1;
            }
            if(k == 1)Adm.Show();
            else if(k == 2)Adm.Fire();
            else if(k == 3){if(Adm.PreFight()){Adm.Dead();Adm.Settlement();}}
            else if(k == 4)return;
            else if(k != -1)System.out.println("请输入正确代号");
            if(k!=-1)new Scanner(System.in).nextLine();
        }
    }
}
