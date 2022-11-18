import java.util.Date;

public class PowerPlant {
	private Generator generator;
	private Reactor reactor;
	private CoolingSystem coolingSystem;

	public PowerPlant(Generator generator, Reactor reactor, CoolingSystem coolingSystem) {
		setGenerator(generator);
		setReactor(reactor);
		setCoolingSystem(coolingSystem);
	}

	public Generator getGenerator() {
		return this.generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}

	public Reactor getReactor() {
		return this.reactor;
	}

	public void setReactor(Reactor reactor) {
		this.reactor = reactor;
	}

	public CoolingSystem getCoolingSystem() {
		return this.coolingSystem;
	}

	public void setCoolingSystem(CoolingSystem coolingSystem) {
		this.coolingSystem = coolingSystem;
	}

	public float run(float temperature, Date time) {
		return 0;
	}
}
