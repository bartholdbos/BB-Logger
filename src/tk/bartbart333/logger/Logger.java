package tk.bartbart333.logger;

import java.io.PrintStream;
import java.util.ArrayList;

public class Logger{
	
	private static ArrayList<Handler> handlers = new ArrayList<Handler>();
	protected static PrintStream oldstream;
	
	public static void init(){
		oldstream = System.out;
		System.setOut(new PrintStream(new LogOutputStream(Level.STDOUT)));
		System.setErr(new PrintStream(new LogOutputStream(Level.STDERR)));
	}
	
	public static void log(Level level, Object msg){
		for(Handler handler : handlers){
			handler.log(level, msg);
		}
	}
	
	public static void addHandler(Handler handler){
		if(!handlers.contains(handler)){
			handlers.add(handler);
		}
	}
	
	public static void removeHandler(Handler handler){
		handlers.remove(handler);
	}
}