package com.parallel.sorting.utils;

public class Timer {
    private long startTime;
    private long endTime;
    
    public void start() {
        startTime = System.nanoTime();
    }
    
    public void stop() {
        endTime = System.nanoTime();
    }
    
    public long getElapsedTime() {
        return endTime - startTime;
    }
    
    public double getElapsedTimeMillis() {
        return getElapsedTime() / 1_000_000.0;
    }
    
    public double getElapsedTimeSeconds() {
        return getElapsedTime() / 1_000_000_000.0;
    }
    
    // ADD THIS STATIC METHOD
    public static double measureTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000.0; // Return milliseconds
    }
}