import java.util.Date;

public class PowerPlant {
	private Generator generator;
	private Reactor reactor;
	private CoolingSystem coolingSystem;

	public PowerPlant(Generator generator, Reactor reactor, CoolingSystem coolingSystem) {
		this.generator = generator;
		this.reactor = reactor;
		this.coolingSystem = coolingSystem;
	}

	public Generator getGenerator() {
		return generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	public Reactor getReactor() {
		return reactor;
	}

	public void setReactor(Reactor reactor) {
		this.reactor = reactor;
	}

	public CoolingSystem getCoolingSystem() {
		return coolingSystem;
	}

	public void setCoolingSystem(CoolingSystem coolingSystem) {
		this.coolingSystem = coolingSystem;
	}

	public float run(float temp, Date time){
		return 0;
	}
}
