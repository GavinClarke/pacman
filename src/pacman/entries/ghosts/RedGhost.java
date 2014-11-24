package pacman.entries.ghosts;

import java.lang.reflect.Method;
import java.util.EnumMap;

import pacman.controllers.Controller;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class RedGhost extends Controller<EnumMap<GHOST,MOVE>> {

	private EnumMap<GHOST, MOVE> myMoves=new EnumMap<GHOST, MOVE>(GHOST.class);
	
	@Override
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue) {
		// TODO Auto-generated method stub
		Method method;
		try {
			method = game.getClass().getMethod("getNextMoveTowardsTarget", int.class ,int.class , DM.class );
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myMoves;
	}

}
