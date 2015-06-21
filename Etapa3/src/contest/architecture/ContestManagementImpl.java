package contest.architecture;

import java.util.List;

import contest.domain.Database;
import contest.domain.Contest;
import contest.domain.Vacancy;

public class ContestManagementImpl implements ContestManagement {

	private contest.database.Database database;
	
	private List<Contest> concursos;
	
	public ContestManagementImpl(contest.database.Database database2) {
		this.database = database2;
	}
	
	public void createConcurso(String title, List<String> fiel) {
		
	}
	
	public void associate(Vacancy vacancy, Contest contest) {
		vacancy.addContest(contest);
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
	
	public List<Contest> getAllContests() {
		return database.getContests();
	}
	
	public List<Vacancy> getAllVacancies() {
		return database.getVacancies();
	}
}
