package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Class which will have all the resources for our API
@RestController
@RequestMapping(path = "api/v1/student")        //Route
public class StudentController {
    
    //StudentService class is to be instantiated for this, so it is made a spring bean
    private final StudentService studentService;      //Reference for StudentService class to fetch data

    @Autowired    //Autowired automatically injects the dependent beans into the associated references
    public StudentController(StudentService studentService) {   //Passing the reference to the controller. Adding constructor for it
        this.studentService = studentService;
    }
    
    @GetMapping // Annotation for making this class serve the GET rest api
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping //POST API
    public void registerNewStudent(@RequestBody Student student){           //Take the payload from the request body and map it into the Student class
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}") //DELETE API
    public void deleteStudent(@PathVariable("studentId") Long studentId){   //@PathVariable fetches data from the URI
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")   //PUT API
    public void updateStudent(@PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,                    //@RequestParam fetches data from the query string
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}   
