package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	ArrayList<String> list = new ArrayList<String>();
	FileWriter fw;
	String r = "";
	String fileName = "";

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
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/save.txt"));
			String line = br.readLine();
			while (line != null) {
				list.add(line);
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(add)) {
			String input = JOptionPane.showInputDialog("What would you like to add to your to do list?");
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/save.txt", true);
				fw.write(input + "\n");
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(view)) {
			String end = getStringSave();
			JOptionPane.showMessageDialog(null, end);
		} else if (e.getSource().equals(remove)) {
			try {
				boolean found = false;
				String input = JOptionPane.showInputDialog("What would you like to remove from exsistace?");
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/save.txt"));
				String line = br.readLine();
				while (line != null) {
					if (line.equals(input)) {
						list.remove(input);
						String end = "";
						try {
							BufferedReader br2 = new BufferedReader(new FileReader("src/_03_To_Do_List/save.txt"));
							String line2 = br.readLine();
							while (line2 != null) {
								if(!line.equals(input)) {
								end = end + "\n" + line;
								}
								line2 = br2.readLine();
							}

							br2.close();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							FileWriter fw = new FileWriter("src/_03_To_Do_List/save.txt", false);
							fw.write(end);
							fw.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						found = true;
						break;
					}
					line = br.readLine();
				}
				br.close();
				if (found == false) {
					JOptionPane.showMessageDialog(null, "That couldn't be found in your to do list");
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(save)) {
			try {
				fw = new FileWriter("src/_03_To_Do_List/save.txt");
				fw.write(getStringSave());
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if (e.getSource().equals(load)) {
			list.clear();
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/save.txt"));
				String line = br.readLine();
				while (line != null) {
					list.add(line);
					line = br.readLine();
				}

				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}
	}

	String getStringSave() {
		String end = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/save.txt"));
			String line = br.readLine();
			while (line != null) {
				end = end + "\n" + line;
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return end;
	}
}
