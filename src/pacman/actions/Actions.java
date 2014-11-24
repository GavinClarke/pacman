package pacman.actions;

import pacman.game.Constants.MOVE;
import static pacman.game.Constants.*;
import pacman.game.Game;


public class Actions {

	public Actions()
	{
		
	}
	
	public MOVE Hunt(GHOST ghost,Game game)
	{
		return game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), game.getPacmanCurrentNodeIndex(), DM.PATH);
	}
	
	public MOVE TOTHEPILLS(GHOST ghost,Game game)
	{
		//getActivePowerPillsIndices()
		int i[] = game.getPowerPillIndices();
		return game.getMoveToMakeToReachDirectNeighbour(game.getGhostCurrentNodeIndex(ghost),i[0]);
	}
}
