package pacman.entries.ghosts;

import java.lang.reflect.InvocationTargetException;

import pacman.actions.Actions;
import pacman.actions.Events;
import pacman.actions.States;
import static pacman.game.Constants.*;
import pacman.game.Game;


public class FSM {
	//Method a;
	String Event;
	String Action;
	States state;
	
	public FSM()
	{
		state = new States();	
	}
	
	
	
	public MOVE CheckEvent(Game game,GHOST ghost)
	{
		MOVE i = null;
		try {
			i = state.update(game,ghost);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
	
	
}
