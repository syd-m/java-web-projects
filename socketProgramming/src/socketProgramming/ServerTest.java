package socketProgramming;

import javax.swing.JFrame;

public class ServerTest {

	public static void main(String[] args) {
		Server syd = new Server();
		syd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		syd.startRunning();
	}

}
