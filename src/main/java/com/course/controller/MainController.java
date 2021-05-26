package com.course.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.dto.CoursesDto;
import com.course.dto.StudentsDto;
import com.course.service.CoursesService;
import com.course.service.StudentsService;

@Controller
public class MainController {
	
	@Autowired
	StudentsService studentsService;
	
	@Autowired
	CoursesService coursesService;
	
	@GetMapping("/")
	public String homePage(Model m) {
		
		List<CoursesDto> courses = coursesService.getAllCourses() ;
		m.addAttribute("courses",courses);
		return "index";
	}
	
	@GetMapping("/register")
	public String studentRegistrationPage() {
		
		return "registerStudent";
	}
	
	@PostMapping("/register")
	public String registerStudent(@ModelAttribute StudentsDto studentsDto, Model m) {
		String msg = studentsService.saveStudents(studentsDto) ; 
		m.addAttribute("message", msg);
		return "registerStudent";
	}
	
	@GetMapping("/login")
	public String studentLoginPage() {
		return "loginStudent";
	}
	
	@PostMapping("/authenticate")
	public String authenticateStudent(@RequestParam String studentEmail, @RequestParam String studentPassword, Model md, HttpSession session) {
		StudentsDto studentDto = studentsService.authenticateStudent(studentEmail, studentPassword);
		
		if( studentDto != null) {
			session.setAttribute("name", studentDto.getStudentName());
			session.setAttribute("email", studentDto.getStudentEmail());
			session.setAttribute("stdId", studentDto.getStudentId());
			session.setAttribute("courseEnrolled", studentDto.getEnrolledCourses());
			
			
			return "redirect:/profile";
		}else {
			md.addAttribute("message", "Username/Password is Incorrect.");
			return "loginStudent";
		}
	
	}
	@GetMapping("/profile")
	public String studentProfilePage(HttpSession session,Model m) {
	
		if( session.getAttribute("name") != null ) {
			String courses = (String) session.getAttribute("courseEnrolled") ;
			//System.out.println(courses);
//			String[] course = courses.split(",");
//			List<String> courseIDs = Arrays.asList(course);
//			System.out.println(courseIDs);
			String[] parts = null;
			List<Integer> courseIDs = new ArrayList<Integer>();
			if(courses.length() >2 ) {
				
				parts = courses.split(",");
				for (int i = 0; i < parts.length; i++) {
					
					courseIDs.add(Integer.parseInt(parts[i]));
				}
			}else {
				courseIDs.add(Integer.parseInt(courses));
			}

			
			
			
			List<CoursesDto> coursesDto = studentsService.getEnrolledCourses(courseIDs);
			System.out.println(coursesDto);
			m.addAttribute("course",coursesDto);
			return "studentProfile";
		}
		m.addAttribute("message","You must login First");
		return "loginStudent";
	}
	@GetMapping("/logout")
	public String logout( HttpSession session) {
		session.invalidate();
		
		return "redirect:/login";
	}
	
	@GetMapping("/enroll")
	public String enrollCourse(HttpSession session, @RequestParam int courseId, Model m) {
		if( session.getAttribute("name") != null ) {
			int id = (Integer) session.getAttribute("stdId");
			//get current logged in user details
			StudentsDto studentDto = studentsService.getStudentById(id);
			
			String enrolledCourses = studentDto.getEnrolledCourses();
			String seperator = "";
			String[] coursesids = {};
			boolean courseExists = false;
			if(enrolledCourses == null) {
				enrolledCourses = "";
				
			}else {
				seperator = ",";
			}
			// to check if courseid exists
			if(enrolledCourses.length() > 2 ) {
				coursesids = enrolledCourses.split(",");
			}
			for( String c:coursesids) {
				if( Integer.parseInt(c) == courseId) {
					courseExists = true ;
				}
			}
			// only add courseid if doesnt exists
			if(! courseExists ) {
				
				enrolledCourses 	= enrolledCourses+seperator+courseId;
			}
			
			studentsService.updateEnrolledCourses(enrolledCourses,id);
			return "redirect:/profile";
		}else {
			m.addAttribute("message","You must login to Enroll in course");
			return "loginStudent";
		}
		
	}
}
