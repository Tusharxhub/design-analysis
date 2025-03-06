//! wap to perform   margesort for any given list of numbers.


public class Margesort {
    
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 7, 1, 3, 9, 4, 6 };
        int n = arr.length;
        margesort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void margesort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            margesort(arr, l, m);
            margesort(arr, m + 1, r);
            marges(arr, l, m, r);
        }
    }

    public static void marges(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
}


//? Time Complexity: O(nlogn) in all cases
//? Space Complexity: O(n)