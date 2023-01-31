package com.example.school;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    Service service=new Service();
    @PostMapping("/add-teacher")
    public ResponseEntity addTeacher(@RequestBody Teacher teacher){
        if(teacher.getName()==null){
            return new ResponseEntity<>(new RuntimeException("Teacher can't be null"), HttpStatus.NOT_ACCEPTABLE);
        }
        System.out.println("In addTeacher() in Controller, "+teacher);
        return new ResponseEntity(service.addTeacher(teacher), HttpStatus.ACCEPTED);
    }
    @PutMapping("/update-teacher-by-id")
    public ResponseEntity updateTeacher(@RequestParam("id") int id, @RequestParam("name") String name){
        if(id<0){
            return new ResponseEntity(new IllegalArgumentException("Id can't be negative"), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<String>(service.updateTeacher(id, name), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-teacher-by-id/{id}")
    public ResponseEntity deleteTeacher(@PathVariable("id") int id){
        if(id<0){
            return new ResponseEntity<>(new IllegalArgumentException("Id can't be negative"), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(service.deleteTeacher(id), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getTeacher/{id}")
    public ResponseEntity getTeacher(@PathVariable("id") int id){
        Teacher result=service.getTeacher(id);
        if(result==null){
            return new ResponseEntity<>("Can't Retrieve Teacher who doesn't exist", HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }



    @PostMapping("/add-student")
    public ResponseEntity addStudent(@RequestBody Student student){
        if(student.getName()==null){
            return new ResponseEntity<>(new IllegalArgumentException("Student can't be null"), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(service.addStudent(student), HttpStatus.ACCEPTED);
    }
    @PutMapping("/update-student-by-rollNo")
    public ResponseEntity updateStudent(@RequestParam("rollNo") int rollNo, @RequestParam("name") String name){
        if(rollNo<0){
            return new ResponseEntity(new IllegalArgumentException("rollNo can't be negative"), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(service.updateStudent(rollNo, name), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-student-by-rollNo/{rollNo}")
    public ResponseEntity deleteStudent(@PathVariable("rollNo") int rollNo){
        if(rollNo<0){
            return new ResponseEntity<>(new String("rollNo can't be negative"), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(service.deleteStudent(rollNo), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getStudent/{rollNo}")
    public ResponseEntity getStudent(@PathVariable("rollNo") int rollNo){
        Student result=service.getStudent(rollNo);
        if(result==null){
            return  new ResponseEntity<>("Can't Retrieve Student Who doesn't exist", HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<Student>(result, HttpStatus.ACCEPTED);
    }
}
