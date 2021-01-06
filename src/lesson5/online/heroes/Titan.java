package lesson5.online.heroes;

public class Titan extends Paladin {

    public Titan(String name, int hp, int mp, int atk, int dex) {
        super(name, hp, mp, atk, dex);
    }

    public void bigAttack(){
        System.out.println(name + " has a bigAttack " );
    }

    @Override
    public void block(){
        System.out.println(name + " don't block ");
    }

    @Override
    public void heal(int hp){
        System.out.println(name + " don't heal " );
    }



}
