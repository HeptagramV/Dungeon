package Dungeon;

import Dungeon.Item.*;
import Dungeon.treasure.*;

import java.util.Random;

public class Drop {

    public Item judge(){
        Random k = new Random();
        int ju = k.nextInt(100);
        Item s;
        if(ju<=10)s = new AddBlood();
        else if(ju<=20)s = new AddAttack();
        else if(ju<=30)s = new AddDefence();
        else if(ju<=36)s = new AddSpeed();
        else if(ju<=50)s = new Citrine();
        else if(ju<=65)s = new Emerald();
        else if(ju<=77)s = new Agate();
        else if(ju<=87)s = new Beryl();
        else if(ju<=95)s = new Sapphire();
        else s = new AddBlood();
        return s;
    }
}
