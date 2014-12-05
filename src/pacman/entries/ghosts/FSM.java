package pacman.entries.ghosts;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import pacman.actions.States;
import static pacman.game.Constants.*;
import pacman.game.Game;
import pacman.game.Constants.GHOST;
import pacman.game.internal.Ghost;


public class FSM {
	//Method a;
	String Event;
	String Action;
	//States state;
	Map<GHOST, States> state;
	States current;
	
	public FSM()
	{
		state = new HashMap<GHOST,States>();
		
		//state.put("Run", new States());
		//hunt,ISGHOSTEDIBLE,HUNT,run	 
        try {
        	BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("data/FSM"+System.getProperty("file.separator")+"FSM.txt")));
			//String input=br.readLine();
			GHOST ghost = GHOST.BLINKY;
			//state.put(ghost, new States());
			String i;
			int count =0;
			while((i=br.readLine())!=null)
			{
				
				int num  =0;
				
				if(i.equals("BLINKY")||
				   i.equals("INKY")||
				   i.equals("PINKY")||
				   i.equals("SUE"))
				{
					ghost = GetGhost(i);
					state.put(ghost, new States());
					
					count =0;
				}
				else if(i.equals("1")||
						   i.equals("2")||
						   i.equals("3")||
						   i.equals("4")||
						   i.equals("5")||
						   i.equals("6"))
				{
					state.get(ghost).SetSize(Integer.parseInt(i));
				}
				else
				{
					String h [] =i.split(",");
					state.get(ghost).AddState(h[0], count);
					state.get(ghost).events[count] = h[1];
					state.get(ghost).actions[count] = h[2];
					state.get(ghost).states[count] = h[3];
					count ++;
				}
				//state.get(ghost).SetCurrentState(state.get(ghost).stateNum.get(h[0]));
			}
			
			state.get(GHOST.BLINKY).SetCurrentState(state.get(GHOST.BLINKY).stateNum.firstEntry().getValue());
			state.get(GHOST.INKY).SetCurrentState(state.get(GHOST.INKY).stateNum.firstEntry().getValue());
			state.get(GHOST.PINKY).SetCurrentState(state.get(GHOST.PINKY).stateNum.firstEntry().getValue());
			state.get(GHOST.SUE).SetCurrentState(state.get(GHOST.SUE).stateNum.firstEntry().getValue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//current = new States();
	}
	
	public GHOST GetGhost(String name)
	{
		if(name.equals( "BLINKY"))
		{
			return GHOST.BLINKY;
		}
		else if(name.equals( "INKY"))
		{
			return GHOST.INKY;
		}
		else if(name.equals( "PINKY"))
		{
			return GHOST.PINKY;
		}
		return GHOST.SUE;
	}
	
	public MOVE CheckEvent(Game game,GHOST ghost)
	{
		MOVE i = null;
		try {
			i = state.get(ghost).update(game,ghost);
			
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
