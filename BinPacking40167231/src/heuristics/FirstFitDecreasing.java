package heuristics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import binPacking.BPProblem;
import binPacking.Bin;

public class FirstFitDecreasing extends BinPackingHeuristic {
	
    public FirstFitDecreasing(ArrayList<Integer> p, int binSize) {
        super(p, binSize);
    }

    @Override
    public int getResult() {
        Collections.sort(in, Collections.reverseOrder()); // sort input by size (big to small)
        this.bins.add(new Bin(binSize)); // add first bin
        for (Integer currentItem : this.in) {
            // iterate over bins and try to put the item into the first one it fits into
            boolean putItem = false; // did we put the item in a bin?
            int currentBin = 0;
            while (!putItem) {
                if (currentBin == this.bins.size()) {
                    // item did not fit in last bin. put it in a new bin
                    Bin newBin = new Bin(this.binSize);
                    newBin.put(currentItem);
                    this.bins.add(newBin);
                    putItem = true;
                } else if (this.bins.get(currentBin).put(currentItem)) {
                    // item fit in bin
                    putItem = true;
                } else {
                    // try next bin
                    currentBin++;
                }
            }
        }
        return this.bins.size();
    }

    @Override
    public void printBestBins() {
        System.out.println("Bins:");
        if (this.bins.size() == this.in.size()) {
            System.out.println("each item is in its own bin");
        } else {
            for (Bin bin : this.bins) {
                System.out.println(bin.toString());
            }
        }
    }
}
