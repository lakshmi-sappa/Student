package com.batch36.sb.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.batch36.sb.entity.CourseEntity;
import com.batch36.sb.exception.ResourceNotFoundException;
import com.batch36.sb.service.CourseService;
@RequestMapping("/vcube")
@RestController
public class StudentCourse 
{
	@Autowired
	private CourseService cs;
     @GetMapping("/get1")
     public String displaycourse()
 	{
 		return "course";
 	}
     
     @PostMapping("/insert1")
 	
 	public void insert( @RequestBody CourseEntity ce)
 	{
 		cs.insertCourse(ce);
 	}
 	@GetMapping("/getall1()")
 	public List<CourseEntity>getAll(){
 		return cs.getAllCourse();
 		
 	}
 	@GetMapping("/getcid/{cid}")
 	public ResponseEntity getCousrById(@PathVariable(value = "cid") Long CourseId)
 			throws ResourceNotFoundException {
 	{
 	  CourseEntity ce=cs.findById(CourseId)
 			  .orElseThrow(() -> new ResourceNotFoundException("course not found for this id :: " + CourseId));
 	  return ResponseEntity.ok().body(ce);


 	}
 	}
 	@PutMapping("/coursetable/{cid}")
 	public ResponseEntity updateStudentService(@PathVariable(value = "cid") Long CourseId ,
 	                                           @Valid @RequestBody CourseEntity courseDetails)
 	                                           throws ResourceNotFoundException {

 	   
 	    CourseEntity courseEntity = cs.findById(CourseId)
 	            .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + CourseId));

 	  
 	   courseEntity.setCname(courseDetails.getCname());

 	   
 	    final CourseEntity updatedCourseEntity = cs.save(courseEntity);

 	    return ResponseEntity.ok(updatedCourseEntity);
 	}
 	
 	
	 	@DeleteMapping("/coursetable/{cid}")
	
	 	public Map deleteCourse(@PathVariable(value = "cid") Long CourseId)
	
	 	throws ResourceNotFoundException {
	 	CourseEntity courseEntity = cs.findById(CourseId).orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + CourseId));
	 	 
	 	cs.delete(courseEntity);
	 	
	 	Map response = new HashMap<>();
	  
	 	response.put("deleted", Boolean.TRUE);
	 	
	 	return response;
	}
}