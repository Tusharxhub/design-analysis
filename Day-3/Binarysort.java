//! wap to perform binarysort for any given list of numbers.
public class Binarysort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 7, 1, 3, 9, 4, 6 };
        int n = arr.length;
        binarysort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void binarysort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = Math.abs(binarysearch(arr, 0, i - 1, key));
            for (int k = i - 1; k >= j; k--) {
                arr[k + 1] = arr[k];
            }
            arr[j] = key;
        }
    }

    public static int binarysearch(int[] arr, int l, int r, int key) {
        if (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == key) {
                return m;
            }
            if (arr[m] < key) {
                return binarysearch(arr, m + 1, r, key);
            }
            return binarysearch(arr, l, m - 1, key);
        }
        return l;
    }
    
}

//? Time Complexity: O(n^2)
//? Space Complexity: O(1)
