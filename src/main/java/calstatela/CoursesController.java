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
public class CoursesController {

	
	
	@Autowired
	DatabaseBean databaseBean;
	
	@RequestMapping("/courses")
	public ArrayList<Course> getCourses() {
		return databaseBean.getAllCourses();
	}
	
	

	
	
}
