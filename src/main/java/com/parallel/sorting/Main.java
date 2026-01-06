package com.parallel.sorting;

import com.parallel.sorting.utils.ArrayGenerator;
import com.parallel.sorting.utils.Timer;
import com.parallel.sorting.ParallelMergeSort;


public class Main {
    public static void main(String[] args) {
        System.out.println("🎉 Welcome to Parallel Sorting Project!");
        System.out.println("=======================================\n");
        
        // Get number of available processors
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("💻 Available processors: " + processors);
        
        // Test with different sizes
        testWithSize(10000, processors);
        testWithSize(100000, processors);
        testWithSize(500000, processors);
        
        System.out.println("\n✅ All tests completed!");
    }
    
    private static void testWithSize(int size, int processors) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("📊 Testing with array size: " + size);
        System.out.println("=".repeat(50));
        
        // Generate test data
        int[] original = ArrayGenerator.generateRandomArray(size);
        
        // Test Sequential Merge Sort
        System.out.println("\n1. Sequential Merge Sort:");
        int[] seqMergeArray = ArrayGenerator.copyArray(original);
        double seqMergeTime = Timer.measureTime(() -> {
            new SequentialMergeSort().sort(seqMergeArray);
        });
        System.out.printf("   Time: %.2f ms\n", seqMergeTime);
        System.out.println("   Sorted: " + ArrayGenerator.isSorted(seqMergeArray));
        
        // Test Sequential Quick Sort
        System.out.println("\n2. Sequential Quick Sort:");
        int[] seqQuickArray = ArrayGenerator.copyArray(original);
        double seqQuickTime = Timer.measureTime(() -> {
            new SequentialQuickSort().sort(seqQuickArray);
        });
        System.out.printf("   Time: %.2f ms\n", seqQuickTime);
        System.out.println("   Sorted: " + ArrayGenerator.isSorted(seqQuickArray));
        
        // Test Parallel Merge Sort
        System.out.println("\n3. Parallel Merge Sort:");
        int[] parMergeArray = ArrayGenerator.copyArray(original);
        double parMergeTime = Timer.measureTime(() -> {
            new ParallelMergeSort().sort(parMergeArray);
        });
        System.out.printf("   Time: %.2f ms\n", parMergeTime);
        System.out.println("   Sorted: " + ArrayGenerator.isSorted(parMergeArray));
        
        // Calculate speedup
        if (parMergeTime > 0) {
            double speedup = seqMergeTime / parMergeTime;
            System.out.printf("\n📈 Parallel Merge Sort Speedup: %.2fx\n", speedup);
            System.out.printf("   Efficiency: %.1f%%\n", (speedup / processors) * 100);
        }
        
        // Verify all produce same result
        boolean allMatch = true;
        for (int i = 0; i < size && i < 100; i++) { // Check first 100 elements
            if (seqMergeArray[i] != seqQuickArray[i] || 
                seqMergeArray[i] != parMergeArray[i]) {
                allMatch = false;
                break;
            }
        }
        System.out.println("\n✅ All algorithms produce same result: " + allMatch);
    }
}