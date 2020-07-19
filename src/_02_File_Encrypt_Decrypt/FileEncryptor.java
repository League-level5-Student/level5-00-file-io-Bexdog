package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
	String Char = JOptionPane.showInputDialog("Please enter a letter");
	String encrypted =  "";
	try {
		BufferedReader br = new BufferedReader(new FileReader("src/_00_Intro_To_File_Input_and_Output/test2.txt"));
		
		String line = br.readLine();
		while(line != null){			
			encrypted =  Utilities.encrypt(line.getBytes(), (byte) Char.charAt(0));
			
			line = br.readLine();
		}
		JOptionPane.showMessageDialog(null, encrypted);
	FileWriter fw;
	try {
		fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt");
		fw.write(encrypted);
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
}
