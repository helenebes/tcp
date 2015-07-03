package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.domain.Document;

public class DocumentTest {
	
	Document document;

	@Test
	public void test() {
		document = new Document("document");
		assertEquals(document.getDocument(), "document");
	}

}
