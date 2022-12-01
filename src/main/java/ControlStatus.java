public interface ControlStatus {
	/**
	 * Will return the status of the class which implements this interface.
	 * Each room changes the STATUS based on specific checks related to the room.
	 *
	 * @return The STATUS of the room.
	 */
	Status getStatus();
}
