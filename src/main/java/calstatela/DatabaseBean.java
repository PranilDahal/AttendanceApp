package calstatela;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

@Component
public class DatabaseBean {

	private JdbcTemplate jdbcTemplate;

	private SimpleJdbcInsert insertAttendanceRecord;


	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertAttendanceRecord = new SimpleJdbcInsert(dataSource).withTableName("Attendances")
				.usingGeneratedKeyColumns("id");
		;
	}

	
	public ArrayList<Course> getAllCourses(){
		ArrayList<Course> courses=(ArrayList<Course>) this.jdbcTemplate.query("Select * from Courses",new RowMapper<Course>(){

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException{
				int id=rs.getInt("id");
				String name=rs.getString("course_name");
				String time=rs.getString("time_and_date");
				int units=rs.getInt("units");
				int section=rs.getInt("section");
				String loc=rs.getString("location");
				String inst=rs.getString("instructor");
				return new Course(id,name,time,units,section,loc,inst,getStudentsforaspecificCourse(id));


			}

		});		

		return courses;
	}
	
	
	
	
	


	private static final class StudentMapper implements RowMapper<Student> {
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String name=rs.getString("student_name");
			int CIN =rs.getInt("CIN");
			return new Student(id,name,CIN);
		}
	}



	public ArrayList<Student> getStudentsforaspecificCourse(int id){
		ArrayList<Student> Students = (ArrayList<Student>) this.jdbcTemplate.query("select x.student_id as 'id', s.student_name as 'student_name', s.CIN as 'CIN' from student_course x, Students s where x.course_id="+id+" and x.student_id=s.id;", new StudentMapper());
		return Students;

	}


	public ArrayList<AttendanceRecord> AllAttendanceRecords(){

		ArrayList<AttendanceRecord> records = (ArrayList<AttendanceRecord>) this.jdbcTemplate.query("Select * from Attendances", new RowMapper<AttendanceRecord>(){

			public AttendanceRecord mapRow(ResultSet rs, int rowNum) throws SQLException{
				int id=rs.getInt("id");
				int c=rs.getInt("course_id");
				Course course=null;
				for(Course x: getAllCourses()){
					if(x.Id==c){
						course=x;
					}
				}

				int s=rs.getInt("student_id");
				Student student=null;
				for(Student x: getStudentsforaspecificCourse(c)){
					if(x.Id==s){
						student=x;
					}
				}
				String name=rs.getString("activity_name");
				String status=rs.getString("status_");
				return new AttendanceRecord(id,course,student,name,status);


			}

		});		

		return records;

	}


	public ArrayList<AttendanceRecord> AttendanceRecordsforaspecificCourse(int id){

		ArrayList<AttendanceRecord> list=new ArrayList<AttendanceRecord>();
		for(AttendanceRecord x: AllAttendanceRecords()){
			if(x.Course.Id==id){
				list.add(x);

			}
		}
		return list;

	}
	
	
	
	public ArrayList<AttendanceRecord> AttendanceRecordsforaspecificCourseAndActivity(int id, String act){
		ArrayList<AttendanceRecord> list=new ArrayList<AttendanceRecord>();
		
		for(AttendanceRecord x: AllAttendanceRecords()){
			if(x.Course.Id==id){
				if(x.Activity.equals(act)){
					list.add(x);
				}

			}
		}
		
		return list;
		
	}
	
	
	
	public int insertAttendance(AttendanceRecordPostData DataToAdd) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		
		
	
			parameters.put("course_id", DataToAdd.course_id);
			
			parameters.put("activity_name", DataToAdd.activity_name);
			parameters.put("student_id", DataToAdd.student_id);
			parameters.put("status_", DataToAdd.status_);
			
			Number newId= insertAttendanceRecord.executeAndReturnKey(parameters);
			
		
		return newId.intValue();
	}
	
	






}
