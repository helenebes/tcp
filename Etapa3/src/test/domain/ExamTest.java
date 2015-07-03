package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.domain.Document;
import contest.domain.Exam;
import contest.ui.graphic.action.BusinessException;

public class ExamTest {

	Exam exam;
	
	@Test
	public void CheckTypeTest() throws BusinessException {
		exam = new Exam("escrita");
		assertEquals(exam.getType(), "ESCRITA");
	}
	
	@Test (expected=BusinessException.class)
	public void CheckTypeExceptiontest() throws BusinessException {
		exam = new Exam("parole");
	}

	@Test
	public void CheckWrittenTest() throws BusinessException {
		exam = new Exam("escrita");
		assertTrue(exam.isWritten());
	}
	
	@Test
	public void CheckAddDocumentTest() throws BusinessException {
		exam = new Exam("cv");
		Document document = new Document("cv : helene besancon");
		exam.addDocument(document);
		assertEquals(exam.getWrittenTest(), document);
	}
	
}
