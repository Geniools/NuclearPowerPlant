import java.text.DecimalFormat;

/**
 * The type Validator. Used for the Nuclear Power Plant system.
 * Used for different validation methods inside the system.
 * Also contains methods for common used calculations within the system.
 */
public abstract class Validator {
	// The freezing temperature for Kelvin (0 in Celsius)
	public static final double FREEZING_TEMPERATURE_KELVIN = 273.15;

	/**
	 * Checks a number to be positive.
	 *
	 * @param nr The nr to be validated
	 * @return True if the number is positive, false otherwise
	 */
	public static boolean isPositive(double nr) {
		return nr > 0;
	}

	/**
	 * Checks the temperature to be above freezing level.
	 *
	 * @param temperature The temperature in Kelvin.
	 * @return True if above freezing level, false otherwise
	 */
	public static boolean isAboveFreezingTemperatureKelvin(double temperature) {
		return temperature > FREEZING_TEMPERATURE_KELVIN;
	}

	public static boolean isAboveValue(double temperature, double value) {
		return temperature > value;
	}

	public static boolean isBelowValue(double percentage, double value) {
		return percentage < value;
	}

	public static boolean isOverTimeValue(double time, double value) {
		return time > value;
	}

	public static double getFormattedDouble(double number) {
		// Formatting the double to return only the last 4 decimals
		DecimalFormat format = new DecimalFormat("0.0000");
		return Double.parseDouble(format.format(number));
	}
}
