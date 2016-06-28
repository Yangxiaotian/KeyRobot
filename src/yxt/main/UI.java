package yxt.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI extends Thread implements ActionListener{
	JFrame frame = new JFrame("WOW Helper");
	JPanel panel = new JPanel();
	JButton startBtn = new JButton("Start");
	KeyBusy keyBusy;
	public void run() {
		createUI();
	}
	public void createUI() {
		frame.setLocation(500,200);
		frame.setSize(200,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.add(startBtn);
		startBtn.addActionListener(this);
		frame.getContentPane().add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if("Start".equals(startBtn.getText())) {
			startBtn.setText("Stop");
			keyBusy = new KeyBusy();
			keyBusy.start();
		}else {
			startBtn.setText("Start");
			keyBusy.interrupt();
		}
	}
}
