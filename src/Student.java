

public class Student {
	
	private String id;
	private String degree;
	private String track;
	private String graduationDate;

	public Student() {
	}

	public Student(String id, String degree, String track, String graduationDate) {
		super();
		this.id = id;
		this.degree = degree;
		this.track = track;
		this.graduationDate = graduationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	

	
	
	
}
