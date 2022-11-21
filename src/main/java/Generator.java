public class Generator {
	private double totalAmountEnergy;

	/**
	 * Will "generate" energy in the Power Plant based on the amount of steam created
	 * Will add the energy generated to the total amount of energy the reactor has generated
	 *
	 * @param steamAmount The steam amount in m3 (cubic meters)
	 * @return A double representing the energy generated
	 */
	public double generateEnergy(double steamAmount) {
		// Steam amount cannot be below zero, otherwise there is nothing to turn the turbines with, therefore 0 energy
		double energy = Validator.isPositive(steamAmount) ? steamAmount * 12 : 0;
		this.addEnergy(energy);
		return energy;
	}

	private void addEnergy(double amount) {
		this.totalAmountEnergy += amount;
	}

	public double getTotalAmountEnergy() {
		return this.totalAmountEnergy;
	}
}
