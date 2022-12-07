public class Nhlium extends Core {

	public Nhlium() {
		super(328);
//        this.THRESHOLD_TEMPERATURE = 328;
	}

	@Override
	public SplitResult split(double temperature, double time) throws MeltdownException {
		// First input is validated
		this.validateInputParam(temperature, time);
		// Second validate the core specific stuff
		// Just because the assignment was like this (it does not make sense in real life)
		if (Validator.isAboveValue(temperature, 100) && Validator.isOverTimeValue(time, 60)) {
			throw new MeltdownException("The temperature is above 100 Kelvin for more than 60 seconds!");
		}

		// Updating the residual percentage
		double newResidualPercentage = this.residualPercentage - (time * 0.08);
//		this.residualPercentage = Validator.isPositive(newResidualPercentage) ? newResidualPercentage : 0;
		if (Validator.isBelowValue(newResidualPercentage, 0.1)) {
			throw new MeltdownException("The residual percentage went too low!");
		} else {
			this.residualPercentage = newResidualPercentage;
		}

		// Calculating the steam and residual heat
		double steam;
		double residualHeat;

		// Just simple math equations
		if (temperature < THRESHOLD_TEMPERATURE) {
			steam = temperature / 80 * time * 0.7;
			residualHeat = time * 9;
		} else {
			// 0.8 * T * 0.6 * (square root of 4) * t / t => time (t) can be simplified
			steam = 0.8 * temperature * 0.6 * Math.sqrt(4); // * time / time;
			residualHeat = temperature / 0.8;
		}

		return new SplitResult(residualHeat, steam);
	}
}
