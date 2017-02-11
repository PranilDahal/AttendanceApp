package calstatela;
public class StudentAttendance {

	int Student_id;
	String Attendance;
	public StudentAttendance(int student_id, String attendance) {
		super();
		Student_id = student_id;
		Attendance = attendance;
	}
	public int getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}
	public String getAttendance() {
		return Attendance;
	}
	public void setAttendance(String attendance) {
		Attendance = attendance;
	}
	
	
}
