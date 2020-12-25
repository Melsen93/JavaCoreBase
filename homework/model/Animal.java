package lesson5.homework.model;

public class Animal {

    protected String name;
    protected double maxRunDistance;
    protected int maxSwimDistance;
    protected double maxHeightJump;
    protected static int spread = ((int) (Math.random() * 200));

    public Animal(String name, double maxRunDistance, int maxSwimDistance, double maxHeightJump) {
        this.name = name;
        this.maxRunDistance = maxRunDistance + spread;
        this.maxSwimDistance = maxSwimDistance + spread;
        this.maxHeightJump = maxHeightJump + (float) (spread / 100);
    }


    public void run(double runDistance) {
        if (runDistance <= this.maxRunDistance) {
            System.out.println(name + " пробегает дистанцию.");
        } else System.out.println(name + " не пробегает дистанцию.");
    }

    public void jump(double heightJump) {
        if (heightJump <= this.maxHeightJump) {
            System.out.println(name + " перепрыгивает препятсвие.");
        } else System.out.println(name + " не перепрыгивает препятсвие.");
    }

    public void swim(int swimDistance) {
        if (swimDistance <= this.maxSwimDistance) {
            System.out.println(name + " проплывает дистанцию.");
        } else System.out.println(name + " не проплывает дистанцию.");
    }

}


