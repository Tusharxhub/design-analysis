//! wap to find the maximum and minimum of the givn set of integers values.

import java.util.Arrays;

public class integer {
    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 2, 8, -1, 4, 10, 12};
        int max = Arrays.stream(numbers).max().getAsInt();
        int min = Arrays.stream(numbers).min().getAsInt();
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}

//? Time Complexity: O(n)
//? Space Complexity: O(1)