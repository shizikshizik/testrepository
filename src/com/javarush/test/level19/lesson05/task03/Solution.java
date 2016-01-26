package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String firstName = sc.next();
        String lastName = sc.next();
        Scanner sc0 = new Scanner(new File(firstName));
        FileWriter writer = new FileWriter(lastName);
        while (sc0.hasNext())
        {
            String word = sc0.next();

            if (getDigit(word)!=null){


            writer.write(word+" ");

            }


        }


        writer.close();
        sc.close();
        sc0.close();
    }

    private static String getDigit(String next)
    {
        try
        {


            int x = Integer.parseInt(next);

            return ""+x;
        }catch (NumberFormatException e){return null; }

    }


}
