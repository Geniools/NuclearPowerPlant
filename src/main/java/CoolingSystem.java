public class CoolingSystem implements ControlStatus {
	private double waterTemp;

	public CoolingSystem(double waterTemp) {
		if (!Validator.isPositive(waterTemp)) {
			throw new IllegalArgumentException("Water temperature must be above 0!");
		}

		this.waterTemp = waterTemp;
	}

	public double getWaterTemp() {
		return this.waterTemp;
	}

	/**
	 * Will cool down the residual heat using water,
	 * Water temperature will obviously increase as a result
	 *
	 * @param heat The residual heat
	 * @return The water temperature after cooling down the residual heat
	 */
	public double abductResidualHeat(double heat) {
		double waterTemp = heat * 0.4;
		this.waterTemp = waterTemp;

		return waterTemp;
	}

	@Override
	public Status getStatus() {
		if (this.getWaterTemp() > 80 && this.getWaterTemp() < 90) {
			return Status.ATTENTION;
		}

		if (this.getWaterTemp() > 90) {
			return Status.UNSTABLE;
		}

		return Status.STABLE;
	}
}
