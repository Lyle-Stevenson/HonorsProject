package binPacking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class BPProblem {
	
	public ArrayList<Integer> problem;           // the data to be packed
	private int binCapacity;      // the capacity of each bin
	private int numberOfItems;    // number of items to pack
	private int numberOfBins;     // number of bins you have
	private String id;            // an idendification for the problem
	
	public BPProblem(String fname) throws Exception 
	{
		id = fname;
		problem = new ArrayList<Integer>();
		Scanner scanner = new Scanner(new File(fname));
		//String s = br.readLine();
		while (scanner.hasNextInt()) {
			problem.add(scanner.nextInt());
		}
	}
}
