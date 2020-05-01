package knives.data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CSV implements Manipulatable {
	private static final CSV SINGLETON = new CSV();

	private CSV(){
	}

	public static CSV getInstance(){ return SINGLETON; }

	@Override
	@SuppressWarnings("unchecked")
	public <T> ArrayList<ArrayList<T>> parseTable(String input) throws FileNotFoundException{
		ArrayList<ArrayList<T>> returnValue = new ArrayList<ArrayList<T>>();
		for(String line : input.split(System.lineSeparator())){
			ArrayList<T> row = new ArrayList<T>();
			for(String cell : line.split(",")) row.add((T) cell);
			returnValue.add(row);
		}
		return returnValue;
	}

	@Override
	public <T> ArrayList<ArrayList<T>> parseTable(String name, String input) throws FileNotFoundException{
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> String convertTableToString(ArrayList<ArrayList<T>> table){
		StringBuilder builder = new StringBuilder();
		table.stream().forEach(row->{
			row.stream().forEach(cell->{
				builder.append(cell);
				if(cell != row.get(row.size() - 1)) builder.append(',');
			});
			builder.append(System.lineSeparator());
		});
		return builder.toString();
	}

	@Override
	public <T> String convertTableToString(String name, ArrayList<ArrayList<T>> table)
			throws FileNotFoundException,
			IOException{
		throw new UnsupportedOperationException();
	}
}
