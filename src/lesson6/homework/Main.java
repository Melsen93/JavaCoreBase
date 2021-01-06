package lesson6.homework;

public class Main {

    public static void main(String[] args) {

        //Создание текстовых файлов
        TextEncoder.createFile("TextOne.txt", "A well-written program is a program written 2 times.");
        TextEncoder.createFile("TextTwo.txt", "Nothing restricts the flight of thought of a novice programmer like a compiler.");

        //Чтение и объединение текста файлов в объект StringBuilder
        String myTextFiles = TextEncoder.readFiled("TextOne.txt") + TextEncoder.readFiled("TextTwo.txt");

        //Сохранение склееного текста в файл Bound.txt и его вывод в консоль
        TextEncoder.createFile("Bond.txt", myTextFiles); //3.Сохранение склееного текста в файл Bound.txt
        System.out.println(TextEncoder.readFiled("Bond.txt"));

        //Проверка наличия слова "like" в файле "TextOne.txt" и вывод результата в консоль
        boolean resultFind = TextEncoder.find("like", "TextOne.txt");
        System.out.println("В файле TextOne.txt есть слово like? " + resultFind);

        //Проверка наличия слова "like" в папке "C:\\java\\" и вывод результата в консоль
        resultFind = TextEncoder.findDirectory("C:\\java\\Kuznetsov", "like");
        System.out.println("В директории C:\\java\\Kuznetsov есть слово like ? " + resultFind );

        }

    }





