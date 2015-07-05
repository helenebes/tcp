package test.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import contest.domain.Candidate;
import contest.domain.Contest;
import contest.domain.Exam;
import contest.domain.ExaminationBoard;
import contest.domain.Schedule;
import contest.domain.Status;
import contest.domain.User;
import contest.domain.Vacancy;
import contest.domain.WithoutProtocol;
import contest.ui.graphic.action.BusinessException;

public class ContestTest {

	Contest contest;
	
	@Test
	public void CheckTitleTest() {
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		assertEquals(contest.getContestTitle(), "title");
	}
	
	@Test
	public void CheckVacancyAmountTest() {
		Vacancy vacancy = new Vacancy("titular", new User("besancon", "helene", 4, "helene", "aa", "student", null));
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		contest.addVacancy(vacancy);
		assertEquals(contest.getVacancyAmount(), 1);
	}
	
	@Test
	public void CheckVacancyAmountNullTest() {
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		assertEquals(contest.getVacancyAmount(), 0);
	}
	
	@Test
	public void CheckVacanciesTest() {
		Vacancy vacancy = new Vacancy("titular", new User("besancon", "helene", 4, "helene", "aa", "student", null));
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		List<Vacancy> vacancies = new ArrayList<Vacancy>();
		vacancies.add(vacancy);
		contest.addVacancy(vacancy);
		assertEquals(contest.getVacancies(), vacancies);
	}

	@Test
	public void CheckFieldsTest() {
		List<String> fields = new ArrayList<String>();
		fields.add("field1");
		fields.add("field2");
		contest = new Contest("title", fields, "20H", "program : ");		
		assertEquals(contest.getFields(), fields);
	}
	
	@Test
	public void CheckWorkRegimeTest() {
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		assertEquals(contest.getWorkRegime(), "20H");
	}
	
	@Test
	public void CheckProgramTest() {
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		assertEquals(contest.getProgram().toString(), "program : ");
	}
	
	@Test
	public void CheckStatusTest() {
		Status oneStatus = new WithoutProtocol("closed");
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		List<Status> status = contest.getStatusLog();
		contest.addContestStatus(oneStatus);
		status.add(oneStatus);
		assertEquals(contest.getStatusLog(), status);
	}
	
	@Test
	public void CheckExaminationBoardTest() {
		ExaminationBoard examinationBoard = new ExaminationBoard(null, null, null);
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		contest.setExaminationBoard(examinationBoard);
		assertEquals(contest.getExaminationBoard(), examinationBoard);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void CheckStartDateTest() {
		Date now = new Date();
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		assertEquals(contest.getStartDate().getHours(), now.getHours());
	}
	
	@Test
	public void CheckExamTest() throws BusinessException {
		Exam exam = new Exam("escrita");
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		contest.addExam(exam);
		List<Exam> exams = new ArrayList<Exam>();
		exams.add(exam);
		assertEquals(contest.getExams(), exams);
	}
	
	@Test
	public void CheckCandidateTest() {
		Candidate candidate = new Candidate("besancon", "helene", "helene.besancon@free.fr", null, 1);
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		contest.addCandidate(candidate);
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(candidate);
		assertEquals(contest.getCandidates(), candidates);
	}
	
	@Test
	public void CheckScheduleTest() {
		Schedule schedule = new Schedule("monday : test");
		contest = new Contest("title", new ArrayList<String>(), "20H", "program : ");
		contest.setSchedule(schedule);
		assertEquals(contest.getSchedule(), schedule);
	}
}
