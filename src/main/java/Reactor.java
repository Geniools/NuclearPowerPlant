import java.util.HashSet;
import java.util.Set;

public class Reactor implements ControlStatus {
	private Set<Core> cores;

	public Reactor(Set<Core> cores) {
		this.cores = cores;
	}

	public Reactor() {
		this.cores = new HashSet<>();
	}

	public Set<Core> getCores() {
		return this.cores;
	}

	public void setCores(Set<Core> cores) {
		this.cores = cores;
	}

	public SplitResult run(double temperature, double time) throws MeltdownException {
		// This method can be used in the power plant for getting the total steam and residual heat generator
		// It might be better codewise to
		double totalSteam = 0;
		double totalResidualHeat = 0;

		for (Core core : this.getCores()) {
			SplitResult splitResult = core.split(temperature, time);
			totalSteam += splitResult.getHeatAmount();
			totalResidualHeat += splitResult.getResidualHeat();
		}

		return new SplitResult(totalSteam, totalResidualHeat);
	}

	/**
	 * Adding another Core to the Reactor
	 *
	 * @param core The core to be added
	 */
	public void addCore(Core core) {
		this.cores.add(core);
	}

	@Override
	public Status getStatus() {
		for (Core core : this.getCores()) {
			if (core.getResidualPercentage() <= 0.2) {
				return Status.ATTENTION;
			}
		}

		return Status.STABLE;
	}
}
