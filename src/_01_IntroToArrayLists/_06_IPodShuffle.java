package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		ArrayList<Song> songs = new ArrayList<>();
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton b = new JButton("Srprise Me!");
		frame.setVisible(true);
		frame.add(panel);
		panel.add(b);
		b.addActionListener(this);
		frame.pack();
					
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Song s = new Song("demo.mp3");
		s.play();
	}
}