package lesson5.online.heroes;

import lesson5.online.model.Hero;

public class Paladin extends Hero {

    int dex;

    public Paladin(String name, int hp, int mp, int atk) {
        super(name, hp, mp, atk);
        this.dex = 0;
    }

    public Paladin(String name, int hp, int mp, int atk, int dex) {
        super(name, hp, mp, atk);
        this.dex = dex;
    }
    @Override
    public void heal(int hp){
        System.out.println(name + " has heal self to " +(hp + 1));
    }
}
