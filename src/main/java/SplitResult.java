public class SplitResult {
	private double residualHeat;
	private double heatAmount; // steam

	public SplitResult(double residualHeat, double heatAmount) {
		this.residualHeat = residualHeat;
		this.heatAmount = heatAmount; // steam
	}

	public double getResidualHeat() {
		return this.residualHeat;
	}

//	public void setResidualHeat(double residualHeat) {
//		this.residualHeat = residualHeat;
//	}

	public double getHeatAmount() {
		return this.heatAmount;
	}

//	public void setHeatAmount(double heatAmount) {
//		this.heatAmount = heatAmount;
//	}
}
