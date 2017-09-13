package socketProgramming;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame{
	private JTextField userName;
	private JTextField IP;
	private JTextField port;
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = ""; 
	private String serverIP;
	private Socket soc;
	
	public Client(String host){
		super("Client");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						sendMessage(event.getActionCommand());
						userText.setText("");
					}
				});
		add(userText, BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(300, 150);
		setVisible(true);
	}
	
	public void startRunning(){
		try{
			connectToServer();
			setupStreams();
			whileChatting();
		}catch(EOFException e){
			showMessage("\n Client terminated connection");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			houseKeeping();
		}
	}
	
	private void connectToServer() throws IOException{
		showMessage("Attempting connection...\n");
		soc = new Socket(InetAddress.getByName(serverIP), 9999);
		showMessage("Connected to: " + soc.getInetAddress().getHostName());
	}
	
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(soc.getOutputStream());
		output.flush();
		input = new ObjectInputStream(soc.getInputStream());
		showMessage("\n You are good to go");
	}
	
	private void whileChatting() throws IOException{
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException e){
				showMessage("\n Donno wtf is wrong");
			}
		}while(!message.equals("SERVER - END"));
	}
	
	private void houseKeeping(){
		showMessage("\n Closing connections...");
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
			output.writeObject("CLIENT - " + message);
			output.flush();
			showMessage("\n CLIENT - " + message);
		}catch(IOException e){
			chatWindow.append("\n Something went wrong!");
			e.printStackTrace();
		}
	}
	
	private void showMessage(final String mes){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						chatWindow.append(mes);
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
	
//	public static void main(String[] args) throws Exception{
//		//System.setProperty(key, value);
//		
//		String IP = "localhost";
//		int port  = 9999;
//		Socket s = new Socket(IP, port);
//		
//		String str = "Syd Moh";
//		
//		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
//		PrintWriter out = new PrintWriter(os);
//		out.println(str);
//		os.flush();
//		s.close();
//	}

}
