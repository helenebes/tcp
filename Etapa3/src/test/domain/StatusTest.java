package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.domain.Status;
import contest.domain.WithProtocol;
import contest.domain.WithoutProtocol;

public class StatusTest {

	Status status;
	
	@Test
	public void WithoutProtocolStatusTest() {
		status = new WithoutProtocol("preparation");
		assertEquals(status.getStatus(), "preparation");
	}
	
	@Test
	public void WithoutProtocolJustificationTest() {
		status = new WithoutProtocol("preparation");
		assertEquals(status.getJustification(), "");
	}
	
	@Test
	public void WithProtocolStatusTest() {
		status = new WithProtocol("preparation", "ok");
		assertEquals(status.getStatus(), "preparation");
	}
	
	@Test
	public void WithProtocolJustificationTest() {
		status = new WithProtocol("preparation", "ok");
		assertEquals(status.getJustification(), "ok");
	}

}
