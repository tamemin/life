package uk.co.nime.life;

public class Cell {
	
	private LifeState lifeState;
	
	
	public Cell() {
		lifeState=LifeState.DEAD;
	}
	
	public void setAlive() {
		lifeState = LifeState.ALIVE;
	}
	public void kill() {
		lifeState = LifeState.DEAD;
	}
	
	public LifeState getLifeState() {
		return lifeState;
	}

}
