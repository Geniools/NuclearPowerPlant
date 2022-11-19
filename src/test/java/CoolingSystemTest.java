import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoolingSystemTest {

	@Test
	void setCollingSystem_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class,() ->
			new CoolingSystem(-1),
			"Expected CoolingSystem to throw exception, but it didn't"
		);
	}
}
