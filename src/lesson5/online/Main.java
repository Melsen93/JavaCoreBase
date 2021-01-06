package lesson5.online;

import lesson5.online.heroes.Archer;
import lesson5.online.heroes.Druid;
import lesson5.online.heroes.Paladin;
import lesson5.online.heroes.Titan;
import lesson5.online.model.Hero;

public class Main {

    public static void main(String[] args) {

        Archer archer = new Archer("Archer", 100, 20,15);
        Paladin paladin = new Paladin("Paladin", 150, 50, 50);
        Druid druid = new Druid("Druid", 75, 150,40);

        Titan titan = new Titan("Titan",200,100,500,100);

        Hero[] attackGroup = {archer,paladin,druid,titan};

        for (int i = 0; i < attackGroup.length; i++) {

            attackGroup[i].attack();
            attackGroup[i].block();

           if (attackGroup[i] instanceof Titan) {
                titan.bigAttack();
           }

            
        }


    }
}
