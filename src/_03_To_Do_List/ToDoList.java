package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	 /*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	ArrayList <String> list = new ArrayList <String>();
	public static void main(String[] args) {
		ToDoList l = new ToDoList();
		l.start();
	}
	void start() {
		frame = new JFrame();
		panel = new JPanel();
		add = new JButton();
		view = new JButton();
		remove = new JButton();
		save = new JButton();
		load = new JButton();
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		add.setText("Add");
		view.setText("View");
		remove.setText("Remove");
		save.setText("Save");
		load.setText("Load");
		panel.add(view);
		panel.add(add);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(add)) {
			String input = JOptionPane.showInputDialog("What would you like to add to your to do list?");
			list.add(input+"\n");
		}
		else if(e.getSource().equals(view)) {
			//Work on this next
		}
		else if(e.getSource().equals(remove)) {
			boolean found = false;
			String input = JOptionPane.showInputDialog("What would you like to remove from exsistace?");
			for(int i = 0; i<list.size();i++) {
				if(list.get(i).equals(input+"\n")) {
					list.remove(i);
					found = true;
					break;
				}
			}
			if(found ==false) {
				JOptionPane.showMessageDialog(null, "That couldn't be found");
			}
		}
		else if(e.getSource().equals(save)) {
	
		}
		else if(e.getSource().equals(load)) {
	
		}
	}
}
