package knives.sk.learning;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import knives.data.CSV;
import knives.data.Python;
import knives.data.Raw;

public class Compile {
	private static final Python PYTHON = Python.getInstance();
	private static final CSV C_S_V = CSV.getInstance();

	public static void main(String[] args) throws IOException{
		PrintStream output = Raw.fileOutputPrintStream("out/out.py");
		output.println(Raw.fileContents("src/python/imports.py"));
		ArrayList<ArrayList<String>> trainingFeatures
				= C_S_V.parseTable(Raw.fileContents("data/Spiral Knights Data - Training Features.csv"));
		int inputDim = trainingFeatures.get(0).size();
		output.println(PYTHON.convertTableToString("trainingFeatures", trainingFeatures));
		output
				.println(
						PYTHON
								.convertTableToString(
										"trainingTargets",
										C_S_V
												.parseTable(
														Raw
																.fileContents(
																		"data/Spiral Knights Data - Training Targets.csv"))));
		output
				.println(
						PYTHON
								.convertTableToString(
										"predictionFeatures",
										C_S_V
												.parseTable(
														Raw
																.fileContents(
																		"data/Spiral Knights Data - Prediction Features.csv"))));
		output.println(Raw.findAndReplace(Raw.fileContents("src/python/learn.py"), "INPUTDIM", String.valueOf(inputDim)));
		output.close();
	}
}
