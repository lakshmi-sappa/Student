package com.batch36.sb.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="coursetable")
public class CourseEntity
{     
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int cid;
	  @Column(name = "cname", nullable = false)
	  private String cname;
	  @Column(name = "location", nullable = false)
	  private String location;
	  public CourseEntity() {}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return cid+":"+ cname+":" + location;
	}
	

}
