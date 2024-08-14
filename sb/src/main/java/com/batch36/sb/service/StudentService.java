package com.batch36.sb.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.batch36.sb.entity.StudentEntity;
import com.batch36.sb.repo.StudentRepository;
@Service
public class StudentService {
	@Autowired
	private StudentRepository sr;
	
	public void insertStudent(StudentEntity se) {
		sr.save(se)	;
	}
	public List<StudentEntity>getAllStudent() {
		
		return sr.findAll();
	}
	public Optional<StudentEntity>findById(Long StudId) {
		
		return sr.findById(StudId);
	}
	

	public StudentEntity save(StudentEntity studentEntity) {
		return sr.save(studentEntity);
		
	}
	public void delete(StudentEntity studentEntity) {
		sr.delete(studentEntity);
		
	}
	public List<StudentEntity> sortByName(){

		return sr.findAndOrderByFName();

     }
	 public List<StudentEntity> findByLname(String lname) {
	        return sr.findByLname(lname);
	        
	
     }
	 
}