package com.bean;

public class User {
    private int universityNumber;
    private String studentName;
    private String sex;

    public User(int universityNumber, String studentName, String sex){
        this.universityNumber = universityNumber;
        this.studentName =studentName;
        this.sex = sex;
    }

    public int getUniversityNumber(){
        return universityNumber;
    }

    public String getStudentName(){
        return studentName;
    }

    public String getSex(){
        return sex;
    }
}
