package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	JFrame f;
	JPanel p;
	JLabel word;
	JLabel alive;
	Stack<String> stak;
	String wrd;
	int lives;
	int wins;
	String num;
	
	public static void main(String[] args) {
		HangMan man = new HangMan();
		man.startGame();
	}
	
	void startGame() {
		lives = 10;
		wins = 0;
		f = new JFrame();
		p = new JPanel();
		word = new JLabel();
		alive = new JLabel("Round #:" + (wins+1) + " Lives: " + lives + "    ");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.add(alive);
		p.add(word);
		f.add(p);
		f.setSize(300,50);
		f.addKeyListener(this);
		stak = new Stack<String>();
	    num = JOptionPane.showInputDialog("pick a number between 0 and 266");
		for(int i = 0; i < Integer.parseInt(num); i++) {
			String s = Utilities.readRandomLineFromFile("dictionary.txt");
			if(!stak.contains(s))
				stak.push(s);
			else
				i--;
		}
		System.out.println(stak);
		
		showWord();
	}
	
	void showWord() {
		wrd = stak.pop();
		word.setText("");
		for(int i = 0; i < wrd.length(); i++) {
			word.setText(word.getText() + "_");
		}
	}
	
	void guessLetter(char letter) {
		char[] chars = wrd.toCharArray();
		System.out.println("Guessing: " + letter);
		boolean correct = false;
		for(int i = 0; i < chars.length; i++) {
			if(letter == chars[i]) {
				word.setText(word.getText().substring(0,i)+ letter + word.getText().substring(i+1));
				correct = true;
			}
		}
		if(!correct) {
			System.out.println(letter + " is not in the word");
			lives--;
			alive.setText("Round #:" + (wins+1) + " Lives: " + lives + "    ");
			if(lives < 1) {
				JOptionPane.showMessageDialog(null,"Game over, you completed " + wins + " rounds");
				if(JOptionPane.showInputDialog("Play Again? ('yes' or 'no')").equals("yes")){
					startGame();
				}
			}
		}else {
			System.out.println("Correct");
			if(!word.getText().contains("_")) {
				wins++;
				if(wins == Integer.parseInt(num)) {
					JOptionPane.showMessageDialog(null,"You win, you completed " + wins + " rounds");
					if(JOptionPane.showInputDialog("Play Again? ('yes' or 'no')").equals("yes")){
						startGame();
					}
				}else {
					JOptionPane.showMessageDialog(null,"starting round number " + (wins+1) + " of " + num);
					showWord();
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		guessLetter(e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
