package com.testjnpl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.jnlp.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestJnpl {

	static BasicService basicService = null;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Jnpl Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel();
		java.awt.Container container = frame.getContentPane();
		container.add(container, BorderLayout.CENTER);
		String message = "Hellow World";

		label.setText(message);

		try {
			basicService = (BasicService) ServiceManager
					.lookup("javax.jnlp.BasicService");

		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton button = new JButton("http://www.google.com");

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				URL url;
				try {
					url = new URL(e.getActionCommand());
					basicService.showDocument(url);
				} catch (MalformedURLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				

			}
		};
		
		
		button.addActionListener(listener);
		
		container.add(button,BorderLayout.SOUTH);
		frame.pack();
		frame.show();
	}

}
