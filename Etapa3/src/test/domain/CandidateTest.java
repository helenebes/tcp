package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.domain.Candidate;
import contest.domain.CurriculumVitae;

public class CandidateTest {

	Candidate candidate;
	
	@Test
	public void CheckIdtest() {
		candidate = new Candidate("email", new CurriculumVitae("", null), 1);
		assertEquals(candidate.getId(), 1);
	}
	
	@Test
	public void CheckEmailtest() {
		candidate = new Candidate("email", new CurriculumVitae("", null), 1);
		assertEquals(candidate.getEmail(), "email");
	}
	
	@Test
	public void CheckFinalGradetest() {
		candidate = new Candidate("email", new CurriculumVitae("", null), 1);
		candidate.setFinalGrade(17);
		assertEquals(candidate.getFinalGrade(), 17, 0.00);
	}
	
	//test done in CurriculumVitaeTest
	@Test
	public void CheckCVtest() {
		candidate = new Candidate("email", new CurriculumVitae("c:\\cv.pdf", null), 1);
		assertEquals(candidate.getCurriculumVitae().getUrl(), "c:\\cv.pdf");
	}

}
