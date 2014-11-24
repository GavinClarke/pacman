package pacman.entries.ghosts;

import java.lang.reflect.InvocationTargetException;

import pacman.actions.Actions;
import pacman.actions.Events;
import pacman.actions.States;




public class FSM {
	//Method a;
	String Event;
	String Action;
	States state;
	
	public FSM()
	{
		try {
			state = new States();
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void CheckEvent()
	{
		
	}
	
	
	
	
}
