package lesson4.homework;

public class Main {

    public static void main(String[]args){

    Employee employee1 = new Employee("Kuznetsov Dmitriy Andreevich", "programmer", "+7-910-428-19-78", 80000, 27);

    System.out.println("\n\tName : " + employee1.getName());
    System.out.println("\n\tSalary : " + employee1.getSalary() + " R\n\t");

    Employee[] employeeCompany = new Employee[5];

        employeeCompany[0] = new Employee("Suvorov Andrey Viktorovich", "Engineer",  "+7-905-566-57-68", 60000, 36);
        employeeCompany[1] = new Employee("Vinogradov Vasiliy Mikhaylovich", "Director",  "+7-907-567-67-89", 200000, 50);
        employeeCompany[2] = new Employee("Tyson Mike Johnovich", "Security",  "+7-915-456-22-34", 40000, 58);
        employeeCompany[3] = new Employee("Presley Elvis Baytovich", "Advertiser",  "+7-903-123-22-34", 1000000, 28);
        employeeCompany[4] = new Employee("Naval Alexey Topovich ", "Lawyer",  "+7-910-345-56-65", 70000, 41);

    ////выведение информации о сотруддниках старше 40 лет при помощи цикла

        for (Employee employee : employeeCompany) if (employee.getAge() > 40) employee.getPrint();
    }
}
