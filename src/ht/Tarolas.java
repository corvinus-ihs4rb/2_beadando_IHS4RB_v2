package ht;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;



public class Tarolas {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1234);
		
		while (true) {
			Socket s =  ss.accept();
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String be = bf.readLine();
			
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			pw.println(be);
			pw.flush();
			
			bf.close();
			
			pw.close();
			s.close();
		}

	}

}
