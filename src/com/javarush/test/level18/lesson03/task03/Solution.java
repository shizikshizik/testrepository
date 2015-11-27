package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String namefile = br.readLine();
        FileInputStream fileInputStream = new FileInputStream(namefile);
        FileInputStream fileInputStreamsecond = new FileInputStream(namefile);
        while (fileInputStream.available()>0)
        {
            int key = fileInputStream.read();
            map.put(key, 0);


        }
        while (fileInputStreamsecond.available()>0){
            int key = fileInputStreamsecond.read();
            map.put(key, map.get(key)+1);

        }


        int x=0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            if (entry.getValue()>x)
            {
                x = entry.getValue();

            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            if (entry.getValue().equals(x))
            {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
