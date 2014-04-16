package tk.bartbart333.logger;

import java.io.PrintStream;
import java.util.ArrayList;

public abstract class Handler {
	
	public abstract void write(Level level, Object msg);
	private ArrayList<Level> levels = new ArrayList<Level>();
	
	void log(Level level, Object msg){
		if(hasLevel(level)){
			write(level, msg);
		}
	}
	
	public void addLevel(Level level){
		if(!levels.contains(level)){
			levels.add(level);
		}
	}
	
	public void removeLevel(Level level){
		if(levels.contains(level)){
			levels.remove(level);
		}
	}
	
	private boolean hasLevel(Level level){
		if(levels.contains(level)){
			return true;
		}else{
			return false;
		}
	}
	
	protected static PrintStream getOut(){
		return Logger.oldstream;
	}
}