package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(sc.next());
        FileOutputStream fileOutputStream = new FileOutputStream(sc.next());
        int data;
        byte[] count = new byte[fileInputStream.available()];
        while (fileInputStream.available()>0){
            data = fileInputStream.read(count);
            }
        for (int i = count.length - 1; i >= 0; i--)
        {
            fileOutputStream.write(count[i]);
        }



        sc.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
