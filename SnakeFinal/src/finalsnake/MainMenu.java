package finalsnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainMenu {
	JButton exit, polish, english;
	static JButton on;
	static JButton off;
	JButton rules;
	JButton slug;
	JButton worm;
	JButton python;
	static JButton topScore;
	JFrame mainMenu;
	String [] filepath = {"src/snake_files/start_eng.png", "src/snake_files/start_pl.png"};
	Music music = new Music();
	static int i =0;
	static int wynik = 0;
	
	public MainMenu() {
		mainMenu = new JFrame();
    	try {
    		mainMenu.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(filepath[i])))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    	mainMenu.pack();
    	mainMenu.setLayout(null);
    	mainMenu.setResizable(false);
    	mainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    	
    	mainMenu.setLocationRelativeTo(null);
    	//inicjowanie guzika-maks wynik
    	topScore = new JButton("TOP:  0");
    	topScore.setForeground(Color.white);
    	topScore.setFont(new Font("Georgia",Font.BOLD, 21));
    	//inicjowanie guzików - obrazków
    	ImageIcon polish_flag = new ImageIcon("src/snake_files/polish_flag.png");
    	ImageIcon british_flag = new ImageIcon("src/snake_files/british_flag.png");
    	//inicjowanie guzików
    	exit = new JButton(); 
    	polish = new JButton(polish_flag);
    	english = new JButton(british_flag);
    	on = new JButton();
    	off = new JButton();
    	rules = new JButton();
		slug = new JButton(); 
		worm = new JButton(); 
		python = new JButton();
		//dodawanie listenerów
		exit.addActionListener(listener1);
		polish.addActionListener(listener1);
		english.addActionListener(listener1);
		on.addActionListener(listener1);
		off.addActionListener(listener1); 
		rules.addActionListener(listener1);
		slug.addActionListener(listener1);
		worm.addActionListener(listener1); 
		python.addActionListener(listener1);
		//ustawianie guzików w odpowiednich miejscach
		exit.setBounds(870, 70, 120, 65); 
		polish.setBounds(100, 130 ,70, 40);
		english.setBounds(180, 130 ,70, 40);
		on.setBounds(100, 78 ,70, 45);
		off.setBounds(180, 78 ,70, 45);
		rules.setBounds(855, 140, 150, 70); 
		slug.setBounds(180, 470, 175, 110); 
		worm.setBounds(385, 470, 210, 110); 
		python.setBounds(630, 470, 250, 110);
		topScore.setBounds(450, 675, 200, 50);
		//ustawianie przezroczystości guzików
		exit.setOpaque(false); 
		exit.setContentAreaFilled(false); 
		exit.setBorderPainted(false);
		on.setOpaque(false); 
		on.setContentAreaFilled(false); 
		on.setBorderPainted(false);
		off.setOpaque(false); 
		off.setContentAreaFilled(false); 
		rules.setOpaque(false); 
		rules.setContentAreaFilled(false); 
		rules.setBorderPainted(false); 
		slug.setOpaque(false); 
		slug.setContentAreaFilled(false); 
		slug.setBorderPainted(false);
		worm.setOpaque(false); 
		worm.setContentAreaFilled(false); 
		worm.setBorderPainted(false);
		python.setOpaque(false); 
		python.setContentAreaFilled(false); 
		python.setBorderPainted(false);
		topScore.setOpaque(false);
		topScore.setContentAreaFilled(false); 
		topScore.setBorderPainted(false);
		//dodawanie komponentów
		mainMenu.add(exit); 
		mainMenu.add(polish);
		mainMenu.add(english);
		mainMenu.add(on);
		mainMenu.add(off);
		mainMenu.add(rules);
		mainMenu.add(slug); 
		mainMenu.add(worm); 
		mainMenu.add(python);
		mainMenu.add(topScore);
		
		mainMenu.setVisible(true);		
    }
	public void closeFrame() {
		mainMenu.dispose();
	}
	
	ActionListener listener1 = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== exit) {
				System.exit(0);	
			}
			if(e.getSource()== polish) {
				mainMenu.dispose();
				i=1;
				music.stop();
				MainMenu frame1 = new MainMenu();
			}
			if(e.getSource()== english) {
				mainMenu.dispose();
				i=0;
				music.stop();
				MainMenu frame2 = new MainMenu();
			}
			if(e.getSource()== on) {
				on.setBorderPainted(true);
				off.setBorderPainted(false);
				music.play();
			}
			if(e.getSource()== off) {
				off.setBorderPainted(true);
				on.setBorderPainted(false);
				music.stop();
			}
			if(e.getSource()== rules) {
				if(i==0) {
					Rules frame = new Rules("Rules");
					frame.setVisible(true);	
				}
				else {
					Rules frame = new Rules("Zasady");
					frame.setVisible(true);	
				}
			}
			if(e.getSource()== slug) {
				if(i==0) {
					Snake frame = new Snake("Slug",200);
					frame.setVisible(true);
				}
				else {
					Snake frame = new Snake("Ślimak",200);
					frame.setVisible(true);
				}
			}
			if(e.getSource()== worm) {
				if(i==0) {
					Snake frame = new Snake("Worm",150);
					frame.setVisible(true);	
				}
				else {
					Snake frame = new Snake("Robak",150);
					frame.setVisible(true);	
				}
			}
			if(e.getSource()== python) {
				if(i==0) {
					Snake frame = new Snake("Python",100);
					frame.setVisible(true);
				}
				else {
					Snake frame = new Snake("Pyton",100);
					frame.setVisible(true);	
				}
			}				
		}	
	};
	
	public static void main(String[] args) {
		MainMenu main = new MainMenu();
	}

}