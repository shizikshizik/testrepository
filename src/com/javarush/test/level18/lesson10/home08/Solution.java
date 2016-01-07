package com.javarush.test.level18.lesson10.home08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            String name = sc.next();
            if (name.equals("exit")) break;
            new ReadThread(name).start();
        }

    }

    public static class ReadThread extends Thread
    {
        public ReadThread(String fileName) throws IOException
        {
            this.fileName = fileName;
            //implement constructor body
        }

        String fileName;
        public void run()
        {
            FileInputStream inputStream = null;
            try
            {
                inputStream = new FileInputStream(new File(fileName));
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            Map<Byte, Integer> byteIntegerMap = new HashMap<Byte, Integer>();
            try
            {
                while (inputStream.available() > 0)

                {
                    byte bt = (byte) inputStream.read();
                    if (byteIntegerMap.containsKey(bt)) byteIntegerMap.put(bt, (byteIntegerMap.get(bt)) + 1);
                    else byteIntegerMap.put(bt, 0);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
