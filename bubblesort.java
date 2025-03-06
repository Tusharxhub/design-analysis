// ! wap to perfprm Bubble sort for any given list of numbers.

public class bubblesort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 7, 1, 3, 9, 4, 6 };
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


// ? Time Complexity: O(n^2)
// ? Space Complexity: O(1)