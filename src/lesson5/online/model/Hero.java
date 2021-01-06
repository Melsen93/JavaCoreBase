package lesson5.online.model;

abstract public class Hero {

    protected String name;
    protected int hp;
    protected int mp;
    protected int atk;

    public Hero(String name, int hp, int mp, int atk) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
    }


   public void attack(){
        System.out.println(name + " has attack " + atk);
    }

   public void block(){
        System.out.println(name + " has block ");
    }

    abstract protected void heal(int hp);
}
