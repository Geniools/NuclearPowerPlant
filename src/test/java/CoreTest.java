import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoreTest {
    Core core1 = new Nhlium();
    Core core2 = new Stendaanium();

    @Test
    void splitTestExceptions() {
        // Why this does not work???
        // assertThrows(IllegalArgumentException.class, (Executable) core2.split(273.15, 1), "The core must have thrown an exception!");
        assertThrows(IllegalArgumentException.class, () -> core1.split(272, 1), "The core must have thrown an exception!");
        assertThrows(IllegalArgumentException.class, () -> core2.split(273.15, 1), "The core must have thrown an exception!");
        assertThrows(IllegalArgumentException.class, () -> core1.split(273.16, 0), "The core must have thrown an exception!");
        assertThrows(IllegalArgumentException.class, () -> core2.split(273.16, -1), "The core must have thrown an exception!");
        assertDoesNotThrow(() -> core1.split(273.16, 0.1), "The core must not have thrown an exception!");
    }

    @Test
    void splitTestResultNhlium() {
        // Above 328 Kelvin
        assertEquals(18, core1.split(327, 2).getResidualHeat(), "Residual heat amount is not correct!");
        assertEquals(5.7225, core1.split(327, 2).getHeatAmount(), "Steam amount is not correct!");
    }
}