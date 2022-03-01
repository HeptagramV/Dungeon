package Dungeon.role;

import Dungeon.Interface.Frame;
import Dungeon.Item.Item;
import Dungeon.skills.*;
import Dungeon.state.State;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Mercenary {
    private String major;
    private String name;
    private int level;
    private int hp;
    private int attack;
    private int defense;
    private int Critical;
    private int Speed;
    private int exp;
    private int StHp;

    private List<Item> bag = new ArrayList<>();
    private List<Item> wallet = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();
    private List<State> states = new ArrayList<>();

    public Mercenary(){
        State state1 = new State();
        state1.setName("正常");
        states.add(state1);
        Random k = new Random();
        Scanner in = new Scanner(System.in);
        defense = k.nextInt(20)+7;
        level = k.nextInt(10)+1;
        major = GetMer();
        Speed = k.nextInt(7)+2;
        /*frame.setText1(new JTextField("恭喜你获得了一位"+level+"级的"+major));
        frame.getText1().setBounds(50,50,100,10);
        frame.getjPanel().add(frame.getText1());
        frame.getjPanel().repaint();*/
        System.out.println("恭喜你获得了一位"+level+"级的"+major);
        exp = 0;
        Critical = k.nextInt(10)+5;
        System.out.println("请输入佣兵的名字：");
        name = in.next();
        System.out.println("请设置佣兵的血量和攻击力");
        System.out.println("(受等级限制，血量和攻击力之和无法超过"+level*10+")");
        int f = 1;
        do {
            if(f>1) System.out.println("请输入合理数值");
            System.out.println("血量:");
            StHp = hp = in.nextInt();
            System.out.println("攻击力:");
            attack = in.nextInt();
            f++;
        }while (hp+attack>level*10 || hp<=0 || attack<=0);
    }

    public void GetSkill(){
        Skill s;
        if(major.equals("十字军")){
            s = new HolyCut("神圣斩击");
            this.skills.add(s);
            s = new SincereComplaint("热诚控诉");
            this.skills.add(s);
        }
        if(major.equals("强盗")){
            s = new PistolShooting("手枪射击");
            this.skills.add(s);
            s = new HidingShooting("匿踪暗袭");
            this.skills.add(s);
        }
        if(major.equals("瘟疫医生")){
            s = new BloodDagger("染血匕首");
            this.skills.add(s);
            s = new DrugBomb("瘟毒炸裂");
            this.skills.add(s);
        }
        if(major.equals("修女")){
            s = new HolyLight("圣光之手");
            this.skills.add(s);
            s = new HolyPray("神圣祈祷");
            this.skills.add(s);
        }
    }

    public boolean IsLive(){
        return this.hp > 0;
    }

    public String GetMer(){
        Random k = new Random();
        int s = k.nextInt(4)+1;
        String major = null;
        if(s==1)major = "十字军";
        if(s==2)major = "强盗";
        if(s==3)major = "瘟疫医生";
        if(s==4)major = "修女";
        return major;
    }

    @Override
    public String toString() {
        if(this.states.get(0).getName().equals("正常"))
        return name+"{" +
                "职业:'" + major + '\'' +
                ", 等级:" + level +
                ", 血量:" + hp +
                ", 攻击力:" + attack +
                ", 防御力:" + defense +
                ", 速度:" + Speed +
                ", 暴击率:" + Critical +"%"+
                ", 状态:" + states.get(0).getName() +
                '}';
        else {
            String s = name+"{" +
                    "职业:'" + major + '\'' +
                    ", 等级:" + level +
                    ", 血量:" + hp +
                    ", 攻击力:" + attack +
                    ", 防御力:" + defense +
                    ", 速度:" + Speed +
                    ", 暴击率:" + Critical +"%"+
                    ", 状态:" ;
            for(State s1:states){

            }
            return name+"{" +
                "职业:'" + major + '\'' +
                ", 等级:" + level +
                ", 血量:" + hp +
                ", 攻击力:" + attack +
                ", 防御力:" + defense +
                ", 速度:" + Speed +
                ", 暴击率:" + Critical +"%"+
                ", 状态:" + states.get(0).getName() + "剩余" + states.get(0).getTime() + "回合"+
                '}';
        }
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getCritical() {
        return Critical;
    }

    public void setCritical(int critical) {
        Critical = critical;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getStHp() {
        return StHp;
    }

    public void setStHp(int stHp) {
        StHp = stHp;
    }

    public List<Item> getBag() {
        return bag;
    }

    public void setBag(List<Item> bag) {
        this.bag = bag;
    }

    public List<Item> getWallet() {
        return wallet;
    }

    public void setWallet(List<Item> wallet) {
        this.wallet = wallet;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
