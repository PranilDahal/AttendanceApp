package calstatela;
import java.util.ArrayList;

public class Course {

	int Id;
	String Name;
	String TimeDate;
	int Units;
	int section;
	String Location;
	String Instructor;
	ArrayList<Student> Students;
	public Course(int id, String name, String timeDate, int units, int section, String location, String instructor,
			ArrayList<Student> students) {
		super();
		Id = id;
		Name = name;
		TimeDate = timeDate;
		Units = units;
		this.section = section;
		Location = location;
		Instructor = instructor;
		Students = students;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTimeDate() {
		return TimeDate;
	}
	public void setTimeDate(String timeDate) {
		TimeDate = timeDate;
	}
	public int getUnits() {
		return Units;
	}
	public void setUnits(int units) {
		Units = units;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getInstructor() {
		return Instructor;
	}
	public void setInstructor(String instructor) {
		Instructor = instructor;
	}
	public ArrayList<Student> getStudents() {
		return Students;
	}
	public void setStudents(ArrayList<Student> students) {
		Students = students;
	}
	
	
}
