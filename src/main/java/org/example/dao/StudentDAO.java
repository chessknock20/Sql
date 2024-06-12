package org.example.dao;

import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public Student getStudentById(int id) throws SQLException {
        String query = "SELECT * FROM mydb.students Where id =?;";
        Student student = new Student();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "********");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                student.setName(result.getString("first_name"));
                student.setAge(result.getInt("age"));
                student.setPassportId(result.getInt("passports_id"));
            }
        } finally {
            connection.close();
            preparedStatement.close();
            result.close();
        }
        return student;
    }

    public List<Student> getStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM mydb.students";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "*******");
           preparedStatement = connection.prepareStatement(query);
            ;
           result = preparedStatement.executeQuery();
            while (result.next()) {
                Student student = new Student();
                student.setName(result.getString("first_name"));
                student.setAge(result.getInt("age"));
                student.setPassportId(result.getInt("passports_id"));
                students.add(student);
            }
        } finally {
            connection.close();
            preparedStatement.close();
            result.close();
            }
            return students;
        }

        public void insert (Student student) throws SQLException {
            String query = "INSERT INTO `mydb`.`students`(`first_name`,`age`,`passports_id`) VALUES(?,?,?);";
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "********");
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getAge());
                preparedStatement.setInt(3, student.getPassportId());
                preparedStatement.execute();
            }finally {
                connection.close();
                preparedStatement.close();
            }
        }

    }
