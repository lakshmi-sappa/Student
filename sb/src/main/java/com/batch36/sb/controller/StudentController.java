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
import com.batch36.sb.entity.StudentEntity;
import com.batch36.sb.exception.ResourceNotFoundException;
import com.batch36.sb.service.StudentService;
@RequestMapping("/vcube")
@RestController
public class StudentController {
	@Autowired
	private StudentService ss;
	@GetMapping("get/asc")

	public List<StudentEntity>getStudentOrderDesc(){

	return ss.sortByName();

	}
	@GetMapping("/get")

	public String dispaly()
	{
		return "lakshmi";
	}
	@PostMapping("/insert")
	
	public void insert( @RequestBody StudentEntity se)
	{
		ss.insertStudent(se);
	}
	@GetMapping("/getall()")
	public List<StudentEntity>getAll(){
		return ss.getAllStudent();
		
	}
	@GetMapping("/getid/{id}")
	public ResponseEntity getStudentById(@PathVariable(value = "id") Long StudId)
			throws ResourceNotFoundException {
	{
	  StudentEntity se=ss.findById(StudId).orElseThrow(() -> new ResourceNotFoundException("student not found for this id :: " + StudId));
	  return ResponseEntity.ok().body(se);


	}
	}
	@PutMapping("/studententity/{id}")
	
	public ResponseEntity updateStudentService(@PathVariable(value = "id") Long StudId,
	                                           @Valid @RequestBody StudentEntity studentDetails)
	                                           throws ResourceNotFoundException {

	StudentEntity studentEntity = ss.findById(StudId)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudId));

	  
	studentEntity.setFname(studentDetails.getFname());

	   
	final StudentEntity updatedStudentEntity = ss.save(studentEntity);

	return ResponseEntity.ok(updatedStudentEntity);
	}
	
	
	@DeleteMapping("/studententity/{id}")

	public Map deleteStudent(@PathVariable(value = "id") Long StudId) throws ResourceNotFoundException {
	StudentEntity studentEntity = ss.findById(StudId).orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudId));
	 
	ss.delete(studentEntity);
	
	Map response = new HashMap<>();
 
	response.put("deleted", Boolean.TRUE);
	
	return response;
	
		
  }
	@GetMapping("/findByLname")
	public ResponseEntity<List<StudentEntity>> getLastName(String lname){
		List<StudentEntity> se=ss.findByLname(lname);
		return ResponseEntity.ok(se);
	}
	
  
}

