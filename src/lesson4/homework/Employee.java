package lesson4.homework;

public class Employee {

    private final String specialNumber;
    private final String name;
    private final String post;
    private final String phone;
    private final int salary;
    private final int age;



    Employee(String name, String post, String phone, int salary, int age){
        this.name = name;
        this.post = post;
        this.phone = phone;
        this.salary = SalaryPosition(salary,age);
        this.age = age;
        this.specialNumber = Special.getSpecialGenerate();
    }

    ///метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000
    private int SalaryPosition(int salary,int age){
        if(age > 35)
            salary = salary + 10000;
        return salary;
    }
    //метод вывода на экран всех данных о сотруднике
    public void getPrint(){
        System.out.println("Name: " + this.name + "\tPost: " + this.post + "\t Phone: " + this.phone + " \n Salary: " + this.salary + " R" + "\t Age: " + this.age + "\t SpecialNumber: " + this.specialNumber + "\n");

    }
    //методы запроса полей объекта
    public String getName(){
        return name;
    }

    public String getPost(){
        return post;
    }

    public String getPhone(){
        return phone;
    }
    public int getSalary(){
        return salary;
    }

    public int getAge(){
        return age;
    }
    ///подкласс для присвоения уникального номера каждому новому сотруднику

    public static class Special {

       public static String getSpecialGenerate (){
           return " Б - " +  ((int)(Math.random()*100));
        }
    }

}


