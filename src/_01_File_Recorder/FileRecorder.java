package _01_File_Recorder;

import java.io.File;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
	
	File fr = new File(JOptionPane.showInputDialog(""));
	System.out.println(fr);
	}
}
