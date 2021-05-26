package com.course.controller;

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
import com.course.service.CoursesService;

@Controller
public class CourseController {
	
	@Autowired
	CoursesService coursesService;
	
	@GetMapping("/admin")
	public String adminLoginPage() {
		
		return "adminLogin";
	}
	
	@PostMapping("/authenticateAdmin")
	public String authenticateAdmin( HttpSession session, Model m) {
		
		 return "adminLogin";
	}
	
	@GetMapping("/addCourse")
	public String addCourseForm() {
		
		return "addCourseForm";
	}
	@PostMapping("/addingCourse")
	public String addCourse(@ModelAttribute CoursesDto coursesDto,Model m) {
		String msg = coursesService.saveCourse(coursesDto);
		m.addAttribute("message", msg);
		return "addCourseForm";
	}
	@GetMapping("/updateCourse")
	public String updateCourseForm(@RequestParam int courseId, Model m) {
		CoursesDto courses = coursesService.getCourseById(courseId);
		m.addAttribute("courses",courses);
		return "addCourseForm" ; 
	}
	@PostMapping("/updatingCourse")
	public String updateCourse(@ModelAttribute CoursesDto coursesDto, Model m ) {
		
		String msg = coursesService.updateCourse(coursesDto);
		m.addAttribute("message",msg);
		CoursesDto courses = coursesService.getCourseById(coursesDto.getCourseId());
		m.addAttribute("courses",courses);
		return "addCourseForm";
		
	}
	@GetMapping("/courseList")
	public String coursesList(Model m) {
		List<CoursesDto> courses = coursesService.getAllCourses();
		m.addAttribute("courses",courses);
		return "coursesList";
	}
	@GetMapping("/deleteCourse")
	public String deleteCourse(@RequestParam int courseId, Model m) {
		
		coursesService.deleteCourse(courseId);
		
		return "redirect:/courseList";
	}
}
