package uk.co.nime.life.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uk.co.nime.life.Cell;
import uk.co.nime.life.LifeState;
import uk.co.nime.life.SimArea;


/**
 * Tests the expected behaviour of the  simulator
 * 
 * @author tamer
 *
 */
public class BehaviourTest {
		

	SimArea simArea;
	
	
	@Before
	public void init() {
		
		simArea = new SimArea();
		simArea.initPlayArea();
		
	}
	
	
	
	@Test
	public void killCellTest() {
		
		Cell cell = new Cell();
		simArea.killCell(cell);	
		assertEquals(LifeState.DEAD, cell.getLifeState());		
	}
	
	@Test
	public void makeAliveTest() {
		
		Cell cell = new Cell();
		simArea.makeAlive(cell);
		
		assertEquals(LifeState.ALIVE, cell.getLifeState());		
	}
	
	@Test
	public void underPopulationUnderTest() {
		Cell cell = new Cell();
		simArea.githBirth(cell);
		simArea.killByUnderPop(cell,1);
		
		// Expect the cell to have died
		assertEquals(LifeState.DEAD, cell.getLifeState());	
		
	}
	@Test
	public void underPopulationNotUnderTest() {
		Cell cell = new Cell();
		
		simArea.githBirth(cell);
		simArea.killByUnderPop(cell,2);
		
		// Expect the cell to remain alive
		assertEquals(LifeState.ALIVE, cell.getLifeState());	
		
	}
	@Test
	public void deathByOvercrowdingTest() {
		Cell cell = new Cell();
		
		simArea.githBirth(cell);
		simArea.killByOverPop(cell, 4);
		
		// Expect the cell to die due to over....
		assertEquals(LifeState.DEAD, cell.getLifeState());	
		
	}
	
	@Test
	public void lifeFromNothingTest() {
		Cell cell = new Cell();
		
		simArea.lifeFromNothing(cell, 3);
		
		// Expect the cell to come alive
		assertEquals(LifeState.ALIVE, cell.getLifeState());	
		
	}
	
	@Test
	public void testOneNeighbour() {
		
		Cell cell = new Cell();
		cell.setAlive();
		simArea.insertCell(cell, 0, 0);
		
		assertEquals(1,simArea.countLivingNeighbours(1, 1));
		
	}
	@Test
	public void testTwoNeighbour() {
		
		Cell cell = new Cell();
		cell.setAlive();
		simArea.insertCell(cell, 0, 0);
		simArea.insertCell(cell, 2, 1);
		
		assertEquals(2,simArea.countLivingNeighbours(1, 1));
		
	}
	
	
	

	
	

}
