package com.codehero.StudentInfo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    HashMap<Integer,Student> studentdb = new HashMap<>();
    @GetMapping("/get_student")
    public List<Student> getstudentbyid(){
        List<Student> list = new ArrayList<>();
        for(Map.Entry<Integer,Student> e: studentdb.entrySet()){
            list.add(e.getValue());
        }
        return list;
    }
    @PostMapping("/addstudent")
    public String addStudent(@RequestBody Student student){
        int sid = student.id;
        studentdb.put(sid,student);
        return "Student added successfully";
    }
}
