package com.batch36.sb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.batch36.sb.entity.StudentEntity;
import com.batch36.sb.repo.StudentRepository;

@SpringBootApplication
public class SbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SbApplication.class, args);
	}
	@Autowired
	private StudentRepository sr;

	@Override
	public void run(String... args) throws Exception {
	   StudentEntity studententity=new StudentEntity();
	    List<StudentEntity>stud= sr.findByLname("Tejomurthula");
	    System.out.println(stud);
	}

		
		
	}


