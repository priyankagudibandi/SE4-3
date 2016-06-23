
import javax.swing.JFrame;


public class AppClient {

	public static void main(String[] args) {
		//GUI mainWindow = new GUI();
		
		GUI1 mainWindow = new GUI1();
		mainWindow.setSize(800, 600);
		mainWindow.setVisible(true);
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
