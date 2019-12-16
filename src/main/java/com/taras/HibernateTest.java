package com.taras;

import java.util.List;

import com.taras.Department;
import com.taras.Department;
import com.taras.HibernateUtil;


/*1) File -> Project structure->  artifacts -> jar -> from modules with dependencies:
note: include in project build:  checked
2) Build -> Build artifacts
 cd C:\Users\taras\IdeaProjects\hibernate\out\artifacts\hibernate_jar\
 to run:  java -jar hibernate.jar*/

import org.hibernate.*;

public class HibernateTest {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Department department = new Department("java");
        session.save(department);

        session.save(new Employee("Jakab Gipsz",department));
        session.save(new Employee("Captain Nemo",department));

        session.getTransaction().commit();

        Query q = session.createQuery("From Employee ");

        List<Employee> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }

    }

}