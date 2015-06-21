package contest.domain;

public class Exam {
	
	private Document writtenTest;
	private String type;
	/*private enum type {
		DIDATICA("didatica"), ESCRITA("escrita"), MEMORIAL("Defesa de Memorial"), CV("Analise de CV"), PESQUISA("Plano de pesquisa"); 
		private String testType; 
        private type(String type) { 
            this.testType = type; 
        } 
         
        public String toString(){ 
            return testType; 
        } 		
	};*/
	
	public Exam(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public boolean isWritten() {
		if (type.contains("escrita"))
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
