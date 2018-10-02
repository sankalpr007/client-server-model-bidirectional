import java.io.*;
import java.net.*;

public class Myclient
{
	public static void main(String args[]) throws Exception
	{
		int PORT=9876;
		DataInputStream in;
		DataOutputStream out;
		String message="";
		
		Socket conn=new Socket("localhost",PORT);
		System.out.println("Client started");
		do
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your message to send: ");
			message=br.readLine();
			{
				out=new DataOutputStream(conn.getOutputStream());
				out.writeUTF(message);
				in=new DataInputStream(conn.getInputStream());
				message=in.readUTF();
				System.out.println("Sever: "+message);
			}
		}while(!message.equals("bye"));
		conn.close();
	}
}