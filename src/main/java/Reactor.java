import java.util.Set;

public class Reactor {
	private Set<Core> cores;

	public Reactor(Set<Core> cores) {
		this.cores = cores;
	}

	public Set<Core> getCores() {
		return cores;
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
}
