package com.javarush.test.level18.lesson08.task03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

//комментарий для изменения файла

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "d:/1.txt";

    public FileOutputStream fs;


    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException
    {
        super(fileName);
        fs = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException
    {
        fs.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        fs.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        fs.write(b, off, len);
    }

    @Override
    public FileChannel getChannel()
    {
        return fs.getChannel();
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();
    }

    public void close() throws IOException
   {
       fs.flush();
       String str = "JavaRush © 2012-2013 All rights reserved.";
       fs.write(str.getBytes());
       fs.close();
   }


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}

