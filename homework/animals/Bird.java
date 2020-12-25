package lesson5.homework.animals;

import lesson5.homework.model.Animal;

public class Bird extends Animal {

    public Bird(String name, double maxRunDistance, int maxSwimDistance, double maxHeightJump){

        super(name, maxRunDistance, maxSwimDistance, maxHeightJump);
    }

   @Override
   public void swim(int swimDistance){
        System.out.println(name + " не умеет плавать.");

    }
}
