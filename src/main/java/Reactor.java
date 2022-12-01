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
