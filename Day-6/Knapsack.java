//!  wap in java 0/1 knapsack both greedy and dynamic.

import java.util.Arrays;

class Item {
    int weight, value;
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Knapsack {
    static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        double totalValue = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += (double) item.value * capacity / item.weight;
                break;
            }
        }
        return totalValue;
    }

    static int knapsackDP(Item[] items, int capacity) {
        int n = items.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (items[i - 1].weight <= w) {
                    dp[i][w] = Math.max(items[i - 1].value + dp[i - 1][w - items[i - 1].weight], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
        int capacity = 50;
        System.out.println("Greedy Approach Value: " + fractionalKnapsack(items, capacity));
        System.out.println("Dynamic Programming Approach Value: " + knapsackDP(items, capacity));
    }
}
