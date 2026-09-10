package equalshashcodeoverride;

import java.util.HashMap;
import java.util.Objects;

class Student{
	private int id;
	private String name;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if( o == null ||  this.getClass() != o.getClass() ) return false;
		Student s1 = (Student) o;
		return this.id == s1.id && Objects.equals(s1.name, this.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,name);
	}
	
}

public class Prac1 {
	
	public static void main(String [] args) {
		Student s1= new Student(1,"abc");
		Student s2 = new Student(1,"abc");
	
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		HashMap<Student, String> mp1 = new HashMap<>();
		mp1.put(s1,"present");
		mp1.put(s2,"present");
		System.out.println(mp1.get(s1));
		System.out.println(mp1.get(new Student(100, "abcd")));
	}
	
}
