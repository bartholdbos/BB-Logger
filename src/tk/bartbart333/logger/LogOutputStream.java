package tk.bartbart333.logger;

import java.io.IOException;
import java.io.OutputStream;

public class LogOutputStream extends OutputStream{
	
	private StringBuilder line = new StringBuilder();
	private Level level;
	
	public LogOutputStream(Level level){
		this.level = level;
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException{
		if(b[0] == 13 && b[1] == 10){
			Logger.log(level, line.toString());
			line.delete(0, line.length());
		}else{
			for(int i = off; i < len; i++){						
				line.append((char) b[i]);
			}
		}
	}
	
	@Override
	public void write(int b) throws IOException{
		
	}
}