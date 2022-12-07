public abstract class Core {
	public static final int DEFAULT_RESIDUAL_PERCENTAGE = 100;
	protected final int THRESHOLD_TEMPERATURE;
	protected double residualPercentage;

	public Core(int thresholdTemperature) {
		THRESHOLD_TEMPERATURE = thresholdTemperature;
		this.residualPercentage = Core.DEFAULT_RESIDUAL_PERCENTAGE;
	}

	public double getResidualPercentage() {
//		return Validator.getFormattedDouble(this.residualPercentage);
		return this.residualPercentage;
	}

	/**
	 * The "split" inside a core to produce heat and steam
	 * Will calculate the results differently based on the core type
	 *
	 * @param temperature The temperature inside the core
	 * @param time        The time the temperature passed was maintained
	 * @return The heat and steam in the SplitResult class
	 */
	public abstract SplitResult split(double temperature, double time) throws MeltdownException; // DO WE HAVE TO ADD "throws Exception" to an abstract method???

	protected void validateInputParam(double temperature, double time) throws MeltdownException {
		// Temperature cannot be below freezing point (or else we make another Chernobyl) (NOT in the assignment)
//		if (!Validator.isAboveFreezingTemperatureKelvin(temperature)) {
//			throw new MeltdownException("Temperature cannot be below the freezing point!");
//		}
		// Time obviously cannot be negative (NOT in the assignment)
		if (!Validator.isPositive(time)) {
			throw new MeltdownException("Time cannot be negative!");
		}
	}

	@Override
	public String toString() {
		// Returns the class' name
		return this.getClass().getSimpleName();
	}
}

