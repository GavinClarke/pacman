package pacman.entries.ghosts;

import java.lang.reflect.Method;
import java.util.EnumMap;
import pacman.controllers.Controller;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getActions() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.ghosts.mypackage).
 */
public class MyGhosts extends Controller<EnumMap<GHOST,MOVE>>
{
	FSM states;
	boolean once = false;
	
	private EnumMap<GHOST, MOVE> myMoves=new EnumMap<GHOST, MOVE>(GHOST.class);
	
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue)
	{
		if(once == false)
		{
			states = new FSM();
			once = true;
		}
		myMoves.clear();
		
		//Place your game logic here to play the game as the ghosts
		for(GHOST ghost : GHOST.values())
		{
			game.isPowerPillStillAvailable(0);
			myMoves.put(ghost,states.CheckEvent(game,ghost));
			//myMoves.put(ghost,game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), game.getPowerPillIndex(0), DM.PATH));
			//myMoves.put(ghost,game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), game.getPacmanCurrentNodeIndex(), DM.PATH));
		}
		//myMoves.put(ghost,game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(ghost), game.getNeighbouringNodes(game.getPacmanCurrentNodeIndex())[0], DM.PATH));
		/*myMoves.put(GHOST.BLINKY, game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(GHOST.BLINKY)
				, game.getPacmanCurrentNodeIndex(), DM.PATH));
		myMoves.put(GHOST.INKY, game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(GHOST.INKY)
				, game.getPacmanCurrentNodeIndex(), DM.PATH));
		myMoves.put(GHOST.PINKY, game.getNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(GHOST.PINKY)
				, game.getPacmanCurrentNodeIndex(), DM.PATH));*/
		return myMoves;
	}
}