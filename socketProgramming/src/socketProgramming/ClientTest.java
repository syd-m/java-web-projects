package socketProgramming;

import javax.swing.JFrame;

public class ClientTest {

	public static void main(String[] args){
		Client zee = new Client("192.168.0.8");
		zee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		zee.startRunning();
	}

}
