package contest.domain;

public class Candidate extends Person {

	private int id;
	private String email;
	private CurriculumVitae curriculumVitae;
	private float finalGrade;
	
	public Candidate(String lastName, String firstName, String email, CurriculumVitae curriculumVitae, int id) {
		super(lastName, firstName);
		this.id = id;
		this.email = email;
		this.curriculumVitae = curriculumVitae;
	}
	
	
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public CurriculumVitae getCurriculumVitae() {
		return curriculumVitae;
	}
	public float getFinalGrade() {
		return finalGrade;
	}
	
	public void setFinalGrade(float finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	
}
