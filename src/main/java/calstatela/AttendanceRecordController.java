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
public class AttendanceRecordController {

	@Autowired
	DatabaseBean databaseBean;
	
	@RequestMapping(value="/attendanceRecords/{id}", method=RequestMethod.GET)
	public ArrayList<AttendanceRecord> getAttendanceRecords(@PathVariable("id") int id) {
		return databaseBean.AttendanceRecordsforaspecificCourse(id);
	}
	
	@RequestMapping(value="/attendanceRecords", method = RequestMethod.POST)
	public Map<String, String> AddAttendance(@RequestBody AttendanceRecordPostData DataToAdd) {
		
		
		int id = databaseBean.insertAttendance(DataToAdd);
		
		//simple JSON object with single property
		return Collections.singletonMap("id", id+"");
	}
	
	
	
	
	
	
}
