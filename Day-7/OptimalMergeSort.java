//! wap in java to perform Optimal merge sort.

import java.util.PriorityQueue;

class OptimalMergeSort {
    static int optimalMerge(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int file : files) pq.add(file);
        int totalCost = 0;
        while (pq.size() > 1) {
            int mergeCost = pq.poll() + pq.poll();
            totalCost += mergeCost;
            pq.add(mergeCost);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] files = {4, 3, 2, 6};
        System.out.println("Minimum cost to merge files: " + optimalMerge(files));
    }
}





// ? To perform enter the following command:
// ? javac OptimalMergeSort.java
//? java OptimalMergeSort





//? Time Complexity: O(n log n)
//? Space Complexity: O(n)