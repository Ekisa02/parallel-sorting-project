package com.parallel.sorting;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort implements SortingAlgorithm {
    
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSortTask(array, 0, array.length - 1));
        pool.shutdown();
    }
    
    @Override
    public String getName() {
        return "Parallel Merge Sort";
    }
    
    @Override
    public boolean isParallel() {
        return true;
    }
    
    @Override
    public int getThreadCount() {
        return Runtime.getRuntime().availableProcessors();
    }
    
    // Inner class for ForkJoin tasks
    private static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int low;
        private final int high;
        private static final int THRESHOLD = 5000; // Use sequential for small arrays
        
        MergeSortTask(int[] array, int low, int high) {
            this.array = array;
            this.low = low;
            this.high = high;
        }
        
        @Override
        protected void compute() {
            if (high - low <= THRESHOLD) {
                // Small array - sort sequentially
                sequentialMergeSort(array, low, high);
            } else {
                int mid = low + (high - low) / 2;
                
                // Create subtasks
                MergeSortTask leftTask = new MergeSortTask(array, low, mid);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, high);
                
                // Fork both tasks (run in parallel)
                invokeAll(leftTask, rightTask);
                
                // Merge results
                merge(array, low, mid, high);
            }
        }
        
        private void sequentialMergeSort(int[] array, int low, int high) {
            if (low < high) {
                int mid = low + (high - low) / 2;
                sequentialMergeSort(array, low, mid);
                sequentialMergeSort(array, mid + 1, high);
                merge(array, low, mid, high);
            }
        }
        
        private void merge(int[] array, int low, int mid, int high) {
            int[] temp = new int[high - low + 1];
            int i = low, j = mid + 1, k = 0;
            
            while (i <= mid && j <= high) {
                if (array[i] <= array[j]) {
                    temp[k++] = array[i++];
                } else {
                    temp[k++] = array[j++];
                }
            }
            
            while (i <= mid) {
                temp[k++] = array[i++];
            }
            
            while (j <= high) {
                temp[k++] = array[j++];
            }
            
            // Copy back to original array
            System.arraycopy(temp, 0, array, low, temp.length);
        }
    }
}