package com.batch36.sb.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.batch36.sb.entity.StudentEntity;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
@Query(value="select*FROM studententity orderBy fname  asc",nativeQuery=true )
public List<StudentEntity>findAndOrderByFName();

public List<StudentEntity>findByLname(String lname);

//public List<StudentEntity> findByLastName(String lname);



	

	
}
