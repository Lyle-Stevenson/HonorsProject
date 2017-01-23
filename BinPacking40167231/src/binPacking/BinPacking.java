package binPacking;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Population.Chromosome;
import heuristics.*;


public class BinPacking {

    public static void main(String[] args)  throws Exception{
    	
		ArrayList<Chromosome> initial_Chromosomes= new ArrayList<Chromosome>();
		ArrayList<Integer> initial_Problems= new ArrayList<Integer>();
		
		for(int i = 0; i < 2; i ++)
		{
			Chromosome chromosome = new Chromosome(5,10,20,100);
			chromosome.generateChromosome();
			initial_Chromosomes.add(chromosome);
		}
		
		for(Chromosome chromo: initial_Chromosomes)
		{
			printChromosome(chromo);
			FirstFitDecreasing  ffd = new FirstFitDecreasing(chromo.getChromosome_Problem(),100);
			testBinPacking(ffd, "First Fit Decreasing");
			
			BestFitDecending  bfd = new BestFitDecending(chromo.getChromosome_Problem(),100);
			testBinPacking(bfd, "Best Fit Decreasing");
		}
    }

    private static void testBinPacking(BinPackingHeuristic algo, String algoName) {
        long startTime;
        long estimatedTime;

        startTime = System.currentTimeMillis();
        System.out.println("Needed bins (" + algoName + "): " + algo.getResult());
        algo.printBestBins();
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("in " + estimatedTime + " ms");
        System.out.println("Fitness: " + algo.fitness_Cost());
        System.out.println("\n\n");
    }
    
    public static void printChromosome(Chromosome chromo){
    	
    		System.out.print("Problem: ");
    		chromo.print_ChromosomeProblem();
    		System.out.println("Chromosome: ");	
    		chromo.print_Chromosome();
    		System.out.println("");
    	}
    }
    
