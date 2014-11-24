package pacman.actions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class Events {

	
	public Events()
	{
		
	}
	
	public boolean ISGHOSTEDIBLE(GHOST ghost,Game game)
	{
		if(game.isGhostEdible(ghost))
		{
			return true;
		}
		return false;
	}
	
}
