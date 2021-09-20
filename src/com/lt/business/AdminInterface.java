package com.lt.business;

import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.GradeCard;
import com.lt.bean.Professor;
import com.lt.bean.Student;

public interface AdminInterface {

	public boolean addProfessor(Professor professor);
	public boolean approveStudent(int studentId);
	public boolean addCourses(Course course);
	public boolean removeCourse(String courseCode);
	public List<GradeCard> generateReport();
	public ArrayList<Course> showCourses();
	public ArrayList<Professor> showProfessors();
	public List<Student> showPendingForApprovalStudent();
	
}
