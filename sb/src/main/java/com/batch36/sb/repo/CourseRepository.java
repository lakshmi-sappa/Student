package com.batch36.sb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.batch36.sb.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

}
