package knives.sk.learning;

import java.io.IOException;
import java.io.PrintStream;

import knives.data.CSV;
import knives.data.Manipulatable;
import knives.data.Python;
import knives.data.Raw;

public class Aggregate {
	private static final Manipulatable PYTHON = Python.getInstance();
	private static final CSV C_S_V = CSV.getInstance();

	public static void main(String[] args) throws IOException{
		PrintStream output = Raw.fileOutputPrintStream("out.csv");
		output.println(C_S_V.convertTableToString(
				PYTHON.parseTable(Raw.fileContents("out.log").split("PREDICTIONS START" + System.lineSeparator())[1])));
		output.close();
	}
}
