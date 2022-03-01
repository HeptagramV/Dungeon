package Dungeon.state;

import Dungeon.role.Mercenary;
import Dungeon.role.Monster;

public class Bleed extends State{
    private String name;
    private int time;
    private int num;

    public Bleed(){
        super("流血");
        time = 3;
        num = 1;
    }

    public void Happen(Mercenary s){
        --time;
        s.setHp(s.getHp()-s.getHp()/100*7);
    }

    public void Happen(Monster s){
        --time;
        s.setHp(s.getHp()-s.getHp()/100*7);
    }
}
