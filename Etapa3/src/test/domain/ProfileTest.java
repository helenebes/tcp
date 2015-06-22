package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.domain.Adjunct;
import contest.domain.Assistente;
import contest.domain.Auxiliarly;
import contest.domain.Profile;
import contest.domain.Titular;

public class ProfileTest {
	
	Profile profile;

	@Test
	public void TitularTest() {
		profile = new Titular();
		assertEquals(profile.getProfile(), "titular");
	}
	
	@Test
	public void AdjunctTest() {
		profile = new Adjunct();
		assertEquals(profile.getProfile(), "adjunct");
	}
	
	@Test
	public void AssistenteTest() {
		profile = new Assistente();
		assertEquals(profile.getProfile(), "assistente");
	}
	
	@Test
	public void AuxiliarlyTest() {
		profile = new Auxiliarly();
		assertEquals(profile.getProfile(), "auxiliarly");
	}

}
