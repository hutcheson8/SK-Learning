package knives.data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Python implements Manipulatable {
	private static final Python SINGLETON = new Python();

	private Python(){
	}

	public static Python getInstance(){ return SINGLETON; }

	@SuppressWarnings("unchecked")
	@Override
	public <T> ArrayList<ArrayList<T>> parseTable(String input) throws FileNotFoundException{
		ArrayList<ArrayList<T>> table = new ArrayList<ArrayList<T>>();
		input = Raw.findAndReplace(input, "\\[", "");
		input = Raw.findAndReplace(input, "\\]", "");
		for(int x = 0; x < 10; x++) input = Raw.findAndReplace(input, "  ", " ");
		for(String line : input.split(System.lineSeparator())){
			ArrayList<T> row = new ArrayList<T>();
			for(String cell : line.split(" ")) if(!cell.isEmpty()) row.add((T) cell);
			table.add(row);
		}
		return table;
	}

	@Override
	public <T> ArrayList<ArrayList<T>> parseTable(String name, String input) throws FileNotFoundException{
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> String convertTableToString(ArrayList<ArrayList<T>> table){
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> String convertTableToString(String name, ArrayList<ArrayList<T>> table)
			throws FileNotFoundException,
			IOException{
		StringBuilder output = new StringBuilder(name);
		output.append("=[");
		output.append(System.lineSeparator());
		table.stream().forEach(row->{
			output.append('[');
			row.stream().forEach(cell->{
				output.append(cell);
				if(cell != row.get(row.size() - 1)) output.append(',');
			});
			output.append("],");
			output.append(System.lineSeparator());
		});
		output.append("]");
		output.append(System.lineSeparator());
		return output.toString();
	}
}
