package calstatela;
public class AttendanceRecord {

	int id;
	Course Course;
	Student Student;
	String Activity;
	String Status;
	public AttendanceRecord(int id, Course course, Student student, String activity, String status) {
		super();
		this.id = id;
		Course = course;
		Student = student;
		Activity = activity;
		Status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Course getCourse() {
		return Course;
	}
	public void setCourse(Course course) {
		Course = course;
	}
	public Student getStudent() {
		return Student;
	}
	public void setStudent(Student student) {
		Student = student;
	}
	public String getActivity() {
		return Activity;
	}
	public void setActivity(String activity) {
		Activity = activity;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	

	
}
