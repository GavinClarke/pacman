package pacman.actions;

import java.lang.reflect.InvocationTargetException;

public class States {

	java.lang.reflect.Method method;
	
	String state;
	
	Actions action;
	String [] actions;
	
	Events event;
	String [] events;
	
	Object obj;
	Class noparams[] = {};
	public States(/*String [] act, String [] eve*/) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException 
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
		actions[0] = "first";
		Class cls;
		String st = "Actions";
		cls = Actions.class;
		Object obj = cls.newInstance();
			 
		//call the printIt method
		method = cls.getDeclaredMethod("first", noparams);
		method.invoke(obj, null);
		
		
		//method.invoke (objectToInvokeOn);
	}
	
}
