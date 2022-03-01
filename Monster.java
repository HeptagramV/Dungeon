package Dungeon.role;

import Dungeon.state.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster {
    private String race;
    private int hp;
    private int attack;
    private int defense;
    private State state;
    private int Critical;
    private int Speed;
    private int exp;

    public List<State> states = new ArrayList<>();

    public String toString() {
        if(this.state.getName().equals("正常"))
            return race+"{" +
                    "血量:" + hp +
                    ", 攻击力:" + attack +
                    ", 防御力:" + defense +
                    ", 暴击率:" + Critical +"%"+
                    ", 速度:" + Speed +
                    ", 状态:" + state.getName() +
                    '}';
        else return race+"{" +
                "血量:" + hp +
                ", 攻击力:" + attack +
                ", 防御力:" + defense +
                ", 暴击率:" + Critical +"%"+
                ", 速度:" + Speed +
                ", 状态:" + state.getName() + "剩余" + state.getTime() + "回合"+
                '}';
    }

    public boolean IsLive(){
        if(this.hp > 0)return true;
        return false;
    }

    public Monster(){
        Random k = new Random();
        State state1 = new State();
        state1.setName("正常");
        states.add(state1);
        int ju = k.nextInt(4)+1;
        if(ju == 1)race = "骷髅暴徒";
        else if(ju == 2)race = "腐毒巨蛛";
        else if(ju == 3)race = "沼泽魔女";
        else race = "猎手屠夫";
        exp = k.nextInt(100);
        hp = exp + k.nextInt(20);
        attack = exp/2 + k.nextInt(20);
        defense = exp/2 + k.nextInt(15);
        this.state = state1;
        this.Critical = k.nextInt(10)+10;
        this.Speed = k.nextInt(8)+1;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
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
}
