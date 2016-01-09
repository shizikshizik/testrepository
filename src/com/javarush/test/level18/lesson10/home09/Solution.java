package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {


        Scanner sc = new Scanner(System.in);

        while (true)
        {
            String fileName = sc.next();
            File file= new File(fileName);
            if (!file.exists()){
                try
                {
                    throw new FileNotFoundException();
                }
                catch (FileNotFoundException e)
                {
                    System.out.println(fileName);
                    break;

                }
            }


        }
        sc.close();
    }
}
