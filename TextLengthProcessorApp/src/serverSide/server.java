package serverSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import text.Text;



public class server {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		int portNo = 3450;
		
			ServerSocket serversocket = new ServerSocket(portNo);
			System.out.print("Ready for request.");
			
			// Server needs to be alive forever
			while (true) {
							
			Socket socket = serversocket.accept();

			try {
				
			ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());

				Text text = (Text) objectIS.readObject();
					
				text.setTextLength(text.countwords(text.getText()));			
				
				
				System.out.print("text is:" + text.getText());	
				System.out.print("text length is "+ text.getTextLength());				 
				objectOS.writeObject(text);

				System.out.print("Ready for next request.");

				objectIS.close();
				objectOS.close();
		       	socket.close();

				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		} 
		
////C:\Users\dawiy\Documents\sem 2 tahun 2 2021\dad\lab\bitp3123-ws\TextLengthProcessorApp\bin> java serverSide.server
	}

}
