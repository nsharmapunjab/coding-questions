package sdetinterviewquestions4;

import java.util.*;

public class MedianFinder {
    // Max heap to store the smaller half
    private PriorityQueue<Integer> maxHeap;
    // Min heap to store the larger half
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // Max heap (invert the natural order)
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min heap (natural order)
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to maxHeap first
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Step 2: Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // Step 3: Compute median
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    // Optional: for debugging
    public void printHeaps() {
        System.out.println("MaxHeap: " + maxHeap);
        System.out.println("MinHeap: " + minHeap);
    }

    // Main for testing
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        int[] stream = {5, 15, 1, 3};

        for (int num : stream) {
            mf.addNum(num);
            System.out.println("Added: " + num + ", Current Median: " + mf.findMedian());
        }
    }
}