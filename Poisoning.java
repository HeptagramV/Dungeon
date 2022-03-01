package Dungeon.state;

import Dungeon.role.Mercenary;
import Dungeon.role.Monster;

public class Poisoning extends State{
    private String name;
    private int time;
    private int num;

    public Poisoning(){
        super("中毒");
        time = 3;
        num = 1;
    }

    public void Happen(Mercenary s){
        --time;
        s.setHp(s.getHp()-100/s.getDefense()-5);
    }

    public void Happen(Monster s){
        --time;
        s.setHp(s.getHp()-100/s.getDefense()-5);
    }
}
