package com.batch36.sb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.batch36.sb.entity.CourseEntity;
import com.batch36.sb.repo.CourseRepository;


@Service
public class CourseService {
	@Autowired
	private CourseRepository cr;
	
	public void insertCourse(CourseEntity ce) {
		cr.save(ce)	;
	}
	public List<CourseEntity>getAllCourse() {
		
		return cr.findAll();
	}
	public Optional<CourseEntity>findById(Long CourseId) {
		
		return cr.findById(CourseId);
	}
	
	
	public CourseEntity save(CourseEntity courseEntity) {
		return cr.save(courseEntity);
		
	}
	public void delete(CourseEntity courseEntity) {
		cr.delete(courseEntity);

}
}