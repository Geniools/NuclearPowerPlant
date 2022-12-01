import java.util.HashSet;
import java.util.Set;

public class ControlRoom {
	private Set<ControlStatus> controlStatuses;

	public ControlRoom() {
		this.controlStatuses = new HashSet<>();
	}

	public void addControlledRoom(ControlStatus room) {
		this.controlStatuses.add(room);
	}
	
	/**
	 * Will check if at least one of the rooms "controlled" are NOT STABLE
	 *
	 * @return False if one room is NOT STABLE, False otherwise
	 */
	public boolean isNuclearReactorStable() {
		for (ControlStatus buildingStatus : getControlStatuses()) {
			if (!buildingStatus.getStatus().equals(Status.STABLE)) {
				return false;
			}
		}

		return true;
	}

	public Set<ControlStatus> getControlStatuses() {
		return this.controlStatuses;
	}
}
