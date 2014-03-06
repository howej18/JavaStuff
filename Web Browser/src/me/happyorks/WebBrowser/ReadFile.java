package me.happyorks.WebBrowser;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class ReadFile extends JFrame {

	private JTextField addressBar;
	private JEditorPane display;

	public ReadFile() {
		super("Jacob Browser");

		addressBar = new JTextField("enter a URL");
		addressBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadCrap(e.getActionCommand());
			}
		});
		add(addressBar, BorderLayout.NORTH);

		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent event) {
				if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					loadCrap(event.getURL().toString());
				}
			}
		});
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(1280, 720);
		setVisible(true);
	}

	private void loadCrap(String userText) {
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}catch (Exception e) {
			System.out.println("crap!");
		}
	}

}
