package lesson6.online;


import java.io.*;

public class Main {

    public static void main (String[] args){

//        Scanner scanner = new Scanner(System.in);
//
//        String s0 = "Hello_world";
//        String s1 = "Hello";
//        s1 += "_world";
//        String s2 = scanner.nextLine();
//        String s3 = "Hello_world";
//
//        System.out.println(s0 == s1);
//        System.out.println(s0 == s2);
//        System.out.println(s0 == s3);
//
//        System.out.println(s0.equals(s1));
//        System.out.println(s0.equals(s2));
//        System.out.println(s0.equals(s3));
//

//        long starTime = System.nanoTime();
//        String example = "Example";//String example = new String ("Example");
//
//        for (int i = 0; i < 50000; i++) {
//            example += i;
//        }
//
//        float deltaTime = System.nanoTime() - starTime;
//        System.out.println(example);
//        System.out.println("Work time string: " + deltaTime * 0.000001f + " millisec");
//
//
//        starTime = System.nanoTime();
//        StringBuilder example1 = new StringBuilder("Example");
//
//        for (int i = 0; i < 50000; i++) {
//
//            example1.append(i);
//
//        }
//
//        deltaTime = System.nanoTime() - starTime;
//        System.out.println(example1.toString());
//        System.out.println("Work time StringbUILDER: " + deltaTime * 0.000001f + " millisec");
//        String s0 = "Hello";
//        s0 += "_world";
//
//        StringBuilder s = new StringBuilder("Hello");
//        s.append("_world");
//        s.delete(0,s.length());
//        s.append("Hello!!");
//        System.out.println(s);
//
//        System.out.println("Programm start: ");
//
//        try{
//
//            System.out.println(10/0);
//
//        } catch (ArithmeticException exception) {
//            System.out.println("Ошибка! На ноль делить нелья!" + exception.getMessage());
//        }
//
//
//        try {
//            int[] arr = new int[10];
//            arr[11] = 5;
//        } catch (ArrayIndexOutOfBoundsException exception) {
//            System.out.println("Вы вышли за пределы массива!" + exception.getMessage());
//        }
//
//        System.out.println("Programm end: ");

//        InputStream in;
//        OutputStream out;
//
//        FileInputStream flying; // read
//        FileOutputStream flyout; // write

//        try {
//            FileOutputStream fos = new FileOutputStream("Hello.txt");
//            PrintStream pos = new PrintStream(fos);
//            pos.println("Hello!!!");
//            pos.close();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            FileInputStream fis = new FileInputStream("Hello.txt");
//            int outbox;
//            while ((outbox = fis.read()) != - 1){
//                System.out.print((char)outbox);
//            }
//            fis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
