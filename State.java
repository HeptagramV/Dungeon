package Dungeon.state;

import Dungeon.role.Mercenary;
import Dungeon.role.Monster;

public class State {
    private String name = "正常";
    private int time = 3;

    public void Happen(Mercenary s){

    }

    public void Happen(Monster s){

    }

    public State(String name){
        this.name = name;
    }

    public State(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
