package pacman.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import pacman.game.Constants.MOVE;
import static pacman.game.Constants.*;
import pacman.game.Game;

public class States {

	java.lang.reflect.Method method;
	java.lang.reflect.Method actionTest;
	int state;
    String stat;
	public Map<String, Integer> stateNum;
	public String [] states;
	Actions action;
	public String [] actions;
	
	Events event;
	public String [] events;
	
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
		
		events = new String[2/*eve.length*/];
		/*for(int i =0; i < eve.length;i++)
		{
			events[i] = eve[i];
		}*/
		state = 1;
		stateNum = new HashMap<String, Integer>();
		stateNum.put("hunt", 1);
		stateNum.put("run", 0);
		stat = "hunt";
		states = new String[2];
		states[0] = "run";
		states[1] = "hunt";
		//events[0] = "ISGHOSTEDIBLE";
		//events[1] = "ISGHOSTNOTEDIBLE";
		//actions[0] = "TOTHEPILLS";
		//actions[1] = "HUNT";
		paramString[0] = GHOST.class;
		paramString[1] = Game.class;
		//method.invoke (objectToInvokeOn);
	}
	
	public MOVE update(Game game,GHOST ghost) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException 
	{
		Object hello = MOVE.UP;
		
		
		
			cls = Events.class;
			obj = cls.newInstance();
			method = cls.getDeclaredMethod(events[state], paramString);
			method.setAccessible(true);
		if((boolean)(method.invoke(obj, ghost,game)))
		{
			cls = Actions.class;
			obj = cls.newInstance();
			method = cls.getDeclaredMethod(actions[state], paramString);
			//method.setAccessible(true);
			hello = method.invoke(obj, ghost,game);
			System.out.println("state is " + states[state]);
		}
		else
		{
			state = stateNum.get(states[state]);
			stat =states[state];
		}
		return (MOVE)hello;
	}
	
	public void SetCurrentState(int statee)
	{
		state = stateNum.get(states[statee]);
		stat =states[state];
	}
	
}
