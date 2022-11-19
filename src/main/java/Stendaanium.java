public class Stendaanium extends Core {

	public Stendaanium() {
		this.THRESHOLD_TEMPERATURE = 334;
	}

	@Override
	public SplitResult split(double temperature, double time) {
		super.split(temperature, time);
		
		// Updating the residual percentage
		double residualPercentageLost = this.residualPercentage - ((0.00008 * temperature * time) + 0.0003);

		// Calculating the steam and residual heat
		double steam = 0;
		double residualHeat = 0;

		// Just simple math equations
		if (temperature < THRESHOLD_TEMPERATURE) {
			steam = temperature * 50;
			residualHeat = time * 23 / 0.7;
		} else {
			this.residualPercentage = Validator.isPositive(residualPercentageLost) ? residualPercentageLost : 0;
		}

		return new SplitResult(residualHeat, steam);
	}
}
