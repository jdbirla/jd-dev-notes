package com.jd.studentapi;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
	
	
	@PostMapping("/createStudent")
	public void createStudent(@RequestBody List<Student> students)
	{
		
		System.out.println(students);
	}

}
