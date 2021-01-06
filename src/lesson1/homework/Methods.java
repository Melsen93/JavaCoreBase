package lesson1.homework;

public class Methods {

    public static void main(String[] args){
       //выведение результатов работы методов в консоль
        System.out.println("Результат выражения 1 * (2 + (3/4) = " + calc(1, 2, 3,4));

        System.out.println("Сумма чисел 16 и 5 лежит в предалах от 10 до 20: " + limits(16,5));//true или false?
        System.out.println("Сумма чисел 5 и 7 лежит в предалах от 10 до 20: " + limits(5,7));

        System.out.println("Число 1: " + chek(1)); //положительное или отрицательное?
        System.out.println("Число -3: " + chek(-3));

        System.out.println(hello("Василий"));//приветсвие по имени

        System.out.println("2100 год: " + leap(2100));//год високосный или невисокосный?
        System.out.println("800  год: " + leap(800));
        System.out.println("2080 год: " + leap(2080));
        System.out.println("1917 год: " + leap(1917));
        int a = (int)Math.pow(3,3);
        System.out.println(a);
    }
    //Метод 1
    public static float calc(float a, float b, float c, float d){
     return  a * (b + (c / d));
    }
    //Метод 2
    public static boolean limits(int a, int b){
        return ((a + b)>=10 && (a + b)<=20);
    }
    //Метод 3
    public static String chek(int a){
        if(a >= 0){
            return "положительное";
        } else return "отрицательное";
    }
    //Метод 4
    public static String hello (String yourName) {
        return "Привет, " + yourName + "!";
    }

    //Метод 5
    public static String leap(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
            return "високосный";
        } else return "невисокосный";
    }
}
