package pacman.entries.ghosts;

import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.Map;

import pacman.actions.Actions;
import pacman.actions.Events;
import pacman.actions.States;
import static pacman.game.Constants.*;
import pacman.game.Game;
import pacman.game.Constants.GHOST;


public class FSM {
	//Method a;
	String Event;
	String Action;
	//States state;
	Map<String, States> state;
	States current;
	public FSM()
	{
		//state.put("Hunt", new States());
		//state.put("Run", new States()); 
		current = new States();
	}
	
	
	
	public MOVE CheckEvent(Game game,GHOST ghost)
	{
		MOVE i = null;
		try {
			i = current.update(game,ghost);
			
			/*if(current.GetNewState() != "")
			{
				current = state.get(current.GetNewState());
			}*/
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
