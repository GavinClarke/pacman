package pacman.entries.ghosts;

import java.lang.reflect.Method;
import java.util.EnumMap;
import pacman.controllers.Controller;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class MethodCalls {
	Game game;
	
	public MethodCalls(Game game)
	{
		this.game = game;
	}
	
	public MOVE Chase(GHOST ghost)
	{
		return game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), game.getPacmanCurrentNodeIndex(), DM.PATH);	
	}
	
	public MOVE Run (GHOST ghost)
	{
		return game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), game.getPowerPillIndex(2), DM.PATH);	
	}
	
}
