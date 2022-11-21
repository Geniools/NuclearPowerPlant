import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoolingSystemTest {
	CoolingSystem coolingSystem = new CoolingSystem(1);

	@Test
	void setCollingSystem_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
					new CoolingSystem(-1);
				},
				"Expected CoolingSystem to throw exception, but it didn't"
		);
	}

	@Test
	void abductResidualHeat() {
		coolingSystem.abductResidualHeat(1);
		assertEquals(0.4, coolingSystem.getWaterTemp());
	}
}
