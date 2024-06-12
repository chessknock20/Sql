package org.example.model;

public class Student {

    private String name;
    private int age;
    private int passportId;

    public Student() {  }

    public Student(String name, int age, int passportId) {
        this.name = name;
        this.age = age;
        this.passportId = passportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", passportId='" + passportId + '\'' +
                '}';
    }
}
