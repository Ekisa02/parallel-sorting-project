package com.parallel.sorting.utils;

import java.util.Random;

public class ArrayGenerator {
    private static final Random random = new Random();
    
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }
        return array;
    }
    
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }
    
    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
    
    public static int[] generatePartiallySortedArray(int size, double sortedPercentage) {
        int[] array = generateSortedArray(size);
        int elementsToShuffle = (int)(size * (1 - sortedPercentage));
        for (int i = 0; i < elementsToShuffle; i++) {
            int idx1 = random.nextInt(size);
            int idx2 = random.nextInt(size);
            int temp = array[idx1];
            array[idx1] = array[idx2];
            array[idx2] = temp;
        }
        return array;
    }
    
    // ADD THIS METHOD
    public static int[] copyArray(int[] original) {
        if (original == null) return null;
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }
    
    public static boolean isSorted(int[] array) {
        if (array == null || array.length <= 1) return true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    // Optional: Print first few elements for debugging
    public static void printFirstElements(int[] array, int count) {
        System.out.print("First " + count + " elements: [");
        for (int i = 0; i < Math.min(count, array.length); i++) {
            System.out.print(array[i]);
            if (i < Math.min(count, array.length) - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}