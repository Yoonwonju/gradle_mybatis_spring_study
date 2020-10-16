package gradle_mybatis_spring_study.dto;

import java.util.List;

public class Tutor {
	private int tutorId;
	private String name;
	private String email;
	private Address address;
	private List<Course> courses;
	private PhoneNumber phone;

	@Override
	public String toString() {
		return String.format("Tutor [tutorId=%s, name=%s, email=%s, address=%s, courses=%s, phone=%s]", tutorId, name,
				email, address, courses, phone);
	}

	public Tutor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutor(int tutorId, String name, String email, Address address, PhoneNumber phone) {
		super();
		this.tutorId = tutorId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public Tutor(int tutorId, String name, String email, Address address, List<Course> courses, PhoneNumber phone) {
		super();
		this.tutorId = tutorId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.courses = courses;
		this.phone = phone;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getTutorId(int tutorId) {
		return tutorId;
	}

}
