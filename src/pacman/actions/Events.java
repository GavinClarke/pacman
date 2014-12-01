package pacman.actions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class Events {

	String NewState;
	String state;
	public Events()
	{
		//state = stat;
	}
	
	public boolean ISGHOSTEDIBLE(GHOST ghost,Game game)
	{
		if(game.isGhostEdible(ghost))
		{
			//NewState = state;
			return true;
		}
		//NewState = "";
		
		return false;
	}
	
	public String GetNewState()
	{
		return NewState;
	}
}
