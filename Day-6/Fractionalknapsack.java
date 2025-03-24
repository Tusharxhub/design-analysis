//! wap in java to perform fractional knapsack

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight, value;
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Fractionalknapsack {

    static double getMaxValue(int W, Item[] items) {
        Arrays.sort(items, (o1, o2) -> {
            double r1 = (double) o1.value / o1.weight;
            double r2 = (double) o2.value / o2.weight;
            return Double.compare(r2, r1);
        });

        double totalValue = 0d;

        for (Item item : items) {
            int curWt = item.weight;
            int curVal = item.value;

            if (W - curWt >= 0) {
                W -= curWt;
                totalValue += curVal;
            } else {
                double fraction = ((double) W / (double) curWt);
                totalValue += (curVal * fraction);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
        int W = 50;

        System.out.println("Maximum value we can obtain = " + getMaxValue(W, items));
    }
}
