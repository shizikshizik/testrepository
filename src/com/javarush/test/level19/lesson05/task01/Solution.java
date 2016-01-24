package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String firstFile = sc.next();
        String secondFile = sc.next();
        FileReader reader = new FileReader(firstFile);
        FileWriter writer = new FileWriter(secondFile);
        int i =1;
        while (reader.ready()){
            int data = reader.read();
            if (i%2==0){
                writer.write(data);
            }
            i++;
        }
        sc.close();
        reader.close();
        writer.close();

    }
}
