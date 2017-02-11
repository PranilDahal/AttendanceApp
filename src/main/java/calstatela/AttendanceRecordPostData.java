package calstatela;
import java.util.ArrayList;

public class AttendanceRecordPostData {

	int course_id;
	String activity_name;
	int student_id;
	String status_;
	
	public AttendanceRecordPostData(){}
	public AttendanceRecordPostData(int course_id, String activity_name, int student_id, String status_) {
		
		this.course_id = course_id;
		this.activity_name = activity_name;
		this.student_id = student_id;
		this.status_ = status_;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStatus() {
		return status_;
	}
	public void setStatus(String status) {
		this.status_ = status;
	}
	
}