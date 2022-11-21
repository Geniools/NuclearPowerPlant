import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
	Generator generator = new Generator();

	@Test
	void generateEnergy() {
		assertEquals(24, generator.generateEnergy(2));
		assertEquals(24, generator.getTotalAmountEnergy());
		assertEquals(24, generator.generateEnergy(2));
		assertEquals(48, generator.getTotalAmountEnergy());
		assertEquals(12, generator.generateEnergy(1));
		assertEquals(60, generator.getTotalAmountEnergy());
	}
}
