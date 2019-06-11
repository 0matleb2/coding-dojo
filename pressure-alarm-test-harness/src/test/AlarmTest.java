package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import main.Alarm;
import main.PsiSensor;

public class AlarmTest {

	static final double LOW_PSI = 16.0;
	static final double NOMINAL_PSI = 18.5;
	static final double HIGH_PSI = 22.0;

	Alarm alarm;
	PsiSensor mockSensor;

	@Before
	public void setUp() throws Exception {
		mockSensor = mock(PsiSensor.class);
		alarm = new Alarm(mockSensor);    	
	}

	@Test
	public void givenTirePressureLow_WhenChecked_alarmIsOn() {
		when(mockSensor.popNextPressurePsiValue()).thenReturn(LOW_PSI);
		alarm.check();
		assertThat(alarm.isAlarmOn(), is(true));
	}

	@Test
	public void givenTirePressureNominal_WhenChecked_alarmIsOff() {
		when(mockSensor.popNextPressurePsiValue()).thenReturn(NOMINAL_PSI);
		alarm.check();
		assertThat(alarm.isAlarmOn(), is(false));
	}

	@Test
	public void givenTirePressureHigh_WhenChecked_alarmIsOn() {
		when(mockSensor.popNextPressurePsiValue()).thenReturn(HIGH_PSI);
		alarm.check();
		assertThat(alarm.isAlarmOn(), is(true));
	}

}
