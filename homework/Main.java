package lesson5.homework;

import lesson5.homework.animals.Bird;
import lesson5.homework.animals.Cat;
import lesson5.homework.animals.Dog;
import lesson5.homework.animals.Horse;
import lesson5.homework.model.Animal;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Собака",500,10,0.5);
        Horse horse = new Horse("Лошадь", 1500, 100,3);
        Bird bird = new Bird("Птичка",5,0,0.2);
        Cat cat = new  Cat("Кот",200,0,2);

        Animal[] animals = {dog,horse,bird,cat};

        for (Animal animal : animals) {

            animal.run(150);
            animal.jump(2.5);
            animal.swim(160);

        }
    }
}

