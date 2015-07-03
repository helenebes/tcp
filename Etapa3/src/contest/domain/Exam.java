package contest.domain;

import contest.ui.graphic.action.BusinessException;

public class Exam {
	
	private Document writtenTest;
	private enum Type {DIDATICA , ESCRITA, MEMORIAL, CV, PESQUISA};
	private Type examType;
	
	public Exam(String type) throws BusinessException {
		if(type.contains("didatica")) {
			examType = Type.DIDATICA;
		} else if (type.contains("escrita")) {
			examType = Type.ESCRITA;
		} else if (type.contains("cv")) {
			 examType = Type.CV;
		} else if (type.contains("pesquisa")) {
			examType = Type.PESQUISA;
		} else {
			throw new BusinessException("problem of type of exam");
		}
	}

	public String getType() {
		return examType.toString();
	}
	
	public boolean isWritten() {
		if (examType.toString().equals("ESCRITA"))
			return true;
		return false;
	}
	
	public void addDocument(Document writtenTest) {
		this.writtenTest = writtenTest;
	}
	
	public Document getWrittenTest() {
		return writtenTest;
	}
}
