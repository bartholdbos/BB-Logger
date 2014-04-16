package tk.bartbart333.logger;

public class ConsoleHandler extends Handler{
	
	public ConsoleHandler(){
		addLevel(Level.INFO);
		addLevel(Level.SEVERE);
		addLevel(Level.STDERR);
		addLevel(Level.STDOUT);
		addLevel(Level.WARNING);
	}
	
	@Override
	public void write(Level level, Object msg){
		getOut().println("[" + level + "] " + msg);
	}
}