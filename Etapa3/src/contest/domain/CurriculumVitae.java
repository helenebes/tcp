package contest.domain;

public class CurriculumVitae {

	private String url;
	private Object file;
	
	public CurriculumVitae(String url, Object file) {
		this.url = url;
		this.file = file;
	}
	
	public String getUrl() {
		return url;
	}
	public Object getFile() {
		return file;
	}
	
	
}
