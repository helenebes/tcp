package test.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import contest.domain.Schedule;

public class ScheduleTest {
	
	Schedule schedule;

	@Test
	public void GetScheduleTest() {
		schedule = new Schedule("monday : test");
		assertEquals(schedule.getSchedule(), "monday : test");
	}

}
