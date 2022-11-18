public class Nhlium extends Core {

	private Nhlium() {
		this.THRESHOLD_TEMPERATURE = 328;
	}

	@Override
	public SplitResult split(double temperature, double time) {
		super.split(temperature, time);

		// Updating the residual percentage
		double residualPercentageLost = this.residualPercentage - time * 0.08; // If Java knows math it will multiply first
		this.residualPercentage = Validator.isPositive(residualPercentageLost) ? residualPercentageLost : 0;

		// Calculating the steam and residual heat
		double steam;
		double residualHeat;

		// Just simple math equations
		if (temperature < THRESHOLD_TEMPERATURE) {
			steam = temperature / 80 * time * 0.7;
			residualHeat = time * 0.9;
		} else {
			// 0.8 * T * 0.6 * (square root of 4) * t / t => time (t) can be simplified
			steam = 0.8 * temperature * 0.6 * Math.sqrt(4); // * time / time;
			residualHeat = temperature / 0.8;
		}

		return new SplitResult(residualHeat, steam);
	}
}
