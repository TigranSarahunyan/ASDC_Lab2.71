package org.example;

import java.io.File;
import java.util.ArrayList;

/**
 * Главный класс в котором запускается приложение
 */
public class Main {
    /** Гавная функция, запускающая прораммц
     * @param args - может в качестве параметров принять значения с консоли
     */
    public static void main(String[] args) {
        File fileToRead = new File("src/MOCK_DATA.csv");
        ArrayList<Student> list = Student.readingFromFile(fileToRead);
        for(Student student:list){
            System.out.println(student);
        }
        File fileToWrite = new File("src/wow.txt");
        Student.writingToFile(fileToWrite,list);
      /*  ArrayList<Student> list2 = Student.readingFromFile(fileToWrite);
        for(Student student:list){
            System.out.println(student);
        }*/
    }
}