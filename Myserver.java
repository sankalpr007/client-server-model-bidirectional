import java.io.*;
import java.net.*;

public class Myserver
{
	public static void main(String args[]) throws Exception
	{
		int PORT=9876;
		DataInputStream in;
		DataOutputStream out;
		String message="";
		
		System.out.println("Sever started");
		
		ServerSocket serv=new ServerSocket(PORT);
		Socket conn=serv.accept();
		
		do
		{
			in=new DataInputStream(conn.getInputStream());
			message=in.readUTF();
			System.out.println("Client: "+message);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your message to send: ");
			message=br.readLine();
			out=new DataOutputStream(conn.getOutputStream());
			out.writeUTF(message);
		}while(!message.equals("bye"));
		conn.close();
		serv.close();
	}
}