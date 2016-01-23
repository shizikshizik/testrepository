package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        synchronized (allPeople)
        {
            if (args[0].equals("-c"))
            {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                int x = (args.length - 1) / 3;
                for (int i = 0; i < x; i++)
                {
                    if (args[2 + x * i].equals("м"))
                    {

                        allPeople.add(Person.createMale(args[1 + x * i], simpleDateFormat.parse(args[3 + x * i])));

                    } else
                        allPeople.add(Person.createFemale(args[1 + x * i], simpleDateFormat.parse(args[3 + x * i])));
                }
            }
            if (args[0].equals("-u"))
            {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                int x = (args.length - 1) / 4;
                for (int i = 0; i < x; i++)
                {
                    if (args[3 + x * i].equals("м"))
                    {
                        allPeople.set(Integer.parseInt(args[1 + x * i]), Person.createMale(args[2 + x * i], simpleDateFormat.parse(args[4 + x * i])));

                    } else
                        allPeople.set(Integer.parseInt(args[1 + x * i]), Person.createFemale(args[2 + x * i], simpleDateFormat.parse(args[4 + x * i])));

                }

            }
            if (args[0].equals("-d"))
            {
                int x = (args.length - 1);
                for (int i = 1; i < x; i++)
                {
                    allPeople.set(Integer.parseInt(args[i]), null);

                }

            }
            if (args[0].equals("-i"))
            {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                int x = (args.length - 1);
                for (int i = 1; i < x; i++)
                {
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    System.out.println(person.getName() + " " + person.getSex() + " " + simpleDateFormat.format(person.getBirthDay()));

                }

            }


        }


    }
}

