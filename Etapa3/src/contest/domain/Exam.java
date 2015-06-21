package contest.domain;

public class Exam {

	private enum type {
		DIDATICA("didatica"), ESCRITA("escrita"), MEMORIAL("Defesa de Memorial"), CV("Analise de CV"), PESQUISA("Plano de pesquisa"); 
		private String testType; 
        private type(String type) { 
            this.testType = type; 
        } 
         
        public String toString(){ 
            return testType; 
        } 		
	};
	
	private Document writtenTest;
	
	//TODO
	public String getType() {
		return type.MEMORIAL.toString();
	}
	
	private boolean isWritten() {
		return false;
	}
	
}
