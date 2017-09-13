package socketProgramming;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame {
	private JTextField userText;
	private JTextArea chatWindow;
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket serverSoc;
	private Socket soc;
	
	public Server(){
		super("Chat App");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				sendMessage(event.getActionCommand());
				userText.setText("");
			}
		});
		add(userText, BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300, 150);
		setVisible(true);
	}
	
	public void startRunning(){
		try{
			serverSoc = new ServerSocket(9999, 100);
			while(true){
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
				}catch(EOFException e){
					showMessage("\n Server ended the connection!");
				}finally{
					houseKeeping();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void waitForConnection() throws IOException{
		showMessage("Waiting for someone to connect... \n");
		//System.out.println("Server waiting for client request");
		soc = serverSoc.accept();
		showMessage("Now connected to " + soc.getInetAddress().getHostName());
	}
	
	private void setupStreams() throws IOException{
		output =  new ObjectOutputStream(soc.getOutputStream());
		output.flush();
		input = new ObjectInputStream(soc.getInputStream());
	}
	
	private void whileChatting() throws IOException{
		String message = "You are now connected!";
		sendMessage(message);
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException e){
				showMessage("\n idk wat user sent");
			}
			
		}while(!message.equals("CLIENT - END"));
	}
	
	private void houseKeeping(){
		showMessage("\n Closing connections... \n");
		ableToType(false);
		try{
			output.close();
			input.close();
			soc.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void sendMessage(String message){
		try{
			output.writeObject("SERVER - " + message);
			output.flush();
			showMessage("\nSERVER - " + message);
		}catch(IOException e){
			chatWindow.append("\n ERROR!");
			e.printStackTrace();
		}
	}
	
	//updates chatWindow
	private void showMessage(final String text){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						chatWindow.append(text);
					}
				});
	}
	
	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable(tof);
					}
				});
	}
	
//	public static void main(String[] args) throws Exception {
//		System.out.println("Server Started");
//		ServerSocket ss = new ServerSocket(9999);
//		
//		
//		Socket s = ss.accept();
//		
//		System.out.println("Client connected");
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//		//while(true){
//		String str = br.readLine();
//		
//		System.out.println("Client Data: " + str);
//		
//		ss.close();
//
//	//}
//	}

}
