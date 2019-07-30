package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements MouseListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	JFrame f;
	JPanel p;
	JButton add;
	JButton search;
	JButton view;
	JButton remove;
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	
	public static void main(String[] args) {
		_02_LogSearch search = new _02_LogSearch();
		search.makeGUI();
	}
	
	public void makeGUI() {
		f = new JFrame();
		p = new JPanel();
		add = new JButton("Add Entry");
		search = new JButton("Search by ID");
		view = new JButton("View List");
		remove = new JButton("Remove Entry");
		add.addMouseListener(this);
		search.addMouseListener(this);
		view.addMouseListener(this);
		remove.addMouseListener(this);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.add(add);
		p.add(search);
		p.add(view);
		p.add(remove);
		f.add(p);
		f.pack();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			String id = JOptionPane.showInputDialog("enter an ID number");
			String name = JOptionPane.showInputDialog("enter an name");
			map.put(Integer.parseInt(id), name);
		}
		if(e.getSource() == search) {
			String id = JOptionPane.showInputDialog("enter an ID number");
			if(map.containsKey(Integer.parseInt(id))){
				JOptionPane.showMessageDialog(null, map.get(Integer.parseInt(id)));
			} else {
				JOptionPane.showMessageDialog(null, "that entry does not exist.");
			}
		}
		if(e.getSource() == view) {
			String list = "";
			for(Integer m : map.keySet()){
				list += "ID: " + m + " Name: " + map.get(m) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
		if(e.getSource() == remove) {
			String r = JOptionPane.showInputDialog("enter an ID number");
			if(map.containsKey(Integer.parseInt(r))){
				map.remove(Integer.parseInt(r));
			} else {
				JOptionPane.showMessageDialog(null, "that entry does not exist.");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
