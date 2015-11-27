package com.javarush.test.level18.lesson03.task01;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(sc.next());
        int x =0;
        int y;
        while (fileInputStream.available()>0){

            y= fileInputStream.read();

            if (y>x)
            {
                x = y;
            }

        }
        System.out.println(x);
        
    }
}
