//! wap to perform quicksort for any given list of numbers.


public class Quicksort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 7, 1, 3, 9, 4, 6 };
        int n = arr.length;
        quicksort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quicksort(arr, l, p - 1);
            quicksort(arr, p + 1, r);
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }
    
}


//? Time Complexity: O(n^2)
//? Space Complexity: O(1)