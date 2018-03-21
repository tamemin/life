package uk.co.nime.life;

public class SimArea {
	
	private Cell[][] playArea = new Cell[3][3];
	
	/**
	 * Scan each cell in the play area
	 * call count neighbours to determine action for death of cell due
	 * to under population
	 * 
	 */
	public void simUnderPopDeath() {
		
	}
	
	public void initPlayArea() {
		for (int x=0;x<3;x++) {
			for (int y=0;y<3;y++) {
				playArea[x][y] = new Cell();
			}
		}
	}
	
	public int countLivingNeighbours(int x, int y) {
		
		Cell topLeft = playArea[x-1][y-1];
		Cell topMiddle = playArea[x][y-1];
		Cell topRight = playArea[x+1][y-1];
		
		Cell middleLeft = playArea[x-1][y];
		Cell middleRight = playArea[x+1][y];
		
		Cell botomLeft = playArea[x-1][y+1];
		Cell bottomMiddle = playArea[x][y+1];
		Cell bottomRight = playArea[x+1][y+1];
		
		int count = 0;
		
		if (topLeft.getLifeState()==LifeState.ALIVE) count++;
		if (topMiddle.getLifeState()==LifeState.ALIVE) count++;
		if (topRight.getLifeState()==LifeState.ALIVE) count++;
		if (middleLeft.getLifeState()==LifeState.ALIVE) count++;
		if (middleRight.getLifeState()==LifeState.ALIVE) count++;
		if (botomLeft.getLifeState()==LifeState.ALIVE) count++;
		if (bottomMiddle.getLifeState()==LifeState.ALIVE) count++;
		if (bottomRight.getLifeState()==LifeState.ALIVE) count++;
		
		return count;
			
	}
	public void insertCell(Cell cell, int x, int y) {
		playArea[x][y] = cell;
	}
	
	
	public void githBirth(Cell cell) {
		cell.setAlive();
	}
	
	public void killCell(Cell cell) {
		cell.kill();
		
	}
	
	public void makeAlive(Cell cell) {
		cell.setAlive();
	}
	
	public void killByUnderPop(Cell cell, int neighbours) {
		
		if (neighbours<2) {
			cell.kill();
		}
	}
	public void killByOverPop(Cell cell, int neighbours) {
		
		if (neighbours>3) {
			cell.kill();
		}
	}
	
	public void lifeFromNothing(Cell cell, int neighbours) {
		if ((neighbours==3) && (cell.getLifeState()==LifeState.DEAD)) {
			cell.setAlive();
		}
	}
}
