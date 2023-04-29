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

package thomas.assignment2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thomas.assignment2.model.Student;
import thomas.assignment2.repository.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Handles listing of all students and searching by name.
     * @param model
     * @return
     */
    @GetMapping({ "/", "/index", "/search" })
	public String showStudents(Model model, String keyword) {
		if (keyword != null) {
			model.addAttribute("students", this.studentRepository.findByName(keyword));
			model.addAttribute("keyword", keyword);
		} else {
			List<Student> students = this.studentRepository.findAll();
			model.addAttribute("students", students);
		}
		return "index";
	}


    /**
     * Show form for adding a student document.
     * @param student
     * @return
     */
    @GetMapping("/add-student")
    public String showAddStudentForm(Student student) {
        return "add-student";
    }

    /**
     * This will create a student document. C of CRUD.
     * @param student
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/add-student")
    public String addStudent(Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }
        List<String> courseList = student.getCourseList();
        if (courseList == null) {
            courseList = new ArrayList<>();
        }
        
        this.studentRepository.save(student);
        return "redirect:/index";
    }

    /**
     * Show form for editing a student document. The R in CRUD.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/edit-student/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);

        return "edit-student";
    }

    /**
     * This will update a student document. The U in CRUD.
     * @param id
     * @param student
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/edit-student/{id}")
    public String updateStudent(@PathVariable("id") String id, Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "edit-student";
        }

        this.studentRepository.save(student);

        return "redirect:/index";
    }

    /**
     * This will delete a student document. The D in CRUD.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable("id") String id, Model model) {
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        this.studentRepository.delete(student);

        return "redirect:/index";
    }
   }
