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
	
}
