package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> set = new TreeSet<String>();
        while (true){
            String nameFile = sc.next();
            if (nameFile.equals("end")) break;
            set.add(nameFile);
        }

        String nameForWrite="";
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (String nameForRead: set){

            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nameForRead.length(); i++)
            {
                if (nameForRead.charAt(i)=='.')list.add(i);
            }
            nameForWrite= nameForRead.substring(0, list.get(list.size()-1));
            FileInputStream inputStream = new FileInputStream(nameForRead);
            while (inputStream.available()>0)
            {
                int data = inputStream.read();
                temp.add(data);
            }

            inputStream.close();

        }
        FileOutputStream outputStream = new FileOutputStream(nameForWrite);

        for (int i = 0; i < temp.size(); i++)
    {
        outputStream.write(temp.get(i));
    }
        outputStream.close();
        sc.close();
    }
}
