    package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Student - класс отражающий сущность файла,
 * который мы читаем
 */
public class Student {
    private String firstName;
    private String lastName;
    private String faculty;
    private int yearOfBirthday;
    private int yearOfApplying;
    private int idnp;

    /**
     * Конструктор без параметров
     */
    public Student() {
    }

    /**
     * Конструктор с параметрами
     * @param firstName - имя студента
     * @param lastName - фамилия студента
     * @param faculty - факультет на котоом происходит обучение
     * @param yearOfBirthday - год рождения
     * @param yearOfApplying - год поступления в университет
     * @param idnp - ID студента
     */
    public Student(String firstName, String lastName, String faculty, int yearOfBirthday, int yearOfApplying, int idnp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.yearOfBirthday = yearOfBirthday;
        this.yearOfApplying = yearOfApplying;
        this.idnp = idnp;
    }

    /**
     * Конструктор копирования
     * @param student - объект, который будет скопирован
     */
    public Student(Student student){
        this.firstName = student.firstName;
        this.lastName = student.lastName;
        this.faculty = student.faculty;
        this.yearOfBirthday = student.yearOfBirthday;
        this.yearOfApplying = student.yearOfApplying;
        this.idnp = student.idnp;
    }

    /**
     * Метод сранения двух объектов
     * @param o - объект с которым будут сравнивать
     * @return - возвращает истину, если объекты равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfBirthday == student.yearOfBirthday && yearOfApplying == student.yearOfApplying && idnp == student.idnp && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(faculty, student.faculty);
    }

    /**
     * Метод копирования объектов
     * @param student - объект, который будет скопирован
     * @return - вернет копию объекта
     */
    public Student copy(Student student){
        return new Student(student);
    }

    /**
     * Метод читающий данные из файла и записывающий их в ArrayList
     * @param file - в качестве параметра получает файл для чтения
     * @return - возвращает список объектов полученных с файла
     */
    public static ArrayList<Student> readingFromFile(File file){
        ArrayList<Student> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String string;
            while ((string = reader.readLine() )!= null){
                list.add(new Student(string)) ;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Конструктор создающей объект со строки
     * @param string - строка из которой получают параметры объекта
     */
    Student(String string){
        String[] array = string.split(",");
        firstName = array[0];
        lastName = array[1];
        faculty = array[2];
        yearOfBirthday = Integer.parseInt(array[3]);
        yearOfApplying = Integer.parseInt(array[4]);
        idnp = Integer.parseInt(array[5]);
    }

    /**
     * Метод записывающий список объектов в файл
     * @param file - файл в который нужно записать данные
     * @param list - список объектов для записи
     */
    public static void writingToFile(File file, ArrayList<Student> list){
        try(FileWriter writer = new FileWriter(file)){
            for(Student student:list){
                String str = student.firstName + "," + student.lastName + "," +
                        student.faculty + "," + student.yearOfBirthday + "," +
                        student.yearOfApplying + "," + student.idnp;
                writer.write(str+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Метод предятавляющий объект ввиде строки
     * @return - возвращает строку с параметрами конкретного объекта
     */
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", yearOfBirthday=" + yearOfBirthday +
                ", yearOfApplying=" + yearOfApplying +
                ", idnp=" + idnp +
                '}';
    }
}
