package knives.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Raw {
	public static String fileContents(String filename) throws IOException{
		String returnValue;
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(filename));
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		for(int x = input.read(); x != -1; x = input.read()) output.write(x);
		returnValue = output.toString();
		output.close();
		input.close();
		return returnValue;
	}

	public static PrintStream fileOutputPrintStream(String filename) throws FileNotFoundException{
		return new PrintStream(new BufferedOutputStream(new FileOutputStream(filename)));
	}

	public static Scanner fileInputScanner(String filename) throws FileNotFoundException{
		return new Scanner(new BufferedInputStream(new FileInputStream(filename)));
	}

	public static String findAndReplace(String source, String find, String replaceWith){
		StringBuilder returnValue = new StringBuilder();
		String[] pieces = source.split(find);
		for(String piece : pieces){
			if(piece != pieces[0]) returnValue.append(replaceWith);
			returnValue.append(piece);
		}
		return returnValue.toString();
	}
}
