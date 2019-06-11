package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import main.Alarm;

public class AlarmTest {

	Alarm alarm;

	@Before
	public void setUp() throws Exception {
		alarm = new Alarm();
	}

	@Test
	public void givenTirePressureLow_WhenChecked_alarmIsOn() {
		alarm.check();
		assertThat(alarm.isAlarmOn(), is(true));
	}

	@Test
	public void givenTirePressureNominal_WhenChecked_alarmIsOff() {
		alarm.check();
		assertThat(alarm.isAlarmOn(), is(false));
	}

	@Test
	public void givenTirePressureHigh_WhenChecked_alarmIsOn() {
		alarm.check();
		assertThat(alarm.isAlarmOn(), is(true));
	}

}
