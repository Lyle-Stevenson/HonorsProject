package heuristics;

import java.util.ArrayList;
import java.util.List;

import binPacking.BPProblem;
import binPacking.Bin;

public abstract class BinPackingHeuristic {

    protected ArrayList<Integer> in;
    protected int binSize;
    protected List<Bin> bins = new ArrayList<Bin>();

    public BinPackingHeuristic(ArrayList<Integer> p, int binSize) {
        this.in = p;
        this.binSize = binSize;
    }

    /**
     * runs algorithm and returns minimum number of needed bins.
     *
     * @return minimum number of needed bins
     */
    public abstract int getResult();

    /**
     * print the best bin packing determined by getResult().
     */
    public abstract void printBestBins();

    public List<Bin> deepCopy(List<Bin> bins) {
        ArrayList<Bin> copy = new ArrayList<Bin>();
        for (int i = 0; i < bins.size(); i++) {
            copy.add(bins.get(i).deepCopy());
        }
        return copy;
    }
    
    public double fitness_Cost()
    {
    	double cost = 0;
    	
    	
    	for(Bin bin: bins)
    	{
    		double fill = 0;
    		for(Integer in: bin.getItems())
    		{
    			fill = fill + in;
    		}
    		fill = Math.pow((fill/this.binSize), 2);
    		cost = cost + fill;
    	}
    	cost = cost / bins.size();
    	
    	return cost;
    }
}
