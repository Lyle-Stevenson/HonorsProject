package heuristics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import binPacking.BPProblem;
import binPacking.Bin;

public class DJD extends BinPackingHeuristic{
	 
	private List<Bin> bins = new ArrayList<Bin>();
	
	public DJD(ArrayList<Integer> p, int binSize) {
	        super(p, binSize);
	    }

	@Override
	public int getResult() {	
		
	/*	 Collections.sort(in, Collections.reverseOrder()); // sort input by size (big to small)
		 bins.add(new Bin(binSize)); // add first bin
		 int currentBin = 0;
		 ArrayList<Integer> itemsLeft = new ArrayList<Integer>();//Creates an array of all items left to be packed in the problem
		 for(Integer item : in){ //Adds the items in the problem to the to be packed list
			 itemsLeft.add(item);
		 }
		 while(itemsLeft.size() > 0){
			 ArrayList<Integer> someItems = new ArrayList<Integer>();//Creates an array of all items left to be packed in the problem
			 for(Integer item : in){ //Adds the items in the problem to the to be packed list
				 someItems.add(item);
			 }
			for (Integer item : someItems) {
					count++;
					int lastItemPlaceIdx = 0;
		//			System.out.println("" + count);
					if (bin.getBinLength() + item.getLength() <= getProblem().getPr_capacity()
							&& itemsLeft.contains(item)) {
						bin.getItems().add(item);
						lastItemPlaceIdx = itemsLeft.indexOf(item);
						itemsLeft.remove(item);				
					}
					// System.out.println("items Left : " + itemsLeft.size());
					if (bin.getBinLength() >= getProblem().getPr_capacity() / 3) {
						int offset = 0;
						boolean found = false;
						while (getProblem().getPr_capacity() - bin.getBinLength() - offset > 0 && !found && !isForcedStop()) {
							// System.out.println("offset: " + offset);
							// try to find 1 item that fills bin
							Item fillItem = null;
							//quicker in reverse and breaks when each loop impossible
							loop: for (int i = itemsLeft.size()-1; i >= lastItemPlaceIdx; i--) {
								if (itemsLeft.get(i).getLength() == getProblem().getPr_capacity()
										- bin.getBinLength() - offset) {
									fillItem = itemsLeft.get(i);
									break loop;
								}else if(itemsLeft.get(i).getLength() > getProblem().getPr_capacity()
										- bin.getBinLength() - offset) {								
									break loop;
									
								}
							}
							if (fillItem != null) {
								itemsLeft.remove(fillItem);
								bin.getItems().add(fillItem);
								found = true;
							} else if (itemsLeft.size() > 1) {
								// try to find 2 items that fill bin
								ArrayList<Item> fillItems = new ArrayList<Item>();
								loop: for (int i = itemsLeft.size()-2; i >= lastItemPlaceIdx; i--) {
									if(itemsLeft.get(i).getLength() > getProblem().getPr_capacity()
											- bin.getBinLength() - offset) {								
										break loop;									
									}
									for (int j = itemsLeft.size()-1; j > i; j--) {
										int size = itemsLeft.get(i).getLength()
												+ itemsLeft.get(j).getLength();
										if (size == getProblem().getPr_capacity() - bin.getBinLength()
												- offset) {
											fillItems.add(itemsLeft.get(i));
											fillItems.add(itemsLeft.get(j));
											break loop;
										}else if(size > getProblem().getPr_capacity() - bin.getBinLength()
												- offset) {
											break;
										}
									}
								}
								if (fillItems.size() != 0) {
									for (Item item1 : fillItems) {
										bin.getItems().add(item1);
										itemsLeft.remove(item1);
										found = true;
									}
								}else if (itemsLeft.size() > 2) {
									// try to find 3 items that fill bin
									
									loop: for (int i = itemsLeft.size()-3; i >= lastItemPlaceIdx; i--) {
										if(itemsLeft.get(i).getLength() > getProblem().getPr_capacity()
												- bin.getBinLength() - offset) {								
											break loop;									
										}
										for (int j = itemsLeft.size()-2; j > i; j--) {
											int size = itemsLeft.get(i).getLength() + itemsLeft.get(j).getLength();
											if(size > getProblem().getPr_capacity() - bin.getBinLength() - offset) {
												break;
											}
											for (int k = itemsLeft.size()-1; k > j; k--) {
												size = size + itemsLeft.get(k).getLength();
												if (size == getProblem().getPr_capacity() - bin.getBinLength()
														- offset) {
													fillItems.add(itemsLeft.get(i));
													fillItems.add(itemsLeft.get(j));
													fillItems.add(itemsLeft.get(k));
													break loop;
												}else if(size > getProblem().getPr_capacity() - bin.getBinLength() - offset) {
													break;
												}
											}
										}
									}
									if (fillItems.size() != 0) {
										for (Item item1 : fillItems) {
											bin.getItems().add(item1);
											itemsLeft.remove(item1);
											found = true;
										}
									}
								}
							} 
							offset++;
							//System.out.println("" + offset);
						}// end while
						
						individual.getBins().add(bin);					
						//System.out.println("Bin " + individual.getBins().size() + " Added with " + bin.getItems().size() + " items Number of items left= " + itemsLeft.size());
						bin = new Bin();
						break outerFor; 
					}
		
				}*/
			 
		// System.out.println(in);
		 //System.out.println(itemsLeft);
		 return 0;
	}

	@Override
	public void printBestBins() {
		// TODO Auto-generated method stub
		
	}

}
