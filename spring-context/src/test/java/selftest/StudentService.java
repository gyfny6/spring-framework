package selftest;

public class StudentService {

	private String name;

	private Integer age;

	private StudentService studentService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public String toString() {
		return "StudentService{" +
				"name='" + name + '\'' +
				", age=" + age +
				", studentService=" + studentService +
				'}';
	}
}
