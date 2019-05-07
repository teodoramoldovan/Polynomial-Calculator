package Main;



import javax.swing.JFrame;

import PT2018.assigment1.Assigment1ViewAndController.ApplicationView;

public class Main {
	public static void main(String args[]) {
		JFrame frame = new ApplicationView("Calculator Polinoame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

