package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRADES database table.
 * 
 */
@Entity
@Table(name="Grades", schema="TESTDB")
@NamedQuery(name="Grades.findAll", query="SELECT g FROM Grades g")
public class Grades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String assignment;

	private double grade;

	public Grades() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssignment() {
		return this.assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public double getGrade() {
		return this.grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

}