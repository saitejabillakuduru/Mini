package entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Column(name="id")
    private Integer id;

   @Column(name = "studentName")
    private String studentName;

    @Column(name = "studentClass")
    private String studentClass;

    @Column(name = "phone")
    private String phone;

    @CreationTimestamp
    @Column(name = "enrollment_date")
    private Date enrollment_date;

    @Column(name = "last_date")
    private Date last_date;

    @Column(name = "status")
    private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnrollment_date() {
		return enrollment_date;
	}

	public void setEnrollment_date(Date enrollment_date) {
		this.enrollment_date = enrollment_date;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
