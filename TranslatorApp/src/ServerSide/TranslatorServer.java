package ServerSide;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class TranslatorServer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String korean = null;
	static String eng = null;
	static String arabic = null;

	public static void main(String[] args) {
	

		// Binding to a client port
		int portNo = 1234;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(portNo);

		// Server needs to be alive forever
		while (true) {		
			System.out.print("Server is Running.");

			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Create stream to Read data from network
			 DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
			// Create stream to write data on the network
			 DataOutputStream outputStream = 
						new DataOutputStream(clientSocket.getOutputStream());		
			 
			 
			String oriText = dataIn.readUTF();
			System.out.print(oriText);

if (oriText != null) {
			// Send translated Text back to the client
			if (oriText.contains("Selamat pagi") ) {
				eng = "Good morning ";
				arabic = "صباحالخير "; 
				korean = "좋은 아침 ";
			}
			else if(oriText.contains("Selamat malam")) {
				eng = "Good night ";
				arabic = "طاب مساؤك " ; 
				korean = "안녕히 주무세요 ";
			}
			else if(oriText.contains( "Apa khabar?") ){
				eng = "How are you? ";
				arabic = "كيف حالك؟ "; 
				korean = "어떻게 지내세요? ";
				
			}
			else if(oriText.contains("Terima kasih") ){
				eng = "Thank you ";
				arabic = "شكرا لك "; 
				korean = "감사합니다 ";
				
			}
			else if(oriText.contains("Selamat tinggal") ){
				eng = "Goodbye ";
				arabic = "مع السلامة " ; 
				korean = "안녕 ";	
			}
			else if(oriText.contains( "Ada apa?")) {
				eng = "What’s up? ";
				arabic = "ما أخبارك؟ "; 
				korean = "뭐야? ";
			}
			
			outputStream.writeUTF(eng);
			outputStream.writeUTF(arabic);
			//outputStream.writeUTF(korean);
			outputStream.flush();


			//System.out.print(korean+eng+arabic);
			
			dataIn.close();
			outputStream.close();
			outputStream.close();			
			//outputStream.close();

		clientSocket.close();
			
}
		}						
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
	
}


