package org.example.service;

import org.example.model.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentService {

    public ArrayList<Student> createStudent() {

        ArrayList<Student> students = new ArrayList<Student>();
        Student st1 = new Student(1, "Fox", 23);
        Student st2 = new Student(2, "Tom", 30);
        Student st3 = new Student(3, "Rim", 23);
        Student st4 = new Student(4, "Dim", 44);
        Student st5 = new Student(5, "Fox", 99);
        Student st6 = new Student(6, "Kevin", 11);

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);

        return students;
    }

    //1. рассчитать суммарный возраст для определенного имени
    public int getAgeByName(ArrayList<Student> studentList, String studentName)
    {
        int sumAge = 0;

       ArrayList<Student> tempList = new ArrayList<>();

       for (int i = 0; i<studentList.size(); i++)
        {
            System.out.println(studentList.get(i).getName() +" "+ studentList.get(i).getAge());
            if (studentList.get(i).getName().equals(studentName)) {
                tempList.add(studentList.get(i));
            }
        }

       for (int h=0; h<tempList.size(); h++)
       {
           sumAge= sumAge + tempList.get(h).getAge();
       }
       return sumAge;
    }

    //2. Получить сет который содержит только имена участников
    public HashSet getSetWithNames (ArrayList<Student> studentList)
    {
        HashSet<String> tempSet = new HashSet<>();

        for (int i=0; i<studentList.size(); i++)
        {
            tempSet.add(studentList.get(i).getName());
        }

        return tempSet;
    }

    //3. Узнать содержит ли список хотя бы 1 участника, у которого возраст больше заданного числа

    public boolean defineStudentAgeMoreThan (ArrayList<Student> studentList, int age)
    {
        boolean decesionAnswer = false;
        Iterator<Student> it = studentList.iterator();
        while (it.hasNext())
        {
            if (age<it.next().getAge())
            {
                decesionAnswer=true;
                return decesionAnswer;
            }

        }
        return decesionAnswer;
    }


    //4. Преобразовать список в Map, у которого ключ - уникальный идентификатор, значение - имя

    public HashMap<Integer, String> transferListToMap (ArrayList<Student> arList)
    {
        HashMap<Integer, String> newMap = new HashMap<>();

        Iterator<Student> itr = arList.iterator();
        while (itr.hasNext())
        {
            Student st = itr.next();
            newMap.put(st.getStudentId(),st.getName());
        }
        return newMap;
    }

    //5. преобразовать список в Map, у которого ключ - возраст,
    // значение - коллекция объектов Student,
    // которым соответствует возраст, указанный в ключе
    public Map<Integer, List<Student>> transferListToMapWithCollection (ArrayList<Student> students)
    {
        HashMap<Integer,ArrayList<Student>> result = new HashMap<>();
        return students.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Function.identity(), Collectors.toList())));

    }
}
