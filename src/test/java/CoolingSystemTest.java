import static org.junit.jupiter.api.Assertions.*;

class CoolingSystemTest {

	@org.junit.jupiter.api.Test
	void setCollingSystem_ThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class,() ->
			new CoolingSystem(-1),
			"Expected CoolingSystem to throw exception, but it didn't"
		);
	}
}
