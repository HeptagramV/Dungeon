package Dungeon.skills;

import Dungeon.role.Mercenary;
import Dungeon.role.Monster;

public abstract class Skill {
    private String name;

    public Skill(String name){
        this.name = name;
    }

    public Skill(){

    }

    public abstract void use(Mercenary mer,Monster mon);

    public abstract String describe();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
