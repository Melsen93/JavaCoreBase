package lesson5.online.heroes;

import lesson5.online.model.Hero;

public class Archer extends Hero {


    public Archer(String name, int hp, int mp, int atk) {
        super(name, hp, mp, atk);
    }

    @Override
    public void heal(int hp){
       System.out.println(name + " has heal self to " + hp);
   }
}
