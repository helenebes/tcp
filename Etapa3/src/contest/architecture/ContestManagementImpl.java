package contest.architecture;

import java.util.List;

import contest.database.Database;
import contest.domain.Contest;
import contest.domain.Vacancy;

public class ContestManagementImpl implements ContestManagement {

	private Database database;
	
	private List<Contest> concursos;
	
	public void createConcurso(String title, List<String> fiel) {
		
	}
	
	public void associate(Vacancy vacancy, Contest contest) {
		
	}
	
	public void updateConcursoData(Object data, Contest contest) {
		
	}
	
	public void closeConcurso(Contest contest){
		
	}
	
	private boolean isFieldAvailable(List<String> fields) {
		return false;
	}
	
	private boolean isAssociationValid(Vacancy vacancy, Contest contest) {
		return false;
	}
	
	private boolean hasAssociatedProtocol() {
		return false;
	}
	
	private boolean isApprovedByColegiado() {
		return false;
	}
}
