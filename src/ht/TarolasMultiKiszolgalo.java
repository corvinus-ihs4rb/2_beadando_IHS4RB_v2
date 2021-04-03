package ht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TarolasMultiKiszolgalo implements Runnable {
	private Socket s;
	
	public TarolasMultiKiszolgalo(Socket s) {
		this.s = s;
	}
	
	public void run() {
		
		BufferedReader bf ;
		try {
			bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			String be = bf.readLine();
			System.out.println("Tárolva: "+be);
			
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.println(be);
			
			pw.flush();
			
			bf.close();
			pw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
