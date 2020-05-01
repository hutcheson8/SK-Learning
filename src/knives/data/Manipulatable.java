package knives.data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Manipulatable {
	public abstract <T> ArrayList<ArrayList<T>> parseTable(String input) throws FileNotFoundException;
	public abstract <T> ArrayList<ArrayList<T>> parseTable(String name, String input)
			throws FileNotFoundException;
	public abstract <T> String convertTableToString(ArrayList<ArrayList<T>> table);
	public abstract <T> String convertTableToString(String name, ArrayList<ArrayList<T>> table)
			throws FileNotFoundException,
			IOException;
}
