package lesson2.homework;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class TwoClass {

    public static void main(String[] args) 		{

        int[] arr = {0, 1, 0, 1, 0, 1, 1 };       //создание целочисленного массива
        System.out.println("Целочисленный массив: " + Arrays.toString(arr)); //вывод целочисленного массива на экран
        change(arr);                           //изменение значений массива
        System.out.println("Измененный массив:    " + Arrays.toString(arr)); //вывод результата


        int[] massive = new int[8];  //создание пустого целочисленного массива
        comp(massive);               //заполнение массива при помощи метода с циклом
        System.out.println("Заполнение циклом:    " + Arrays.toString(massive)); //вывод результата

        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; //создание целочисленного массива
        increase(array);                                      //умножение элементов массива меньше 6 на 2
        System.out.println("Умноженный массив:    " + Arrays.toString(array)); //вывод результата

        int result = max(array);   //вычисление максимального числа в массиве
        System.out.println("Максимальное число умноженного массива: " + result);//вывод результата
        int minimal = min(array);  //вычисление минимального числа в массиве
        System.out.println("Максимальное число умноженного массива: " + minimal);//вывод результата


        /////решение задания 5
        int[][] square = new int[9][9];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0, j2 = square[i].length; j < square[i].length; j++, j2--) {
                if (i == j || i == (j2 - 1)) square[i][j] = 1;
                System.out.print(square[i][j] + " ");
            }
            System.out.print("\r\n");
        }

        int[] balance = {5,5,10}; //создание массива
        boolean verdictBalance = checkBalance(balance); //проверка баланса
        System.out.println("Массив: " + Arrays.toString(balance) + " делится на две равные части? " + verdictBalance);

        int[] start = {1,2,3,4,5}; //создание массива
        System.out.println("Начальный массив: " + Arrays.toString(start));//выыод на экран
        int[] end = shiftArray(start, 2); //смещение массива
        System.out.println("Массив после сдвига: " + Arrays.toString(end)); //вывод результата
    }

    ///Метод 1 Инвертация значений массива
    public static void change (int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0) ++arr[i];
            else --arr[i];
        }
    }
    ///Метод 2 Заполнение значений массива
    public static void comp (int[] arr) {
        arr[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*3 + 1;
        }
    }

    ///Метод 3 Умножение значений массива
    public static void increase (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6){
                arr[i] = arr[i] * 2;
            }
        }
    }

    ///Метод 4.1 Вычисление максимального числа в массиве
    public static int max (int[] arr) {
        int max = 0;
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        } return max;
    }
    ///Метод 4.2 Вычисление минимального числа в массиве
    public static int min (int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (element < min) {
                min = element;
            }
        } return min;
    }
    ///Метод 6. Вычисленние баланса.
    public static boolean checkBalance(int[] arr) {
        int lSum, rSum;

        for (int i = 0; i < arr.length + 1; i++) {
            lSum = 0;
            rSum = 0;

            for (int j = 0; j < i; j++) {
                lSum += arr[j];
            }

            for (int j = i; j < arr.length; j++) {
                rSum += arr[j];
            }

            if (lSum == rSum) return true;
        }
        return false;
    }

    //Метод 7 Сдвиг масива на n чисел
    public static int[] shiftArray(int[] arr, int shift) {
        if(shift != 0){
            //ставим ограничение на сдвиг, который не должен быть больше длины массива

            AtomicInteger finalShift = new AtomicInteger();
            if (shift > arr.length){
                shift = Math.abs(shift % arr.length);
            }
            else {
                finalShift.set(shift);
            }

            // определяем сторону сдвига
            if (shift > 0) {
                for (int n = 0; n < shift; n++) {
                    // убираем первый элемент в память, а на его место ставим последний элемент
                    int memory = arr[0];
                    arr[0] = arr[arr.length - 1];

                    // сдвигаем массив
                    for (int j = 1; j < arr.length - 1; j++) {
                        arr[arr.length - j] = arr[arr.length - j - 1];
                    }

                    // переводим элемент в первую ячейку
                    arr[1] = memory;
                }
            }
            else if (shift < 0) {
                for (int i = 0; i > shift; i--) {
                    int memory = arr[arr.length - 1];
                    arr[arr.length - 1] = arr[0];

                    if (arr.length - 1 - 1 >= 0)
                        System.arraycopy(arr, 1, arr, 0, arr.length - 1 - 1);

                    arr[arr.length - 2] = memory;
                }
            }
        }

        return arr;
    }

}
