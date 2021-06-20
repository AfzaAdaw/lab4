package ClientSide;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class client{
	/**
	 * 
	 */
	static Clientframe frame ;int portNo = 1234;
	public static void main(String[] args)   {
		
		frame = new Clientframe();
		frame.setVisible(true);
		
	}
	
	@SuppressWarnings("deprecation")
	void sendText(String text) throws Throwable {
		
		
		InetAddress serverAddress = InetAddress.getLocalHost();
		
		Socket socket = new Socket(serverAddress, portNo);
		
		// Create stream to write data on the network
		DataOutputStream outputStream = 
				new DataOutputStream(socket.getOutputStream());
		
		// Send original text to the server
		outputStream.writeUTF(text);

		// Read from network
		//BufferedReader dataIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		DataInputStream dataIn = new DataInputStream(socket.getInputStream());
		// Display the translated text
		String EngText = dataIn.readUTF();
		System.out.print(EngText+" ");

		 String ArabText = dataIn.readUTF();
		 System.out.print(ArabText);
		//String korText = dataIn.readUTF();
		// System.out.print(korText+" ");

		frame.updateTranslator(EngText,ArabText);
		
		// Close everything
		outputStream.close();
		//dataIn.close();
		dataIn.close();
		dataIn.close();
		socket.close();
		 

	}

}
