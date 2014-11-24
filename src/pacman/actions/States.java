package pacman.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Map.Entry;

import pacman.game.Constants.MOVE;
import static pacman.game.Constants.*;
import pacman.game.Game;

public class States {

	java.lang.reflect.Method method;
	
	String state;
	
	Actions action;
	String [] actions;
	
	Events event;
	String [] events;
	
	Object obj;
	
	Class[] paramString = new Class[2];	
	Class noparams[] = {};
	Class cls;
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
		actions[0] = "TOTHEPILLS";
		actions[1] = "Hunt";
		paramString[0] = GHOST.class;
		paramString[1] = Game.class;
		//method.invoke (objectToInvokeOn);
	}
	
	public MOVE update(Game game,GHOST ghost) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException 
	{
		Object hello;
		
		cls = Events.class;
		obj = cls.newInstance();
		method = cls.getDeclaredMethod(events[0], paramString);
		 
		if((boolean)(method.invoke(obj, ghost,game)))
		{
			cls = Actions.class;
			obj = cls.newInstance();
			method = cls.getDeclaredMethod(actions[0], paramString);
			hello = method.invoke(obj, ghost,game);
		}
		else
		{
			cls = Actions.class;
			obj = cls.newInstance();
			method = cls.getDeclaredMethod(actions[1], paramString);
			hello = method.invoke(obj, ghost,game);
		}
		return (MOVE)hello;
	}
	
	
}
