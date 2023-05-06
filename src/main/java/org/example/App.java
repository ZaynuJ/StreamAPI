package org.example;

import org.example.model.Student;
import org.example.service.StudentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentService st = new StudentService();
        int t =  st.getAgeByName(st.createStudent(), "Fox");
        System.out.println("1. Age = "+ t);
        HashSet<String> s = st.getSetWithNames(st.createStudent());
        System.out.println("2. Names = "+ s);

    }
}
