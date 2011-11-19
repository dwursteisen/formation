package com.github.dwursteisen.threads.verificators;

import java.util.Scanner;

public class KillProgramByUser extends Thread {
	
	private volatile boolean running = true;
	
	private Scanner userInput = new Scanner(System.in);
	
	public KillProgramByUser() {
		super("KillProgramByUser");
	}
	
	@Override
	public void run() {
		
		while(running) {
			String nextInput = userInput.next();
			if(nextInput != null && !"".equals(nextInput)) {
				stopThread();
				System.exit(0); // envoi un signal ?
			}
			
		}
	}
	
	
	public void stopThread() {
		running = false;
		userInput.close();
	}

}
