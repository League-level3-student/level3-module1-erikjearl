package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame f;
	JPanel p;
	JLabel l;
	Stack<String> stck;
	public static void main(String[] args) {
		_02_TextUndoRedo t = new _02_TextUndoRedo();
		t.start();
	}
	
	public void start() {
		f = new JFrame();
		p = new JPanel();
		l = new JLabel(" ");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		p.add(l);
		f.setSize(300,200);
		
		f.addKeyListener(this);
		stck = new Stack<String>();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() !=  KeyEvent.VK_BACK_SPACE && e.getKeyChar() !=  KeyEvent.VK_MINUS) {
			l.setText(l.getText() + e.getKeyChar());
		}
		System.out.println(l.getText());
		System.out.println(stck);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() ==  KeyEvent.VK_BACK_SPACE && l.getText().length() > 0) { //delete
			String s = l.getText();
			stck.push(s.substring(s.length()-1, s.length()));
			l.setText(s.substring(0,s.length()-1));
		}
		if(e.getKeyCode() == KeyEvent.VK_MINUS && stck.size() > 0) { //undo
			l.setText(l.getText()+stck.pop());
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
