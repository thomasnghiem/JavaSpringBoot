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

package thomas.assignment2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import thomas.assignment2.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
     public List<Student> findByName(String name);
   
}

