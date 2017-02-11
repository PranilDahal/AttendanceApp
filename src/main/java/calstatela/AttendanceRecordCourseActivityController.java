package calstatela;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceRecordCourseActivityController {

	@Autowired
	DatabaseBean databaseBean;

	@RequestMapping(value="/attendanceRecordCourseActivity/{id}/{activity_name}", method=RequestMethod.GET)
	public ArrayList<AttendanceRecord> getEmployee(@PathVariable("id") int id, @PathVariable("activity_name") String activity_name) {
		ArrayList<AttendanceRecord> list =new ArrayList<AttendanceRecord>();

		for(AttendanceRecord x: databaseBean.AttendanceRecordsforaspecificCourse(id)){
			if(x.Activity.equals(activity_name)){
				list.add(x);
			}
		}
		return list;
	}
	
	

}
