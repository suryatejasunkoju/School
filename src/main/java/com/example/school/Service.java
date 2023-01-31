package com.example.school;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    Repository repository=new Repository();
    public String addTeacher(Teacher teacher){
        return repository.addTeacher(teacher);
    }
    public String updateTeacher(int id , String name){
        return repository.updateTeacher(id, name);
    }
    public String deleteTeacher(int id){
        return  repository.deleteTeacher(id);
    }
    public Teacher getTeacher(int id){
        return repository.getTeacher(id);
    }
    public String addStudent(Student student){
        return repository.addStudent(student);
    }
    public String updateStudent(int rollNo , String name){
        return repository.updateStudent(rollNo, name);
    }
    public String deleteStudent(int rollNo){
        return  repository.deleteStudent(rollNo);
    }
    public Student getStudent(int rollNo){
        return repository.getStudent(rollNo);
    }
}
