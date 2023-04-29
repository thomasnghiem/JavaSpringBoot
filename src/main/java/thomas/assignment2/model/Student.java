/********************************************** *********************************
Full Name : Thomas Nghiem
Student ID#: 122321227
Email : tnghiem2@myseneca.ca
Section : Assignment2
Authenticity Declaration:
I declare this submission is the result of my own work and has not been.
shared with any other student or 3rd party content provider. This
submitted.
piece of work is entirely of my own creation.
********************************************** *********************************
Submission Date: 21 April 2023
********************************************** ********************************/	

package thomas.assignment2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Student")
public class Student {

    @Id
    private String id;

    private Long studentNumber;

    private String name;

    private String email;

    private Float gpa;

    private List<String> courseList;

    public Student() {
    }

    public Student(Long studentNumber, String name, String email, Float gpa, List<String> courseList) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
        this.gpa = gpa;
        this.courseList = courseList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public List<String> getCourseList() {
        return courseList;
    }

    public void setcourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gpa=" + gpa +
                ", courseList=" + courseList +
                '}';
    }
}