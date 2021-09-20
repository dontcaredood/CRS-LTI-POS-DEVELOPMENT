package com.lt.contants;

public class Constants {

	public static final String PROFESSORgetStudentData = "SELECT * FROM CRS_STUDENT";
	public static final String PROFESSORgetCourseData = "SELECT C.SNO,C.COURSEID,C.COURSENAME,C.COURSEDESCRIPTION,C.COURSEAMOUNT,P.PROFESSORNAME FROM CRS_COURSE AS C LEFT JOIN CRS_PROFESSOR AS P ON C.PROFESSORID=P.PROFESSORID";
	public static final String PROFESSORgetLoginDetails = "SELECT PROFESSORID,PROFESSORPASSWORD from CRS_PROFESSOR where PROFESSORID=? and PROFESSORPASSWORD=?";
	public static final String PROFESSORgetGradeData = "SELECT G.GRADEID,S.STUDENTID ,S.STUDENTNAME ,G.GRADEPOINTS,G.GRADESTATUS FROM CRS_GRADE AS G INNER JOIN CRS_STUDENT AS S ON G.STUDENTID=S.STUDENTID";
	public static final String PROFESSORaddGrade ="INSERT INTO CRS_GRADE (GRADESTATUS,GRADEPOINTS,STUDENTID) VALUES (?,?,?)";
	public static final String STUDENTaddCourse = "INSERT INTO CRS_COURSE (COURSEID,COURSENAME,COURSEDESCRIPTION) VALUES(?,?,?)";
	public static final String STUDENTdropCourse = "DELETE FROM CRS_COURSE WHERE COURSENAME=?";
	public static final String STUDENTCourseName = "SELECT COURSENAME FROM CRS_COURSE";


	public static final String DELETE_COURSE_QUERY = "delete from crs_course where courseCode = ?";
	public static final String ADD_COURSE_QUERY = "insert into crs_course(courseCode, courseName, courseDesc, professorId) values (?, ?, ?,?)";
	public static final String VIEW_PENDING_ADMISSION_QUERY = "select userId, name, password, role, gender, address, studentId from crs_student natural join crs_user where isApproved = 'N'";
	public static final String APPROVE_STUDENT_QUERY = "update crs_student set isApproved = 'Y' where studentId = ?";
	public static final String ADD_USER_QUERY = "insert into crs_user(userId, name, password, role, gender, address) values (?, ?, ?, ?, ?, ?)";
	public static final String ADD_PROFESSOR_QUERY = "insert into crs_professor(userId, department, designation) values (?, ?, ?)";
	public static final String ASSIGN_COURSE_QUERY = "update crs_Course set professorId = ? where courseCode = ?";
	public static final String VIEW_COURSE_QUERY = "select courseCode, courseName, professorId from crs_course ";
	public static final String VIEW_PROFESSOR_QUERY = "select b.userId, b.name, b.gender, a.department, a.designation, b.address from crs_professor a inner join crs_user b on a.userId = b.userId";

	public static final String ADD_STUDENT="insert into crs_student (userId,branchName,isApproved) values (?,?,?)";
	public static final String VERIFY_CREDENTIALS="select password from crs_user where userId = ?";
	public static final String GET_ROLE="select role from crs_user where userId = ? ";
	public static final String IS_APPROVED="select isApproved from crs_student where studentId = ? ";
	public static final String GET_STUDENT_ID="select studentId from crs_student where userId = ? ";
	public static final String UPDATE_PASSWORD="update crs_user set password=? where userId = ? ";
	public static final String GET_PROF_NAME = "select name from crs_user where userId = ?";
		
	// Student Queries
	public static final String VIEW_REGISTERED_COURSES=" select * from crs_course inner join crs_registeredcourses on crs_course.courseCode = crs_registeredcourses.courseCode where crs_registeredcourses.studentId = ?";
	public static final String VIEW_AVAILABLE_COURSES=" select * from crs_course where courseCode not in  (select courseCode  from crs_registeredcourses where studentId = ?)  ";
	public static final String CHECK_COURSE_AVAILABILITY=" select courseCode from crs_registeredcourses where studentId = ? ";
	public static final String DECREMENT_COURSE_SEATS="update course set seats = seats-1 where courseCode = ? ";
	public static final String ADD_COURSE="insert into crs_registeredcourses (studentId,courseCode) values ( ? , ? )";
	public static final String DROP_COURSE_QUERY = "delete from crs_registeredcourses where courseCode = ? AND studentId = ?;";
	public static final String INCREMENT_SEAT_QUERY  = "update crs_course set seats = seats + 1 where  courseCode = ?;";
	public static final String CALCULATE_FEES  = "select sum(courseFee) from crs_course where courseCode in (select courseCode from crs_registeredcourses where studentId = ?);";
	public static final String VIEW_GRADE = "select a.courseCode,a.courseName,b.grade from crs_course a inner join crs_registeredcourses b on a.courseCode = b.courseCode where b.studentId = ?;";	
	public static final String GET_SEATS = "select seats from crs_course where courseCode = ?;";
	public static final String INSERT_PAYMENT = "insert into crs_payment(studentId,modeofPayment,paymentMethod,referenceId,amount) values(?,?,?,?,?);";
	public static final String INSERT_NOTIFICATION = "insert into crs_notification(studentId,type,referenceId) values(?,?,?);";
	public static final String GET_NOTIFICATION = "select * from crs_notification where referenceId = ?;";
	public static final String ADD_GRADE="update crs_registeredcourses set Grade=? where courseCode=? and studentId=?";
	public static final String GET_COURSES="select * from crs_course where professorId=?";
	public static final String GET_REGISTRATION_STATUS=" select isRegistered from crs_student where studentId = ? ";
	public static final String SET_REGISTRATION_STATUS="update crs_student set isRegistered = true  where studentId=?";
	public static final String GET_ENROLLED_STUDENTS="select a.courseCode,a.courseName,b.studentId from crs_course a inner join crs_registeredcourses b on a.courseCode = b.courseCode where a.professorId = ? order by a.courseCode";
	public static final String NUMBER_OF_REGISTERED_COURSES=" select studentId from crs_registeredcourses where studentId = ? ";
	public static final String IS_REGISTERED=" select courseCode from crs_registeredcourses where courseCode=? and studentId=? ";
}

