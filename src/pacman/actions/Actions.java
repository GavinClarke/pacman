package pacman.actions;

import java.util.EnumMap;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;


public class Actions {

	private final EnumMap<GHOST,Integer> cornerAllocation=new EnumMap<GHOST,Integer>(GHOST.class);
	public Actions()
	{
		cornerAllocation.put(GHOST.BLINKY,0);
    	cornerAllocation.put(GHOST.INKY,1);
    	cornerAllocation.put(GHOST.PINKY,2);
    	cornerAllocation.put(GHOST.SUE,3);
	}
	
	public MOVE HUNT(GHOST ghost,Game game)
	{
		return game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), game.getPacmanCurrentNodeIndex(), DM.PATH);
	}
	
	public MOVE TOTHEPILLS(GHOST ghost,Game game)
	{
		//getActivePowerPillsIndices()
		int i[] = game.getPowerPillIndices();
		return game.getMoveToMakeToReachDirectNeighbour(game.getGhostCurrentNodeIndex(ghost),i[0]);
	}
	
	public MOVE RUN(GHOST ghost, Game game)
	{
		return game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost),game.getPowerPillIndices()[cornerAllocation.get(ghost)],game.getGhostLastMoveMade(ghost),DM.PATH);
	}
}
