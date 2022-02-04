//Accesses the database. Responsible for data access (Data Access Layer)
//Working with JPA
//Convention for whenever we want to connect to the database

package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository     // To access database
public interface StudentRepository extends 
    JpaRepository<Student, Long>{           //Because id is of type Long in the Student repo   
                                            //<The type of object we want to work with in this repository, type of object>

        //SELECT * FROM students where email="email"
        @Query("SELECT s from Student s WHERE s.email=?1 ")   //JPQL not direct SQL
        Optional<Student> findStudentByEmail(String email);

    }


