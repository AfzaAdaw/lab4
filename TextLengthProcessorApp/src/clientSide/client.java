package clientSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import text.Text;

public class client {
	
		int portno = 3450;
		static ClientFrame frame;
		
	public static void main(String[] args) throws UnknownHostException, IOException, Exception   {
		
		Text text = new Text();

		frame= new ClientFrame(text);
		frame.setVisible(true);

	}
	
	void sendText(Text text) throws Throwable {

		InetAddress serverAddress = InetAddress.getLocalHost();
		
		Socket socket = new Socket(serverAddress, portno);
		
		//send text to server
		System.out.print("text is:" + text.getText());	
		if (text.getText() != null) {
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
			objectOS.writeObject(text);

		//receive text length from server
		ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
		text = (Text) objectIS.readObject();
		System.out.print("text is:" + text.getText());	
		System.out.print("text length is "+ text.getTextLength());
		frame.updateWordCount(text);
		
		objectOS.close();
		objectIS.close();
		socket.close();
		}
	}

}
