package yxt.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class KeyBusy extends Thread{
	
	public void run() {
		try {
			while(true) {
				Thread.sleep(500);
				pressKey(readConfig());
			}
		}catch(Exception e) {
			
		}
	}
	public String[] readConfig() throws Exception {
		String path = "config.txt";
		BufferedReader in = new BufferedReader(new FileReader(path));
	    String configStr = null;
	    configStr = in.readLine();
	    in.close();
		return configStr.split(",");
	}
	public void pressKey(String[] config) throws AWTException {
		Robot robot = new Robot();
		for(String keyCode:config) {
			int keyInt = Integer.parseInt(keyCode);
			robot.keyPress(keyInt);
			robot.keyRelease(keyInt);
		}
	}
}
