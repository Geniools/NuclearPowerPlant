public abstract class Core {
	private static final int RESIDUAL_PERCENTAGE = 100;
	protected int THRESHOLD_TEMPERATURE;
	protected double residualPercentage;

	public Core() {
		this.residualPercentage = Core.RESIDUAL_PERCENTAGE;
	}

	/**
	 * The "split" inside a core to produce heat and steam
	 * Will calculate the results differently based on the core type
	 *
	 * @param temperature The temperature inside the core
	 * @param time        The time the temperature passed was maintained
	 * @return The heat and steam in the SplitResult class
	 */
	public SplitResult split(double temperature, double time) {
		// Temperature cannot be below freezing point (or else we make another Chernobyl)
		if (!Validator.isAboveFreezingTemperatureKelvin(temperature)) {
			throw new IllegalArgumentException("Temperature cannot be below the freezing point!");
		}
		// Time obviously cannot be negative
		if (!Validator.isPositive(time)) {
			throw new IllegalArgumentException("Time cannot be negative!");
		}
		// Just to avoid errors...
		return null;
	}

	@Override
	public String toString() {
		// Returns the class' name
		return this.getClass().getSimpleName();
	}
}
