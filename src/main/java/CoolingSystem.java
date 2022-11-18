public class CoolingSystem {
	private double waterTemp;

	public CoolingSystem(double waterTemp){
		if(waterTemp < 0){
			throw new IllegalArgumentException("Water temperature must be above 0!");
		}

		this.waterTemp = waterTemp;
	}

	public double getWaterTemp() {
		return this.waterTemp;
	}

	public double abductResidualHeat(double heat){
		return 0;
	}
}
