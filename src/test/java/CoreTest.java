import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoreTest {
	Core core1 = new Nhlium();
	Core core2 = new Stendaanium();

	@Test
	void splitTestExceptions() {
		// Why this does not work???
		// assertThrows(IllegalArgumentException.class, (Executable) core2.split(273.15, 1), "The core must have thrown an exception!");

		// Minimum temperature accepted: 273.16 Kelvin. Minimum time accepted: 0.1s
		assertThrows(IllegalArgumentException.class, () -> core1.split(272, 1), "The core must have thrown an exception!");
		assertThrows(IllegalArgumentException.class, () -> core2.split(273.15, 1), "The core must have thrown an exception!");
		assertThrows(IllegalArgumentException.class, () -> core1.split(273.16, 0), "The core must have thrown an exception!");
		assertThrows(IllegalArgumentException.class, () -> core2.split(273.16, -1), "The core must have thrown an exception!");
		assertDoesNotThrow(() -> core2.split(273.150000001, 0.0000001), "The core must have thrown an exception!");
		assertDoesNotThrow(() -> core1.split(273.16, 0.1), "The core must not have thrown an exception!");
	}

	@Test
	void splitTestResultNhlium() {
		// Below 328 Kelvin
		assertEquals(18, core1.split(327, 2).getResidualHeat(), "Residual heat amount is not correct!");
		assertEquals(99.84, core1.getResidualPercentage(), "Residual percentage is not correct!");
		assertEquals(5.7225, core1.split(327, 2).getHeatAmount(), "Steam amount is not correct!");
		assertEquals(99.68, core1.getResidualPercentage(), "Residual percentage is not correct!");
		// Above or equal 328 Kelvin
		assertEquals(410, core1.split(328, 2).getResidualHeat(), "Residual heat amount is not correct!");
		// For some reason here it returns 99.520000...1 if it is not formatted
		assertEquals(99.52, core1.getResidualPercentage(), "Residual percentage is not correct!");
		assertEquals(314.88, core1.split(328, 2).getHeatAmount(), "Steam amount is not correct!");
		assertEquals(99.36, core1.getResidualPercentage(), "Residual percentage is not correct!");
	}

	@Test
	void splitTestResultStendaanium() {
		// Above or equal 334 Kelvin
		assertEquals(0, core2.split(334, 2).getResidualHeat(), "Residual heat amount is not correct!");
		assertEquals(99.9463, core2.getResidualPercentage(), "Residual percentage is not correct!");
		assertEquals(0, core2.split(334, 2).getHeatAmount(), "Steam amount is not correct!");
		assertEquals(99.8925, core2.getResidualPercentage(), "Residual percentage is not correct!");
		// Below 334 Kelvin
		assertEquals(65.7143, core2.split(333, 2).getResidualHeat(), "Residual heat amount is not correct!");
		assertEquals(99.8925, core2.getResidualPercentage(), "Residual percentage is not correct!");
		assertEquals(16650, core2.split(333, 2).getHeatAmount(), "Steam amount is not correct!");
		assertEquals(99.8925, core2.getResidualPercentage(), "Residual percentage is not correct!");
	}
}
