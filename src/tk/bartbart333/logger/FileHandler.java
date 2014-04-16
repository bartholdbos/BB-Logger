package tk.bartbart333.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler extends Handler {
	
	private File file;
	private FileWriter out;
	private SimpleDateFormat dateformat = new SimpleDateFormat("y-M-d H:m:s");
	private Date date = new Date();
	
	public FileHandler(String log){
		addLevel(Level.INFO);
		addLevel(Level.SEVERE);
		addLevel(Level.STDERR);
		addLevel(Level.STDOUT);
		addLevel(Level.WARNING);
		addLevel(Level.DEBUG);
		
		file = new File(log + ".log");
		
		try{
			out = new FileWriter(file, true);
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	@Override
	public void write(Level level, Object msg){
		try{
			out.write(dateformat.format(date) + " [" + level + "] " + msg + "\n");
			out.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}