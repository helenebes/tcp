package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.domain.Status;
import contest.domain.WithProtocol;
import contest.domain.WithoutProtocol;
import contest.ui.graphic.action.BusinessException;

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
	public void WithProtocolStatusTest() throws BusinessException {
		status = new WithProtocol("preparation", "ok", "aprovado");
		assertEquals(status.getStatus(), "preparation");
	}
	
	@Test
	public void WithProtocolJustificationTest() throws BusinessException {
		status = new WithProtocol("preparation", "ok", "aprovado");
		assertEquals(status.getJustification(), "ok");
	}

	@Test
	public void WithProtocolAprovatedTest() throws BusinessException {
		WithProtocol statusWithProtocol = new WithProtocol("preparation", "ok", "aprovado");
		assertEquals(statusWithProtocol.getStatusType(), "APROVADO");
	}
	
	@Test
	public void WithProtocolReprovadoTest() throws BusinessException {
		WithProtocol statusWithProtocol = new WithProtocol("preparation", "ok", "reprovado");
		assertEquals(statusWithProtocol.getStatusType(), "REPROVADO");
	}
	
	@Test (expected = BusinessException.class)
	public void WithProtocolExceptionTest() throws BusinessException {
		status = new WithProtocol("preparation", "ok", "");
	}
}
