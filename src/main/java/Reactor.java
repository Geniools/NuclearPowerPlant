import java.util.Set;

public class Reactor {
	private Set<Core> cores;

	public Set<Core> getCores() {
		return cores;
	}

	public void setCores(Set<Core> cores) {
		this.cores = cores;
	}

	public Reactor(Set<Core> cores) {
		this.cores = cores;
	}
}
