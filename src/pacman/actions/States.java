package pacman.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.TreeMap;

import pacman.game.Constants.MOVE;
import static pacman.game.Constants.*;
import pacman.game.Game;

public class States {

	java.lang.reflect.Method method;
	java.lang.reflect.Method actionTest;
	int state;
    //String stat;
	public TreeMap<String, Integer> stateNum;
	public String [] states;
	Actions action;
	public String [] actions;
	
	Events event;
	public String [] events;
	
	Object obj;
	
	Class[] paramString = new Class[2];	
	Class noparams[] = {};
	Class<?> cls;
	public States() 
	{
		stateNum = new TreeMap<String, Integer>();
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
			if(ghost == GHOST.BLINKY)
			{
				//System.out.println("state is " + states[state]);
			}
		}
		else
		{
			state = stateNum.get(states[state]);
		}
		return (MOVE)hello;
	}
	
	public void SetCurrentState(int statee)
	{
		state = stateNum.get(states[statee]);
	}
	
	public void SetSize(int size)
	{
		states = new String[size];
		actions = new String [size];
		events = new String[size];
	}
	
	public void AddState(String state, int num)
	{
		stateNum.put(state, num);
		states[num] = state;
	}

	
}
