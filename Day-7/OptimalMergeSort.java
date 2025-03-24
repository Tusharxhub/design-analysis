//! wap in java to perform Optimal merge sort.

import java.util.PriorityQueue;

class OptimalMergeSort {
    static int optimalMerge(int[] files) {
        // Create a priority queue to store the file sizes
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add all file sizes to the priority queue
        for (int file : files) {
            pq.add(file);
        }
        
        int totalCost = 0;
        
        // While there is more than one file in the queue
        while (pq.size() > 1) {
            // Remove the two smallest files
            int first = pq.poll();
            int second = pq.poll();
            
            // Merge the two files
            int mergeCost = first + second;
            
            // Add the merge cost to the total cost
            totalCost += mergeCost;
            
            // Add the merged file back to the queue
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
