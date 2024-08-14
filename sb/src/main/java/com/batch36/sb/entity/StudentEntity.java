package com.batch36.sb.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@NamedQuery(name = "StudentEntity.findByLname", query = "select s from StudentEntity s where s.lname = ?1")
@Table(name="studententity")
public class StudentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fname", nullable=false)
    private String  fname;
    
    public int getId() {
		return id;
	}
     public void setId(int id) {
		this.id = id;
	}
     public String getFname() {
		return fname;
	}
      public void setFname(String fname) {
		this.fname = fname;
	}

     public String getLname() {
		return lname;
	}

     public void setLname(String lname) {
		this.lname = lname;
	}

     public String getEmail() {
		return email;
	}

     public void setEmail(String email) {
		this.email = email;
	}

    @Column(name = "lname", nullable = false)
    private String lname;
    @Column(name = "email", nullable = false)
    private String email;
    public StudentEntity() {}

    @Override
    public String toString() {
        return id + ":" + fname +":"+lname+":"+email;
    }
}
