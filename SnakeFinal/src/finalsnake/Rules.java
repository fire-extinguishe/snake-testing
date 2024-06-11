package finalsnake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Rules extends JFrame implements ActionListener {
	
	JLabel zasady = new JLabel();
	JButton back_to_menu;
	String rules_from_file = "<html>";
	String[] filepath = {"src/snake_files/rules.txt", "src/snake_files/zasady.txt"};
	int i =0;
	
	public Rules(String title) throws HeadlessException {
		super(title);
		this.setSize(710,500);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(27,55,35));
		this.setLocationRelativeTo(null);
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	back_to_menu = new JButton();
    	if(MainMenu.i==1) {
    		i = 1;
    		back_to_menu.setText("Menu główne");
    	}
    	else {
    		i = 0;
    		back_to_menu.setText("Main menu");
    	}
    	try {
	     	File rules = new File(filepath[i]);
	    	Scanner read = new Scanner(rules);
	    	while(read.hasNextLine()) {
	    		String text_from_file = read.nextLine();
	    		rules_from_file += text_from_file + "<br>";
	    	}
	    	read.close();
    	}catch(FileNotFoundException e) {
    		System.out.println("Error");
    		e.printStackTrace();
    	}
    	rules_from_file += "</html>";
    	zasady.setText(rules_from_file);
    	zasady.setForeground(Color.white);
    	zasady.setFont(new Font("Georgia",Font.PLAIN, 21));
    	back_to_menu.addActionListener(this);
    	zasady.setBounds(0, 0, 700, 400);
    	back_to_menu.setBounds(255, 410, 160, 50); 
    	back_to_menu.setOpaque(false);
    	back_to_menu.setContentAreaFilled(false); 
    	back_to_menu.setBorderPainted(false);
    	back_to_menu.setFont(new Font("Garamond",Font.BOLD,20)); 
    	back_to_menu.setForeground(Color.white);
    	this.add(back_to_menu); 
    	this.add(zasady);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();		
	}
}

