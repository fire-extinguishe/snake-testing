package finalsnake;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Snake extends JFrame {

	static int Delay = 140;
	static String Title = "Title";
    public Snake(String title, int delay) {
    	Delay = delay;
    	Title = title;
    	setTitle(Title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new SnakePanel(Delay));        
        setResizable(false);
        pack();   
        setLocationRelativeTo(null);
    }
      
    public static void main(String[] args) {     
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new Snake(Title, Delay);
	            frame.setVisible(true);
			}    		
    	});
    }
}
