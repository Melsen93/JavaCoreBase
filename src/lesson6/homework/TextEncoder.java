package lesson6.homework;

import java.io.*;

public class TextEncoder {

    public TextEncoder(){
    }

    //Метод вывода текста из файла
    public static  String readFiled (String fileName) {
        try {
            StringBuilder far = new StringBuilder();
            FileInputStream fis = new FileInputStream(fileName);
            int outbox;
            while ((outbox = fis.read()) != -1) {
                far.append((char) (outbox));
            }
            fis.close();
            return far.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка чтения";
        }

    }

    //Метод создания текстового файла
    public static void createFile(String name, String text){
        try {
            FileOutputStream file = new FileOutputStream(name);
            PrintStream pos = new PrintStream(file);
            pos.print(text);
            pos.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод поиска слова в текстовом файле
    public   static  boolean find (String word, String name) {
        String allText = readFiled(name);
        return allText.contains(word);
    }

    //Метод поиска слова в определенной папке
    public static boolean findDirectory(String directory,String word){
        StringBuilder textAllFind = new StringBuilder();

        File folder = new File(directory);

        String[] files = folder.list((folder1, name) -> name.endsWith(".txt"));
        assert files != null;
        for ( String fileName : files ) {
            textAllFind.append(TextEncoder.readFiled(fileName));
        }

        return  ( textAllFind.toString().contains(word));
    }


}
