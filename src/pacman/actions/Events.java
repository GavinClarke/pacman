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
		
		return false;
	}
	
	public boolean ISGHOSTNOTEDIBLE(GHOST ghost,Game game)
	{
		if(game.isGhostEdible(ghost) )
		{
			//NewState = state;
			return false;
		}
		
		return true;
	}
	
	public boolean ISONEPOWERPILLlEFT(GHOST ghost,Game game)
	{
		if(game.getActivePowerPillsIndices().length ==1 )
		{
			//NewState = state;
			return false;
		}
		
		return true;
	}
	
	public boolean ONEPOWERPILLlEFT(GHOST ghost,Game game)
	{
		if(game.getActivePowerPillsIndices().length ==1 )
		{
			//NewState = state;
			return true;
		}
		
		return false;
	}
	
	public String GetNewState()
	{
		return NewState;
	}
}
