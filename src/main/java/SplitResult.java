public class SplitResult {
	private double residualHeat;
	private double heatAmount;

	public SplitResult(double residualHeat, double heatAmount) {
		this.residualHeat = residualHeat;
		this.heatAmount = heatAmount;
	}

	private double getResidualHeat() {
		return this.residualHeat;
	}

	private void setResidualHeat(double residualHeat) {
		this.residualHeat = residualHeat;
	}

	private double getHeatAmount() {
		return this.heatAmount;
	}

	private void setHeatAmount(double heatAmount) {
		this.heatAmount = heatAmount;
	}
}
