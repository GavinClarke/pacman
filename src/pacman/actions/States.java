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
	
	public States(/*String [] act, String [] eve*/) 
	{
		actions = new String [1/*act.length*/];
		/*for(int i =0; i < act.length;i++)
		{
			actions[i] = act[i];
		}*/
		
		events = new String[1/*eve.length*/];
		/*for(int i =0; i < eve.length;i++)
		{
			events[i] = eve[i];
		}*/
		
		
		actions[0] = "Hunt";
		//method.invoke (objectToInvokeOn);
	}
	
	public MOVE update(Game game,GHOST ghost) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException 
	{
		Class noparams[] = {};
		Class[] paramString = new Class[2];	
		paramString[0] = GHOST.class;
		paramString[1] = Game.class;
		Class cls;
		String st = "Actions";
		cls = Actions.class;
		Object obj = cls.newInstance();
			 
		//call the printIt method
		method = cls.getDeclaredMethod(actions[0], paramString);
		Object hello = method.invoke(obj, ghost,game);
		return (MOVE)hello;
	}
	
}
