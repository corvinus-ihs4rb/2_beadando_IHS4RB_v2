package ht;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TarolasKliens1 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader("Szöveg.txt"));
		String be = bf.readLine();	
		
		Socket s = new Socket("localhost",1234);
		
		
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.println(be);
		
		pw.flush();
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date(System.currentTimeMillis());
		System.out.println(be+", "+df.format(dateobj));		
		
		PrintWriter pw2 = new PrintWriter( new FileOutputStream( "Tárolva.txt", true));
		pw2.println(be+", Idõbélyeg: "+df.format(dateobj));
		
		
		pw2.flush();
		pw2.close();
		pw.close();
		bf.close();
		
		s.close();
	}

}
