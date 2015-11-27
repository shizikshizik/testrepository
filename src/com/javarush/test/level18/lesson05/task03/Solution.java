package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        FileOutputStream fileOutputStreamseecond = new FileOutputStream(sc.next());
        int count = fileInputStream.available();
        while (fileInputStream.available()>0){
            int data = fileInputStream.read();
            if (fileInputStream.available()>=count/2)
            {
                fileOutputStream.write(data);
            }
            if (fileInputStream.available()<count/2)
            {
                fileOutputStreamseecond.write(data);
            }

        }

        sc.close();
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStreamseecond.close();
    }
}
