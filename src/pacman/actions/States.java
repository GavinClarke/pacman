package pacman.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Map.Entry;

import pacman.game.Constants.MOVE;
import static pacman.game.Constants.*;
import pacman.game.Game;
import pacman.Executor;

public class States {

	java.lang.reflect.Method method;
	java.lang.reflect.Method actionTest;
	String state;
	
	Actions action;
	String [] actions;
	
	Events event;
	String [] events;
	String [] states;
	Object obj;
	
	Class[] paramString = new Class[2];	
	Class noparams[] = {};
	Class<?> cls;
	public States(/*String [] act, String [] eve*/) 
	{
		actions = new String [2/*act.length*/];
		/*for(int i =0; i < act.length;i++)
		{
			actions[i] = act[i];
		}*/
		
		events = new String[1/*eve.length*/];
		/*for(int i =0; i < eve.length;i++)
		{
			events[i] = eve[i];
		}*/
		
		events[0] = "ISGHOSTEDIBLE";
		actions[0] = "HUNT";
		actions[1] = "TOTHEPILLS";
		paramString[0] = GHOST.class;
		paramString[1] = Game.class;
		//method.invoke (objectToInvokeOn);
	}
	
	public MOVE update(Game game,GHOST ghost) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException 
	{
		Object hello = MOVE.UP;
		
		
		for(int i =0; i <1; i++)
		{
			cls = Events.class;
			obj = cls.newInstance();
			method = cls.getDeclaredMethod(events[i], paramString);
			method.setAccessible(true);
			if((boolean)(method.invoke(obj, ghost,game)))
			{
				cls = Actions.class;
				obj = cls.newInstance();
				method = cls.getDeclaredMethod(actions[i], paramString);
				//method.setAccessible(true);
				hello = method.invoke(obj, ghost,game);
				if(GHOST.BLINKY == ghost)
				{
					//System.out.println(ghost.toString()+ " is Checking "+ actions[0] /*+ " this is its move " + hello.toString()*/);
				}
			}
		}
		/*else
		{
			cls = Actions.class;
			obj = cls.newInstance();
			method = cls.getDeclaredMethod(actions[1], paramString);
			hello = method.invoke(obj, ghost,game);
			System.out.println("Checking "+ actions[1]);
		}*/
		return (MOVE)hello;
	}
	
	
}
