package calstatela;
public class Student {
	
	int Id;
	String Name;
	int CIN;
	public Student(int id, String name, int cIN) {
		super();
		Id = id;
		Name = name;
		CIN = cIN;
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
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int cIN) {
		CIN = cIN;
	}
	 
	
	
}
