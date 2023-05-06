package org.example;

import org.example.model.Student;
import org.example.service.StudentService;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentService st = new StudentService();
        //1
        int t =  st.getAgeByName(st.createStudent(), "Fox");
        System.out.println("1. Age = "+ t);
        //2
        HashSet<String> s = st.getSetWithNames(st.createStudent());
        System.out.println("2. Names = "+ s);
        //3
        boolean b = st.defineStudentAgeMoreThan(st.createStudent(),99);
        System.out.println("3. Boolean decesion= "+ b);
        //4
        HashMap<Integer,String>  m = st.transferListToMap(st.createStudent());
        System.out.println("4. HashMap = " + m);
        //5
        HashMap<Integer, List<Student>> n = (HashMap<Integer, List<Student>>) st.transferListToMapWithCollection(st.createStudent());
        System.out.println("5. HashMap2 = " + n);

    }
}
