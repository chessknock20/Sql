package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.StudentDAO;
import org.example.model.Student;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        Logger LOGGER = LogManager.getLogger(App.class);

        StudentDAO studentDao = new StudentDAO();

        Student student = studentDao.getStudentById(2);
        LOGGER.info(student);

        List<Student> students = studentDao.getStudents();
        LOGGER.info(students);

        studentDao.insert(new Student("Ksenia", 23,3));
        List<Student> list = studentDao.getStudents();
        LOGGER.info(list);

        studentDao.update("Vlad", 22, 3, 3);
        List<Student> list2 = studentDao.getStudents();
        LOGGER.info(list2);

        studentDao.delete(4);
        List<Student> list3 = studentDao.getStudents();
        LOGGER.info(list3);

    }
}
