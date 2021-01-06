package lesson5.online.heroes;

import lesson5.online.model.Hero;

public class Druid extends Hero {


    public Druid(String name, int hp, int mp, int atk) {
        super(name, hp, mp, atk);
    }

    @Override
    public void heal(int hp){
        System.out.println(name + " don't heal " );
    }

}
