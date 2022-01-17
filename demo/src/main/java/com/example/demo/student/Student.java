package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity     //For Hibernate
@Table      //For database
public class Student {

    @Id                                     //Field that is auto generated
    @SequenceGenerator(                     //To establish the relation between Java and DB
        name = "student_sequence",          //What we want to call it in JAVA
        sequenceName = "student_sequence",  //Real name of sequence in db
        allocationSize = 1                  //Increment
    )
    @GeneratedValue(                        //Annotation to configure the way of increment of the specific column(field)
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long id;
    private String name;

    @Transient              //This field will be calculated and does not need a differenct column in the database
    private Integer age;

    private LocalDate dob;
    private String email;

    //generate constructors
    public Student(){
    }

    public Student(Long id, 
                    String name,
                    String email,
                    LocalDate dob){
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(
            String name, 
            String email,
            LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    //generate getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", dob='" + getDob() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }

}
