package Population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import binPacking.Bin;

public class Chromosome {

	protected int numberOfBins;
	
	protected int itemsPerBin;
	
	protected int maxItemSize;
	
	protected int binSize;
	
	private ArrayList<Integer> chromosome_Problem = new ArrayList<Integer>();
	ArrayList<Bin> chromosome = new ArrayList<Bin>();
	
	
	public Chromosome(int numberOfBins, int itemsPerBin, int maxItemSize, int binSize){
		
		this.numberOfBins = numberOfBins;
		this.itemsPerBin = itemsPerBin;
		this.maxItemSize = maxItemSize;
		this.binSize = binSize;
	}
	
	public void generateChromosome()
	{	
		Random generator = new Random();
		for( int i = 0; i < this.numberOfBins; i++)
		{		
			int total = 0;
			ArrayList<Integer> items = new ArrayList<Integer>();
			Bin bin = new Bin(this.binSize);
			int maxItems = generator.nextInt(this.itemsPerBin)+1;
				for(int j = 0; j < maxItems; j ++){
					int item  = generator.nextInt(this.maxItemSize-1)+1;
					items.add(item);
					total = total + item;
				}
			int sizeTotal = 0;
			for(int j = 0; j < items.size()-1; j ++)
			{
			int itemSize = Math.round((items.get(j) * this.binSize) / total);
			sizeTotal = sizeTotal + itemSize;
			bin.put(itemSize);
			this.getChromosome_Problem().add(itemSize);
			}
			int lastItem = 100 - sizeTotal;
			bin.put(lastItem);
			this.getChromosome_Problem().add(lastItem);
			bin.sortDecs();
			this.chromosome.add(bin);
		}
	}
	
	public void print_Chromosome() {
       for(Bin bin: this.chromosome)
       {
    	   System.out.println(bin.toString());
       }
    }
	
	public void print_ChromosomeProblem() {
	       for(Integer i: this.getChromosome_Problem())
	       {
	    	   System.out.print(i + " ");
	       }
	       System.out.println("");
	    }

	public ArrayList<Integer> getChromosome_Problem() {
		return chromosome_Problem;
	}

}
