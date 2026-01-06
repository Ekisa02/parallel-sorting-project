package com.parallel.sorting;


public interface SortingAlgorithm {
    // This method will sort an array
    void sort(int[] array);
    
    // This tells us the name of the algorithm
    String getName();
    
    // This tells us if it's parallel or sequential
    boolean isParallel();
    
    // This tells us how many threads/processes it uses
    int getThreadCount();
}