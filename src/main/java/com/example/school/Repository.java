package com.example.school;
import java.util.*;
@org.springframework.stereotype.Repository
public class Repository {
    List<Teacher> teacherList;
    List<Student> studentList;
    public Repository(){
        this.teacherList=new ArrayList<>();
        this.studentList=new ArrayList<>();
    }
    public String addTeacher(Teacher teacher){
        teacherList.add(teacher);
        System.out.println("addTeacher() "+teacherList);
        return "Successfully Teacher Added !!!";
    }
    public String updateTeacher(int id, String newName){
        System.out.println("updateTeacher() "+teacherList);
        for (int i = 0; i < teacherList.size(); i++) {
            Teacher curr=teacherList.get(i);
            if(curr.getId()==id){
                curr.setName(newName);
                return "Successfully updated Teacher";
            }
        }
        return "Can't update teacher, whose id doesn't exist";
    }
    public String deleteTeacher(int id){
        System.out.println("deleteTeacher() "+teacherList);
        for(int i=0; i<teacherList.size(); i++){
            Teacher curr=teacherList.get(i);
            if(curr.getId()==id){
                //we have to delete this teacher
                teacherList.remove(i);
                return "Successfully deleted !!!";
            }
        }
        return "Can't delete teacher, whose id doesn't exits";
    }
    public Teacher getTeacher(int id){
        System.out.println("getTeacher() "+teacherList);
        for (Teacher teacher:teacherList) {
            if(teacher.getId()==id){
                return teacher;
            }
        }
        return null;
    }


    public String addStudent(Student student){
        studentList.add(student);
        return "Successfully Student Added !!!";
    }
    public String updateStudent(int rollNo, String newName){
        for (int i = 0; i < studentList.size(); i++) {
            Student curr=studentList.get(i);
            if(curr.getRollNo()==rollNo){
                curr.setName(newName);
                return "Successfully updated Student";
            }
        }
        return "Can't update student, whose id doesn't exist";
    }
    public String deleteStudent(int rollNo){
        for(int i=0; i<studentList.size(); i++){
            Student curr=studentList.get(i);
            if(curr.getRollNo()==rollNo){
                //we have to delete this teacher
                studentList.remove(i);
                return "Successfully Student Deleted";
            }
        }
        return "Can't delete student, whose id doesn't exits";
    }
    public Student getStudent(int rollNo){
        for (Student student:studentList) {
            if(student.getRollNo()==rollNo){
                return student;
            }
        }
        return null;
    }


}
