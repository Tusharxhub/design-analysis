//! wap in java to perform fractional knapsack

import java.util.Arrays;

class Item {
    int weight, value;
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Fractionalknapsack {

    static double getMaxValue(int W, Item[] items) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        double totalValue = 0;
        for (Item item : items) {
            if (W == 0) break;
            int curWt = Math.min(item.weight, W);
            totalValue += curWt * ((double) item.value / item.weight);
            W -= curWt;
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
        int W = 50;
        System.out.println("Maximum value we can obtain = " + getMaxValue(W, items));
    }
}
+
