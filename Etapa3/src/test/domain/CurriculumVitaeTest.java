package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.domain.CurriculumVitae;

public class CurriculumVitaeTest {
	
	CurriculumVitae cv;

	@Test
	public void FileTest() {
		Object file = new Object();
		cv = new CurriculumVitae("c:\\cv.pdf", file);
		assertEquals(cv.getFile(), file);
	}
	
	@Test
	public void UrlTest() {
		Object file = new Object();
		cv = new CurriculumVitae("c:\\cv.pdf", file);
		assertEquals(cv.getUrl(), "c:\\cv.pdf");
	}

}
